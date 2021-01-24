package com.epam.training.jdbc;

import static com.epam.training.jdbc.SQLConstant.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.epam.training.jdbc.entity.Product;
import com.epam.training.jdbc.entity.Receipt;
import com.epam.training.jdbc.entity.ReceiptProducts;

public class DBManager {

	// WARN: You should specify connection properties in an external location
	// such as configuration file
	private static final String USER = "root";
	private static final String PASSWORD = "qwerty";
	// sslMode: since MySQL 8.0.13.
	// for MySQL versions earlier 8.0.13 use useSSL property instead
	private static final String BASE_URL = "jdbc:postgresql://localhost:5432/shop";
	private static final String URL_PROPERTIES = "sslMode=DISABLED&serverTimezone=UTC";
	private static final String URL_CREDENTIALS = "user=" + USER + "&password=" + PASSWORD;
	private static final String URL = BASE_URL + "?" + URL_PROPERTIES + "&" + URL_CREDENTIALS;

	private static DBManager instance;

	public static synchronized DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}

	private DBManager() {
		// nothing to do
	}

	/////////////////////////

	public Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(URL);
//		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
		return con;
	}

	////////////////////////////

	public List<Product> findAllProducts() throws SQLException {
		List<Product> products = new ArrayList<>();

		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(SQL_FIND_ALL_PRODUCTS);) {

			while (rs.next()) {
				products.add(mapProduct(rs));
			}
		} catch (SQLException ex) {
			// (1) write to log
			ex.printStackTrace();
			// log.error("Cannot obtain a product by login", ex);

			// (2)
			throw ex;
		}
		return products;
	}

	public List<Product> findProductsByName(String name) throws DBException {
		List<Product> products = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQL_FIND_PRODUCT_BY_NAME);

			int k = 1;
			pstmt.setString(k++, "%" + escapeForLike(name) + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				products.add(mapProduct(rs));
			}
		} catch (SQLException ex) {
			// (1) write to log
			ex.printStackTrace();
			// log.error("Cannot obtain a product by login", ex);

			// (2)
			throw new DBException("Cannot get a product by name ", ex);
		} finally {
			// Sonar warning
			// create and use separate methods to close each specific type of resource
			close(rs);
			close(pstmt);
			close(con);
		}
		return products;
	}

	public boolean addProduct(Product product) throws SQLException {
		boolean res = false;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQL_ADD_NEW_PRODUCT, Statement.RETURN_GENERATED_KEYS);

			int k = 1;
			pstmt.setString(k++, product.getName());
			pstmt.setString(k++, product.getDescription());
			pstmt.setInt(k++, product.getAmount());
			pstmt.setDouble(k++, product.getPrice());
			long cid = product.getCategoryId();
			if (cid == 0) {
				pstmt.setNull(k++, Types.INTEGER);
			} else {
				pstmt.setLong(k++, product.getCategoryId());
			}

			if (pstmt.executeUpdate() > 0) {
				rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					product.setId(rs.getLong(1));
					res = true;
				}
			}
		} catch (SQLException ex) {
			// (1) write to log
			ex.printStackTrace();

			// (2)
			throw ex;
		} finally {
			close(rs);
			close(pstmt);
			close(con);
		}
		return res;
	}

	public boolean addReceipt(Receipt receipt, ReceiptProducts... products) throws SQLException {
		boolean res = false;

		Connection con = null;
		try {
			con = getConnection();
			con.setAutoCommit(false);
			con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

			long id = addReceipt(con, receipt);
			for (ReceiptProducts p : products) {
				addProductForReceipt(con, id, p.getProductId(), p.getCount());
			}
			con.commit();
			receipt.setId(id);
		} catch (SQLException ex) {
			// (1) write to log
			con.rollback();
			// (2)
			throw ex;
		} finally {
			close(con);
		}
		return res;
	}

	private long addReceipt(Connection con, Receipt receipt) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(SQL_ADD_NEW_RECEIPT, Statement.RETURN_GENERATED_KEYS);

			int k = 1;
			pstmt.setString(k++, receipt.getDescription());
			pstmt.setLong(k++, receipt.getStatusId());

			if (pstmt.executeUpdate() > 0) {
				rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					return rs.getLong(1);
				}
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return 0;
	}

	private void addProductForReceipt(Connection con, long id, long product, int count) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(SQL_ADD_PRODUCT_FOR_RECEIPT);

			int k = 1;
			pstmt.setLong(k++, id);
			pstmt.setLong(k++, product);
			pstmt.setInt(k++, count);

			pstmt.executeUpdate();
		} finally {
			close(rs);
			close(pstmt);
		}
	}

	public boolean deleteProduct(long productId) throws DBException {
		boolean res = false;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQL_DELETE_PRODUCT);

			int k = 1;
			pstmt.setLong(k++, productId);

			res = pstmt.executeUpdate() > 0;
		} catch (SQLException ex) {
			// (1) write to log
			ex.printStackTrace();

			// (2)
			throw new DBException("Cannot delete a product with id:" + productId, ex);
		} finally {
			close(pstmt);
			close(con);
		}
		return res;

	}

	//////////////////////
	// utils

	private Product mapProduct(ResultSet rs) throws SQLException {
		Product product = new Product();
		product.setId(rs.getInt(ID));
		product.setName(rs.getString(PRODUCT_NAME));
		product.setDescription(rs.getString(PRODUCT_DESCRIPTION));
		product.setAmount(rs.getInt(PRODUCT_AMOUNT));
		product.setPrice(rs.getInt(PRODUCT_PRICE));
		product.setCreateDate(rs.getDate(CREATE_DATE));
		product.setLastUpdate(rs.getDate(LAST_UPDATE));
		return product;
	}

	private void close(AutoCloseable ac) {
		if (ac != null) {
			try {
				ac.close();
			} catch (Exception ex) {
				throw new IllegalStateException("Cannot close " + ac);
			}
		}
	}

	/*
	 * Each data which received from UI should be escaped This is example how to do
	 * it for LIKE operator
	 */
	static String escapeForLike(String param) {
		return param.replace("!", "!!").replace("%", "!%").replace("_", "!_").replace("[", "![");
	}

}
