import java.sql.*;

public class DBinfo {
	
	private static String username = "username" ;// your username
	private static String password = "password" ;// your password
	private static String con_string = "jdbc:mysql://localhost/pizza" ;// make sure to create database pizza
	
	public static Connection connDB() throws SQLException {
		return DriverManager.getConnection(con_string,username,password);
	}

}
