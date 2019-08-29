package bd_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class NewTest {
	public static Connection conn;
	public static Statement stmt;
	public static ResultSet resultSet;
	
  @Test
  public void f() throws SQLException {
	  
	  try{
		// Object of Statement. It is used to create a Statement to execute the query
		stmt = conn.createStatement();

		//Object of ResultSet => 'It maintains a cursor that points to the current row in the result set'
		resultSet = stmt.executeQuery("SELECT * from actor");
		while (resultSet .next()) {
			System.out.println(resultSet .getString(1) + " | " + resultSet .getString(2) +" | "+ resultSet .getString(3));
		}
	}catch(Exception e){
		System.out.println("Exeception occured in db testing");
		e.printStackTrace();
	}finally {
		// close the connection if not already closed
		if (resultSet != null) {
			resultSet.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
  }
  
  
  @BeforeMethod
  public void SetupDatabaseConnection() {
	  try {
			Class.forName("org.postgresql.Driver");
			// Object of Connection from the Database
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5434/dvd_rentel", "postgres", "123456");

		} catch (ClassNotFoundException e) {
			System.out.println("Exception occured while loading the driver of JDBC");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  
	  
  }

}
