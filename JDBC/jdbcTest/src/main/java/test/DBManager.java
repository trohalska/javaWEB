package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epam.training.jdbc.entity.Product;

public class DBManager {
	static private DBManager instance;

	private DBManager() {
		super();
	}

	public static synchronized DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}

	static final String URL = "jdbc:postgresql://localhost:5432/shop";
	static final String USER = "root";
	static final String PASS = "qwerty";

	Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASS);
	}

	public List<Product> findAllProducts() throws DBException {
		List<Product> products = new ArrayList<Product>();
		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(Constants.FIND_ALL_PRODUCTS);) {
			while (rs.next()) {
				products.add(mapProduct(rs));
			}
			
		} catch (SQLException e) {
			// log
			System.out.println(e.getMessage());
			// throw exception
			throw new DBException("Can't get products", e);
		}
		return products;

	}
	
	public List<Product> findProductsByName(String pattern) throws DBException {
		List<Product> products = new ArrayList<Product>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			stmt = con.prepareStatement(Constants.FIND_PRODUCTS_BY_NAME);
			stmt.setString(1, pattern);
			rs = stmt.executeQuery();
			while (rs.next()) {
				products.add(mapProduct(rs));
			}
			
		} catch (SQLException e) {
			// log
			System.out.println(e.getMessage());
			// throw exception
			throw new DBException("Can't get products", e);
		} finally {
			close(rs);
			close(stmt);
			close(con);
		}
		return products;
	}

	void close(AutoCloseable ac) {
		if (ac != null) {
			try {
				ac.close();
			} catch (Exception e) {
				// nothing
			}
		}
	}

	public Product mapProduct(ResultSet rs) throws SQLException {
		Product p = new Product();
		p.setId(rs.getLong(Constants.FIELD_ID));
		p.setAmount(rs.getInt(Constants.FILED_RODUCT_AMOUNT));
		p.setName(rs.getString(Constants.FILED_RODUCT_NAME));
		return p;
	}
}
