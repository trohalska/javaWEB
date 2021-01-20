package com.epam.training.jdbc.dao.mysql;

import java.sql.SQLException;
import java.util.List;

import com.epam.training.jdbc.dao.OrderDAO;
import com.epam.training.jdbc.entity.Receipt;

public class MySqlOrderDAO implements OrderDAO {

	private static MySqlOrderDAO instance;

	public static synchronized MySqlOrderDAO getInstance() {
		if (instance == null) {
			instance = new MySqlOrderDAO();
		}
		return instance;
	}
	private MySqlOrderDAO() {
		
	}
	@Override
	public List<Receipt> getAllReceipt() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
