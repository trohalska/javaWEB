package com.epam.training;

import java.sql.SQLException;

import com.epam.training.jdbc.dao.DAOFactory;
import com.epam.training.jdbc.dao.DBException;
import com.epam.training.jdbc.dao.UserDAO;

public class DAODemo {
	public static void main(String[] args) throws SQLException, DBException {
		DAOFactory mFactory = DAOFactory.getDAOFactory();
		UserDAO mud = mFactory.getUserDAO();
		mud.getUserByLogin("login");
		
		DAOFactory dFactory = DAOFactory.getDAOFactory(DAOFactory.DERBY);
		UserDAO dud = dFactory.getUserDAO();
		dud.getUserByLogin("login");
	}
}
