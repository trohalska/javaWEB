package com.epam.training.jdbc.dao;

import com.epam.training.jdbc.dao.derby.DerbyDAOFactory;
import com.epam.training.jdbc.dao.mysql.MySqlDAOFactory;

public abstract class DAOFactory {

	public static final String DERBY = "Derby";
	public static final String MYSQL = "MySQL";
	
	public static DAOFactory getDAOFactory() {
		// read configuration 
		return MySqlDAOFactory.getInstance();
	}

	public static DAOFactory getDAOFactory(String name) {
		if (DERBY.equalsIgnoreCase(name)) {
			return DerbyDAOFactory.getInstance();
		} else if (MYSQL.equalsIgnoreCase(name)) {
			return MySqlDAOFactory.getInstance();
		}
		throw new RuntimeException("Unknown factory");
	}
	
	public abstract UserDAO getUserDAO();

	public abstract OrderDAO getOrderDAO();
}
