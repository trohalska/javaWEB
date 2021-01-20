package com.epam.training.jdbc.dao.mysql;

import com.epam.training.jdbc.dao.DAOFactory;
import com.epam.training.jdbc.dao.OrderDAO;
import com.epam.training.jdbc.dao.UserDAO;

public class MySqlDAOFactory extends DAOFactory {

	private static MySqlDAOFactory instance;

	public static synchronized MySqlDAOFactory getInstance() {
		if (instance == null) {
			instance = new MySqlDAOFactory();
		}
		return instance;
	}

	private MySqlDAOFactory() {
		super();
	}

	@Override
	public UserDAO getUserDAO() {
		return MySqlUserDAO.getInstance();
	}

	@Override
	public OrderDAO getOrderDAO() {
		return MySqlOrderDAO.getInstance();
	}

}
