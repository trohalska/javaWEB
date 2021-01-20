package test;

public class TestConnection {
	public static void main(String[] args) throws DBException  {
		DBManager db = DBManager.getInstance();
		System.out.println(db.findAllProducts());
		System.out.println(db.findProductsByName("candy"));
	}
}
