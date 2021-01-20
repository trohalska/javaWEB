package com.epam.training.jdbc;

public interface SQLConstant {
	long DEFAULT_ROLE_ID = 3;
	
	// Fields mapping
	String ID = "id";
	String CREATE_DATE = "create_date";
	String LAST_UPDATE = "last_update";

	String ROLE_NAME = "name";
	String ROLE_DESCRIPTION = "description";
	
	String PRODUCT_NAME = "name";
	String PRODUCT_DESCRIPTION = "description";
	String PRODUCT_AMOUNT = "amount";
	String PRODUCT_PRICE = "price";
	String PRODUCT_CATEGORY_ID = "category_id";
	
	String SQL_FIND_PRODUCT_BY_NAME = "SELECT * FROM product WHERE name LIKE ? ESCAPE '!'";

	String SQL_ADD_NEW_PRODUCT = 
			"INSERT INTO product (name, description, amount, price, category_id) VALUES (?, ?, ?, ?, ?)";

	String SQL_FIND_ALL_PRODUCTS = "SELECT * FROM product";

	String SQL_DELETE_PRODUCT = "DELETE FROM product WHERE id=?";

	String SQL_ADD_NEW_RECEIPT = 
			"INSERT INTO receipt (total, description, status_id) VALUES (0, ?, ?)";
	
	String SQL_ADD_PRODUCT_FOR_RECEIPT = 
			"INSERT INTO receipt_has_product (receipt_id, product_id, count, price) VALUES (?, ?, ?, 0)";

	String SQL_FIND_ALL_ROLES = "SELECT * FROM role";
	String SQL_FIND_ROLE_BY_NAME = "SELECT * FROM role WHERE name=?";
	
}
