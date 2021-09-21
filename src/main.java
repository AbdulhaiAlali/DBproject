
import java.sql.*;
import java.util.*;

public class main {


	public static void main(String[] args) throws SQLException{
		
		Connection connect = DBinfo.connDB();
		Statement statement =null;
		Statement statement2 =null;

		ResultSet resultSet = null;

		statement = connect.createStatement();
		statement2 = connect.createStatement();

		//read from db
		// statement2.execute("insert into pizzas values(2,'Paprika','small','everything',7.75)");

		resultSet = statement.executeQuery("select * from pizzas");
		while(resultSet.next()) {
			int PizzaKey= resultSet.getInt("PizzaKey");
			String ToppingsKey= resultSet.getString("ToppingsKey");
			String SizeKey= resultSet.getString("SizeKey");
			String Ingredients= resultSet.getString("Ingredients");
			Float Price= resultSet.getFloat("Price");

			System.out.println("PizzaKey "+PizzaKey + " ToppingsKey "+ToppingsKey + " SizeKey "+SizeKey + " Ingredients " + Ingredients + " Price " + Price);

	
		}
	}

}
