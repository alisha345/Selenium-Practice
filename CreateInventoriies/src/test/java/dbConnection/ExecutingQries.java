package dbConnection;

public class ExecutingQries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConnectingTodb.ConnectingToDb("localhost", "Restock_erp", "\"postgres\"","\"123456\"");
		ConnectingTodb.InsertInven();
		ConnectingTodb.ClosingDbConnection();

	}
}


