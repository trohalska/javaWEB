package test;

public class Constants {
	public static final String TABLE_PRODUCT = "product";
	public static final String FIELD_ID = "id";
	public static final String FILED_RODUCT_AMOUNT = "amount";
	public static final String FILED_RODUCT_NAME = "name";

	public static final String FIND_ALL_PRODUCTS = "SELECT * FROM " + TABLE_PRODUCT + ";";
	public static final String FIND_PRODUCTS_BY_NAME = "SELECT * FROM " + TABLE_PRODUCT + " WHERE name = ?;";

}
