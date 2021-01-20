package com.epam.training.jdbc.dao;

import com.epam.training.jdbc.entity.Account;

public interface UserDAO {
	Account getUserByLogin(String login) throws DBException;

}
