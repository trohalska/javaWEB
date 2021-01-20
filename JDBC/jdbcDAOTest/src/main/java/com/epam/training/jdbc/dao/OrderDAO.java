package com.epam.training.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import com.epam.training.jdbc.entity.Receipt;

public interface OrderDAO {
	
	List<Receipt> getAllReceipt() throws SQLException;

}
