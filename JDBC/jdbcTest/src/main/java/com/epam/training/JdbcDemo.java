package com.epam.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.epam.training.jdbc.DBException;
import com.epam.training.jdbc.DBManager;
import com.epam.training.jdbc.entity.Product;
import com.epam.training.jdbc.entity.Receipt;
import com.epam.training.jdbc.entity.ReceiptProducts;
import org.postgresql.ds.PGSimpleDataSource;

public class JdbcDemo {
	static final String URL = "jdbc:postgresql://localhost:5432/shop"
			+ "?sslMode=DISABLED&serverTimezone=UTC&user=root&password=qwerty";

	public static void main(String[] args) throws SQLException, DBException {
		testConnection();
		testConnectionPool();
		
		DBManager dbm = DBManager.getInstance();
		
		List<Product> products;
		products = dbm.findAllProducts();
		System.out.println(products);

		products = dbm.findProductsByName("Fa");
		System.out.println(products);
		
		Product product = Product.createProduct("New Product", 2, 2.50);
		System.out.println("Just created " + product);
		dbm.addProduct(product);
		System.out.println("Just inserted " + product);
		products = dbm.findProductsByName("New Product");
		System.out.println("Just found " + products);

		dbm.deleteProduct(product.getId());
		
		Receipt receipt = Receipt.createReceipt("Some", 1);
		ReceiptProducts[] rp = new ReceiptProducts[] {new ReceiptProducts(1, 2), new ReceiptProducts(2, 1), };
		dbm.addReceipt(receipt, rp);
	}

	public static void testConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL);
			System.out.println("Connected successfully");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
			}
		}
	}
	public static void testConnectionPool() {
		PGSimpleDataSource source = new PGSimpleDataSource();

		source.setDatabaseName("shop");
		source.setUser("root");
		source.setPassword("qwerty");

		try (Connection con = source.getConnection()) {
			System.out.println("Connected successfully (pool)");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
}
