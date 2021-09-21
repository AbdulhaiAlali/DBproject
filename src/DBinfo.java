import java.sql.*;

public class DBinfo {
	
	private static String username = "root";
	private static String password = "Aa123456@";
	private static String con_string = "jdbc:mysql://localhost/pizza";
	
	public static Connection connDB() throws SQLException {
		return DriverManager.getConnection(con_string,username,password);
	}

}
