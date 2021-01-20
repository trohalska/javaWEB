package com.epam.training.jdbc.dao.derby;

import com.epam.training.jdbc.dao.DAOFactory;
import com.epam.training.jdbc.dao.OrderDAO;
import com.epam.training.jdbc.dao.UserDAO;

public class DerbyDAOFactory extends DAOFactory {

	private static DerbyDAOFactory instance;

	public static synchronized DerbyDAOFactory getInstance() {
		if (instance == null) {
			instance = new DerbyDAOFactory();
		}
		return instance;
	}

	private DerbyDAOFactory() {
		super();
	}

	@Override
	public UserDAO getUserDAO() {
		return DerbyUserDAO.getInstance();
	}

	@Override
	public OrderDAO getOrderDAO() {
		return DerbyOrderDAO.getInstance();
	}

}
