package com.epam.training.jdbc.dao.derby;

import com.epam.training.jdbc.dao.DBException;
import com.epam.training.jdbc.dao.UserDAO;
import com.epam.training.jdbc.entity.Account;

public class DerbyUserDAO implements UserDAO {

	private static DerbyUserDAO instance;

	public static synchronized DerbyUserDAO getInstance() {
		if (instance == null) {
			instance = new DerbyUserDAO();
		}
		return instance;
	}

	private DerbyUserDAO() {

	}

	@Override
	public Account getUserByLogin(String login) throws DBException {
		System.out.println(this.getClass().getName() + ": getUserByLogin(" + login + ")");
		return null;
	}

}
