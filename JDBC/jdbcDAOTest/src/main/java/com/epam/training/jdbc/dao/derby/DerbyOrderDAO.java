package com.epam.training.jdbc.dao.derby;

import java.sql.SQLException;
import java.util.List;

import com.epam.training.jdbc.dao.OrderDAO;
import com.epam.training.jdbc.entity.Receipt;

public class DerbyOrderDAO implements OrderDAO {

	private static DerbyOrderDAO instance;

	public static synchronized DerbyOrderDAO getInstance() {
		if (instance == null) {
			instance = new DerbyOrderDAO();
		}
		return instance;
	}
	private DerbyOrderDAO() {
		
	}
	@Override
	public List<Receipt> getAllReceipt() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
