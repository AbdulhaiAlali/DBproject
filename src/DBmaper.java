
import java.sql.*;
import java.util.*;

public class DBmaper {
	Connection connect = DBinfo.connDB();


	public DBmaper()throws SQLException {
		
		


		//addingMenu();             /call this method 1 time after creating new database to insert the menu


	}
	public void addingMenu() throws SQLException{
		InsertPizzaList("Chicken",5.99);
		InsertPizzaList("Pepperoni",4.99);
		InsertPizzaList("Meat",6.99);
		InsertPizzaList("BBQ",5.99);
		InsertPizzaList("Salami",4.99);
		
		InsertPizzaList("Veggie",3.99);
		InsertPizzaList("Margherita",2.99);
		InsertPizzaList("Cheese",3.99);
		InsertPizzaList("Hawaaian",4.99);
		InsertPizzaList("Vegetables",5.99);
		
		InsertToppingsList("mushroom",1.99);
		InsertToppingsList("salami",2.99);
		InsertToppingsList("pineapple",0.99);
		InsertToppingsList("union",0.99);
		InsertToppingsList("potato",1.49);
		InsertToppingsList("cheese",0.99);
		InsertToppingsList("garlic",0.99);
		InsertToppingsList("chicken",2.99);
		InsertToppingsList("tomatoes",1.99);
		InsertToppingsList("red pepper",0.99);		
	}
	
	public void InsertPizzaList(String PizzaName ,double Price) throws SQLException {
		Statement statement =connect.createStatement();


		String execute = "insert into PizzasList values('"+PizzaName+"',"+Price+")";
		System.out.println(execute);
		statement.execute(execute);	
	}	
	
	public void InsertToppingsList(String ToppingsName ,double ToppingsPrice) throws SQLException {
		Statement statement =connect.createStatement();

		String execute = "insert into ToppingsList values('"+ToppingsName+"',"+ToppingsPrice+")";
		System.out.println(execute);
		statement.execute(execute);	
	}
	
	public int insertPizza(String pizzaName ,String pizzaToppings , double quantity) throws SQLException {
		 int pizzaKey=0;
		 double pizzaPrice=0;
		 

		Statement statement =connect.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from pizza");
		
		while(resultSet.next()) {
			 pizzaKey= resultSet.getInt("PizzaKey");
		}	
		pizzaKey++;
	
		ResultSet Price = statement.executeQuery("select * from PizzasList WHERE pizzaName='"+pizzaName+"'");
		while(Price.next()) {
			pizzaPrice+= Price.getDouble("Price");
		}		

		ResultSet ToppingsPrice = statement.executeQuery("select * from ToppingsList WHERE ToppingsName='"+pizzaToppings+"'");
		while(ToppingsPrice.next()) {
			pizzaPrice+= ToppingsPrice.getDouble("ToppingsPrice");
		}	

		String execute = "insert into Pizza values("+pizzaKey+",'"+pizzaName+"','"+pizzaToppings+"',"+pizzaPrice+","+quantity+")";
		System.out.println(execute);
		statement.execute(execute);	
		return pizzaKey;
	}
	
	public int insertCustomer(int phoneNumber ,String name , String address , int postalCode , int pizzasNumber) throws SQLException {
		int CustomerID =0;
		Statement statement =connect.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from Customer");

		boolean oldCustomer = false;
		int pizzNum = 0;

		while(resultSet.next()) {
			CustomerID= resultSet.getInt("CustomerID");			
			if(resultSet.getInt("PhoneNumber")==phoneNumber){
				oldCustomer=true;			
			}
		}	
		CustomerID++;

		if (oldCustomer) {
		ResultSet resultSet2 = statement.executeQuery("select NumberOFpizzas from Customer where phonenumber ="+phoneNumber);
		while(resultSet2.next()) {
			pizzNum= resultSet2.getInt("NumberOFpizzas");			
		}	

		ResultSet resultSet3 = statement.executeQuery("select CustomerID from Customer where phonenumber ="+phoneNumber);
		while(resultSet3.next()) {
			CustomerID= resultSet3.getInt("CustomerID");			
		}

		pizzNum = pizzasNumber+pizzNum;
		String execute = "update customer set NumberOFpizzas = "+pizzNum+ " where phonenumber = "+phoneNumber;
		System.out.println(execute);
		statement.execute(execute);			
		return CustomerID;
		}

		if (!oldCustomer) {
		String execute = "insert into Customer values("+CustomerID+","+phoneNumber+",'"+name+"','"+address+"',"+postalCode+","+pizzasNumber+")";
		System.out.println(execute);
		statement.execute(execute);				
		}
		return CustomerID;

	}
	public int discountCode(int customerID) throws SQLException{
		Statement statement =connect.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from Discount");
		int discountID=0;

		int discountCode = (int)(Math.random()*100000000);
		System.out.println(discountCode);
		while(resultSet.next()) {
			discountID= resultSet.getInt("DiscountKey");			
		}
		discountID++;
		String execute = "insert into Discount values("+discountID+","+customerID+","+discountCode+",'NO')";
		System.out.println(execute);
		statement.execute(execute);	

		return discountCode;
	}

	public String checkCustomerPizzasNumber(int id) throws SQLException{
		Statement statement =connect.createStatement();
		ResultSet resultSet = statement.executeQuery("select NumberOFpizzas from Customer where CustomerID ="+id);
		int numberOFpizzas =0;
		while(resultSet.next()) {
			 numberOFpizzas= resultSet.getInt("NumberOFpizzas");
			 System.out.println(numberOFpizzas+"pizasnummmmm");
		}	
		if (numberOFpizzas < 10){
			return "THANK YOU";
		}		
		else if (numberOFpizzas >=10) {
		String execute = "update customer set NumberOFpizzas = "+(numberOFpizzas-10)+ " where CustomerID = "+id;
		System.out.println(execute);
		statement.execute(execute);	
		return ("THANK YOU FOR ORDERING YOU GOT A DISCOUNT CODE " + discountCode(id));
			
		}
		return "s";

	}
	public String checkDiscountCODE(int code) throws SQLException{
		Statement statement =connect.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from Discount");

		while(resultSet.next()) {
			if (code==resultSet.getInt("DiscountCode") ) {
				if (resultSet.getString("DiscountUSEDorNOT").equals("NO")) {
				System.out.println("valid");
				String execute = "update Discount set DiscountUSEDorNOT = 'YES' where DiscountCode = "+code;
				System.out.println(execute);
				statement.execute(execute);	
				return "VALID";						
				}
			}
		}
		return "NOT VALID";		
	}

	public double countAmountTOpay(ArrayList pizzas,ArrayList drinks,ArrayList dessert) throws SQLException{
		Statement statement =connect.createStatement();
		double total =0;

		for (int i =0;i<pizzas.size();i++ ) {
			System.out.println( pizzas.get(i));
		ResultSet resultSet = statement.executeQuery("select PizzaPrice from pizza where PizzaKey =" +pizzas.get(i));
		while(resultSet.next()) {
			total = total +resultSet.getDouble("PizzaPrice");			
		}
	}



		if (!drinks.isEmpty()) {
		for (int i =0;i<drinks.size();i++ ) {
		ResultSet resultSet = statement.executeQuery("select Price from drinks where drinksKey =" +pizzas.get(i));
		while(resultSet.next()) {
			total = total +resultSet.getDouble("DrinkPrice");			
		}
	}			
		}


		if (!dessert.isEmpty()) {
		for (int i =0;i<dessert.size();i++ ) {
		ResultSet resultSet = statement.executeQuery("select Price from dessert where dessertKey =" +pizzas.get(i));
		while(resultSet.next()) {
			total = total +resultSet.getDouble("DessertPrice");			
		}
	}				
		}

		return total;
}

	public void InsertPizzaOrder(int orderKey,ArrayList pizzaKeys) throws SQLException {
		Statement statement =connect.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from PizzaOrder");

		int pizzaOrderKey=0;
		while(resultSet.next()) {
			 pizzaOrderKey= resultSet.getInt("PizzaOrderKey");
		}	
		pizzaOrderKey++;		

		for (int i =0;i<pizzaKeys.size();i++ ) {
		String execute = "insert into PizzaOrder values("+pizzaOrderKey+","+orderKey+","+pizzaKeys.get(i)+")";
		System.out.println(execute);
		statement.execute(execute);			
		pizzaOrderKey++;
	}		

	}	
	public void InsertDrinkOrder(int orderKey,ArrayList drinkKeys) throws SQLException {
		Statement statement =connect.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from DrinkOrder");

		int drinkOrderKey=0;
		while(resultSet.next()) {
			 drinkOrderKey= resultSet.getInt("DrinkOrderKey");
		}	
		drinkOrderKey++;		

		for (int i =0;i<drinkKeys.size();i++ ) {
		String execute = "insert into PizzaOrder values("+drinkOrderKey+","+orderKey+","+drinkKeys.get(i)+")";
		System.out.println(execute);
		statement.execute(execute);			
		drinkOrderKey++;
	}		

	}
	public void InsertDessertOrder(int orderKey,ArrayList dessertKeys) throws SQLException {
		Statement statement =connect.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from DessertOrder");

		int dessertOrderKey=0;
		while(resultSet.next()) {
			 dessertOrderKey= resultSet.getInt("DessertOrderKey");
		}	
		dessertOrderKey++;		

		for (int i =0;i<dessertKeys.size();i++ ) {
		String execute = "insert into PizzaOrder values("+dessertOrderKey+","+orderKey+","+dessertKeys.get(i)+")";
		System.out.println(execute);
		statement.execute(execute);			
		dessertOrderKey++;
	}		

	}

/*	public void insertOrder(int customerID,double amountPaid) throws SQLException{
		Statement statement =connect.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from Orders");

		int orderKey=0;
		while(resultSet.next()) {
			 orderKey= resultSet.getInt("OrderKey");
		}	
		orderKey++;		

		String orderDate ="";
		String orderTime ="";
		String orderTimeToDeliver ="";

		int deliveryPersonID /method to chceck them to do/;

		String execute = "insert into Orders values("+orderKey+",'"+orderDate+"','"+orderTime+"','"+orderTimeToDeliver+"',"+customerID+","+deliveryPersonID+","+amountPaid+")";
		System.out.println(execute);
		statement.execute(execute);		



}*/
}
