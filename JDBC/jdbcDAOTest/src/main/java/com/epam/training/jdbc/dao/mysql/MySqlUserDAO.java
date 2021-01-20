package com.epam.training.jdbc.dao.mysql;

import com.epam.training.jdbc.dao.DBException;
import com.epam.training.jdbc.dao.UserDAO;
import com.epam.training.jdbc.entity.Account;

public class MySqlUserDAO implements UserDAO {

	private static MySqlUserDAO instance;

	public static synchronized MySqlUserDAO getInstance() {
		if (instance == null) {
			instance = new MySqlUserDAO();
		}
		return instance;
	}

	private MySqlUserDAO() {
		super();
	}

	@Override
	public Account getUserByLogin(String login) throws DBException {
		System.out.println(this.getClass().getName() + ": getUserByLogin(" + login + ")");
		return null;
	}

}
