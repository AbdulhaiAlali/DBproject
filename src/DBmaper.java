import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.*;


/**
 * DBmaper Class is the class where it has all the method that store the data in the database
 * The class gets the data from the GUI and map it into the database
 * Imortant to create a database called pizza using the following command in mysql
 * create database pizza;
 * if pizza database does not exist the maper will not work
 */


public class DBmaper {
	Connection connect = DBinfo.connDB();
	DatabaseMetaData dbm = connect.getMetaData();

	public DBmaper()throws SQLException {
		
		
/**
 * if the tables were not added it will add them for one time and add the menu
 */

		ResultSet tables = dbm.getTables(null,null,"PizzasList",null);
		if (tables.next()) {		
		}
		else{
		addingTables();
		}

	}

	/**
 	 * addingTables adds all the tabels and the menu into the database
 	 */

	public void addingTables() throws SQLException{
		Statement statement =connect.createStatement();

		String execute1 = "create table ToppingsList(ToppingsName varchar(25),ToppingsPrice float,constraint toppings_pk primary key(ToppingsName))";
		String execute2 =	"create table PizzasList(PizzaName varchar(25),Price float,constraint pizzas_pk primary key(PizzaName))";	
		String execute3 =	"create table Pizza(PizzaKey int,PizzaName varchar(25),ToppingsName varchar(25),	PizzaPrice float ,Quantity int,primary key(PizzaKey),foreign key(PizzaName) REFERENCES PizzasList(PizzaName),foreign key(ToppingsName) REFERENCES ToppingsList(ToppingsName))";	
		String execute4 =	"create table Drinks(DrinkKey int,DrinkName varchar(25),DrinkPrice float ,Quantity int,primary key(DrinkKey))";	
		String execute5 =	"create table Desserts(DessertKey int,DessertName varchar(25),DessertPrice float ,Quantity int,primary key(DessertKey))";	
		String execute6 =	"create table Customer(CustomerID int,PhoneNumber int,Name varchar(25),		Address varchar(25) ,PostalCode int,NumberOFpizzas int,primary key(CustomerID))";	
		String execute7 =	"create table Discount(DiscountKey int,CustomerID int,DiscountCode int,DiscountUSEDorNOT varchar(25),primary key(DiscountKey),foreign key(CustomerID) REFERENCES Customer(CustomerID))	";	
		String execute8 =	"create table DeliveryPerson(DeliveryPersonID int,PostalCode int,isDelivering varchar(25),primary key(DeliveryPersonID))	";	
		String execute9 =	"create table Orders(OrderKey int,OrderDate varchar(25),OrderTime  varchar(25),OrderTimeToBeDelivered varchar(25),CustomerID int,DeliveryPersonID int,	Status varchar(100),	AmountPaid float,primary key(OrderKey),foreign key(CustomerID) REFERENCES Customer(CustomerID),foreign key(DeliveryPersonID) REFERENCES DeliveryPerson(DeliveryPersonID))";	
		String execute10 =	"create table DeliveringList(DeliveringListKey int,DeliveryPersonID int,OrderKey int,OrderTime varchar(25),OrderTimeToBeDelivered varchar(25),primary key(DeliveringListKey),foreign key(DeliveryPersonID) REFERENCES DeliveryPerson(DeliveryPersonID))	";	
		String execute11 =	"create table PizzaOrder(PizzaOrderKey int,OrderKey int,PizzaKey int,primary key(PizzaOrderKey),foreign key(OrderKey) REFERENCES Orders(OrderKey),		foreign key(PizzaKey) REFERENCES Pizza(PizzaKey))";	
		String execute12 =	"create table DrinkOrder(DrinkOrderKey int,OrderKey int,DrinkKey int,primary key(DrinkOrderKey),foreign key(OrderKey) REFERENCES Orders(OrderKey),	foreign key(DrinkKey) REFERENCES Drinks(DrinkKey))";	
		String execute13 =	"create table DessertOrder(DessertOrderKey int,OrderKey int,DessertKey int,primary key(DessertOrderKey),foreign key(OrderKey) REFERENCES Orders(OrderKey),	foreign key(DessertKey) REFERENCES Desserts(DessertKey))	";	
		String execute14 =	"insert into DeliveryPersoN(DeliveryPersonID,PostalCode,isDelivering )values(1,6211,'NO')";	
		String execute15 =	"insert into DeliveryPersoN(DeliveryPersonID,PostalCode,isDelivering )values(2,6211,'NO')";	
		String execute16 =	"insert into DeliveryPersoN(DeliveryPersonID,PostalCode,isDelivering )values(3,6211,'NO')";	
		String execute17 =	"insert into DeliveryPersoN(DeliveryPersonID,PostalCode,isDelivering )values(4,6211,'NO')";	
		String execute18 =	"insert into DeliveryPersoN(DeliveryPersonID,PostalCode,isDelivering )values(5,6211,'NO')";	
		String execute19 =	"insert into DeliveryPersoN(DeliveryPersonID,PostalCode,isDelivering )values(6,6181,'NO')";	
		String execute20 =	"insert into DeliveryPersoN(DeliveryPersonID,PostalCode,isDelivering )values(7,6181,'NO')";	
		String execute21 =	"insert into DeliveryPersoN(DeliveryPersonID,PostalCode,isDelivering )values(8,6181,'NO')";	
		String execute22 =	"insert into DeliveryPersoN(DeliveryPersonID,PostalCode,isDelivering )values(9,6181,'NO')";	
		String execute23 =	"insert into DeliveryPersoN(DeliveryPersonID,PostalCode,isDelivering )values(10,6181,'NO')";	
		String execute24 =	"insert into DeliveryPersoN(DeliveryPersonID,PostalCode,isDelivering )values(11,6222,'NO')";	
		String execute25 =	"insert into DeliveryPersoN(DeliveryPersonID,PostalCode,isDelivering )values(12,6222,'NO')";	
		String execute26 =	"insert into DeliveryPersoN(DeliveryPersonID,PostalCode,isDelivering )values(13,6222,'NO')";	
		String execute27 =	"insert into DeliveryPersoN(DeliveryPersonID,PostalCode,isDelivering )values(14,6222,'NO')";	
		String execute28 =	"insert into DeliveryPersoN(DeliveryPersonID,PostalCode,isDelivering )values(15,6222,'NO')";	
		String execute29 =	"insert into Desserts(DessertKey ,DessertName,DessertPrice ,Quantity ) values(1,'Cake',1.99,1)";	
		String execute30 =	"insert into Desserts(DessertKey ,DessertName,DessertPrice  ,Quantity ) values(2,'Wafel',1.99,1)";	
		String execute31 =	"insert into Drinks(DrinkKey ,DrinkName,DrinkPrice  ,Quantity ) values(1,'Cola',1.99,1)";	
		String execute32 =	"insert into Drinks(DrinkKey ,DrinkName,DrinkPrice  ,Quantity ) values(2,'Water',1.99,1)";	
		String execute33 =	"insert into Drinks(DrinkKey ,DrinkName,DrinkPrice  ,Quantity ) values(3,'Fanta',1.99,1)";	
		String execute34 =	"insert into Drinks(DrinkKey ,DrinkName,DrinkPrice  ,Quantity ) values(4,'Juice',1.99,1)";	

		statement.execute(execute1);	
		statement.execute(execute2);	
		statement.execute(execute3);	
		statement.execute(execute4);	
		statement.execute(execute5);	
		statement.execute(execute6);	
		statement.execute(execute7);	
		statement.execute(execute8);	
		statement.execute(execute9);	
		statement.execute(execute10);	
		statement.execute(execute11);	
		statement.execute(execute12);	
		statement.execute(execute13);	
		statement.execute(execute14);	
		statement.execute(execute15);	
		statement.execute(execute16);	
		statement.execute(execute17);	
		statement.execute(execute18);	
		statement.execute(execute19);	
		statement.execute(execute20);	
		statement.execute(execute21);	
		statement.execute(execute22);	
		statement.execute(execute23);	
		statement.execute(execute24);	
		statement.execute(execute25);	
		statement.execute(execute26);	
		statement.execute(execute27);	
		statement.execute(execute28);	
		statement.execute(execute29);	
		statement.execute(execute30);		
		statement.execute(execute31);	
		statement.execute(execute32);	
		statement.execute(execute33);	
		statement.execute(execute34);	
	

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
	
	/**
 	 * InsertPizzaList a method t insert the pizza into the database
 	 * @param PizzaName the name of the pizza
 	 * @param Price the price of the pizza
 	 */	
	public void InsertPizzaList(String PizzaName ,double Price) throws SQLException {
		Statement statement =connect.createStatement();


		String execute = "insert into PizzasList values('"+PizzaName+"',"+Price+")";
		System.out.println(execute);
		statement.execute(execute);	
	}	

	/**
 	 * InsertToppingsList a method t insert the Toppings into the database
 	 * @param ToppingsName the name of the Toppings
 	 * @param ToppingsPrice the price of the Toppings
 	 */	
	public void InsertToppingsList(String ToppingsName ,double ToppingsPrice) throws SQLException {
		Statement statement =connect.createStatement();

		String execute = "insert into ToppingsList values('"+ToppingsName+"',"+ToppingsPrice+")";
		System.out.println(execute);
		statement.execute(execute);	
	}

	/**
 	 * insertPizza a method t insert the fixed pizza into the database
 	 * @param pizzaName the name of the pizza
 	 * @param pizzaToppings the name of the Toppings 
 	 * @param quantity the quantity
 	 * @return pizzaKey
 	 */	

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

	/**
 	 * insertCustomer a method inserts the customer info into the database
 	 * @param phoneNumber the phone number of the customer
 	 * @param name the name of the customer
 	 * @param address the address of the customer
 	 * @param postalCode the postalCode of the customer
 	 * @param pizzasNumber the number of pizzas that the customer has orderd (save it for the discount function)
 	 * @return customerID
 	 */	

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
	/**
 	 * discountCode a method that create new discount codes based on the number of the pizzas > 10
 	 * @param customerID the id of the customer
 	 * @return Discount Code 
 	 */		
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

	/**
 	 * checkCustomerPizzasNumber a method that checkes the number of pizzas that the customer have orderd
 	 * @param id the id of the customer
 	 * @return "THANK YOU" if the number is less than 10
 	 * @return "THANK YOU FOR ORDERING YOU GOT A DISCOUNT CODE " and the discount code if the number of pizzas is more than 10 and its subtract 10 from the total number 
 	 */		
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
	/**
 	 * checkDiscountCODE a method that checkes if the discount code valid or not
 	 * @param code the discount code
 	 * @return "VALID" if its valid
 	 * @return "NOT VALID" if its not valid
 	 */			
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

	/**
 	 * countAmountTOpay a method that counts the total amount to pay for an order
 	 * @param pizzas the pizza list
 	 * @param drinks the drinks list
 	 * @param dessert the dessert list
 	 * @return total price
 	 */	

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
		ResultSet resultSet = statement.executeQuery("select DrinkPrice from drinks where DrinkName ='" +drinks.get(i)+"'");
		while(resultSet.next()) {
			total = total +resultSet.getDouble("DrinkPrice");			
		}
	}			
		}


		if (!dessert.isEmpty()) {
		for (int i =0;i<dessert.size();i++ ) {
		ResultSet resultSet = statement.executeQuery("select DessertPrice from desserts where DessertName ='" +dessert.get(i)+"'");
		while(resultSet.next()) {
			total = total +resultSet.getDouble("DessertPrice");			
		}
	}				
		}

		return total;
}

	/**
 	 * countAmountPaid a method that return the amount paid for an order
 	 * @param orderKey the Order Key
 	 * @return total price
 	 */	
	public double countAmountPaid(int orderKey) throws SQLException{
		Statement statement =connect.createStatement();
		double amount=0;
		ResultSet resultSet = statement.executeQuery("select amountPaid from Orders where orderKey =" +orderKey);
		while(resultSet.next()) {
			amount = resultSet.getDouble("amountPaid");			
		}
		return amount;
	}		
	
	/**
 	 * InsertPizzaOrder a method that insert the pizzas orderd for an order
 	 * @param orderKey the Order Key
 	 * @param pizzaKeys the pizza keys list
 	 */	
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
	/**
 	 * InsertDrinkOrder a method that insert the drinks orderd for an order
 	 * @param orderKey the Order Key
 	 * @param drinkKeys the drinks keys list
 	 */		
	public void InsertDrinkOrder(int orderKey,ArrayList drinkKeys) throws SQLException {
		Statement statement =connect.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from DrinkOrder");
		ArrayList keeys = new ArrayList();

		int drinkOrderKey=0;
		while(resultSet.next()) {
			 drinkOrderKey= resultSet.getInt("DrinkOrderKey");
		}	
		drinkOrderKey++;		

		for (int i =0;i<drinkKeys.size() ;i++ ) {
			int drinkKeyy =0;
			ResultSet resultSet2 = statement.executeQuery("select DrinkKey from Drinks where drinkname ='"+drinkKeys.get(i)+"'");
		while(resultSet2.next()) {
			keeys.add(resultSet2.getInt("DrinkKey"));
		  }
		}

		for (int i =0;i<keeys.size();i++ ) {
		String execute = "insert into DrinkOrder values("+drinkOrderKey+","+orderKey+","+keeys.get(i)+")";
		System.out.println(execute);
		statement.execute(execute);			
		drinkOrderKey++;			 
						

	}		

	}
	/**
 	 * InsertDessertOrder a method that insert the Dessert orderd for an order
 	 * @param orderKey the Order Key
 	 * @param drinkKeys the Dessert keys list
 	 */			
	public void InsertDessertOrder(int orderKey,ArrayList dessertKeys) throws SQLException {
		Statement statement =connect.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from DessertOrder");
		ArrayList keeys = new ArrayList();
		int dessertOrderKey=0;
		while(resultSet.next()) {
			 dessertOrderKey= resultSet.getInt("dessertOrderKey");
		}	
		dessertOrderKey++;		

		for (int i =0;i<dessertKeys.size() ;i++ ) {
			int desserteyy =0;
			ResultSet resultSet2 = statement.executeQuery("select DessertKey from Desserts where DessertName ='"+dessertKeys.get(i)+"'");
		while(resultSet2.next()) {
			keeys.add(resultSet2.getInt("dessertKey"));
		  }
		}

		for (int i =0;i<keeys.size();i++ ) {
		String execute = "insert into dessertOrder values("+dessertOrderKey+","+orderKey+","+keeys.get(i)+")";
		System.out.println(execute);
		statement.execute(execute);			
		dessertOrderKey++;		

	}}

	/**
 	 * insertOrder a method that create new order
 	 * @param customerID the Customer ID
 	 * @param amountPaid the Amount Paid
 	 * @param postalcode the postalcode
 	 * @return orderKey
 	 */		
	public int insertOrder(int customerID,double amountPaid,int postalcode) throws SQLException{
		Statement statement =connect.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from Orders");

		int orderKey=0;
		while(resultSet.next()) {
			 orderKey= resultSet.getInt("OrderKey");
		}	
		orderKey++;		
     Date currentTime = new Date();

     SimpleDateFormat timeFormat2 = new SimpleDateFormat("yyyy-MM-dd");
     String orderDate = timeFormat2.format(currentTime);


		String[] deliveryinfo = new String [2];

        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
        System.out.println(timeFormat.format(currentTime));
        String orderTime = timeFormat.format(currentTime);
        System.out.println(orderTime);

		deliveryinfo = checkDeliveryPerson(orderKey,postalcode,orderTime);

		String deliveryPersonIDS =deliveryinfo[0]; 
		String orderTimeToBeDelieverd2 =deliveryinfo[1]; 

		int deliveryPersonID =0;

     try{
     	 deliveryPersonID = Integer.parseInt(deliveryPersonIDS);
     }
     catch(NumberFormatException ex){
     	ex.printStackTrace();
     }

		String execute = "insert into Orders values("+orderKey+",'"+orderDate+"','"+orderTime+"','"+orderTimeToBeDelieverd2+"',"+customerID+","+deliveryPersonID+",'PREPARING THE ORDER',"+ amountPaid+")";
		System.out.println(execute);
		statement.execute(execute);		

		return orderKey;
}
	/**
 	 * checkDeliveryPerson a method that checks which deliveryperson is free to deliver the order
 	 * @param orderKey the Order Key
 	 * @param postalCode the postalCode
 	 * @param orderTime the orderTime
 	 * @return Array String with 2 index , index 0 with the deliveryperson id and index 1 with the time to deliver the order
 	 */	
 	public String[] checkDeliveryPerson(int orderKey , int postalCode,String orderTime)throws SQLException{

 		String[] timeToDeliverLastOrder =null;

		Statement statement =connect.createStatement();
		Statement statement2 =connect.createStatement();

		ArrayList<Integer> deliveryPersonIDs = new ArrayList();
		ArrayList<Integer> deliveryPersonIDbusy = new ArrayList();

		int deliveringListKey =0;
		ResultSet resultSett = statement.executeQuery("select max(deliveringlistkey) from deliveringlist");
		while(resultSett.next()) {
			deliveringListKey = resultSett.getInt("max(deliveringlistkey)");
		  }
		deliveringListKey++;

		
		String[] deliveryinfo = new String[2]; //index 0 is the id and index 1 the time to deliver


		//get all deliveryPersonIDs with same postal code 
		ResultSet resultSet = statement.executeQuery("select DeliveryPersonID from DeliveryPerson where PostalCode =" +postalCode);
		while(resultSet.next()) {
				deliveryPersonIDs.add(resultSet.getInt("DeliveryPersonID"));
		}	

		//if not free then get all the persons that have the same postcode and are busy
		for (int i=0;i<deliveryPersonIDs.size();i++) {
		ResultSet resultSet2 = statement.executeQuery("select isDelivering from DeliveryPerson where deliveryPersonID = "+deliveryPersonIDs.get(i));
		while(resultSet2.next()) {
			if (resultSet2.getString("isDelivering").equals("YES")) {
				deliveryPersonIDbusy.add(deliveryPersonIDs.get(i));				
			}			
		  }
		}


		//check if there is another order with same postal code and the new order is less than 5m
		//then the delivery person will take both
		String[] checkOrderLessThan5m = checkOrderLessThan5m(deliveryPersonIDbusy,orderKey);
		if (checkOrderLessThan5m[0]=="YES") {
			deliveryinfo[0]=checkOrderLessThan5m[1];
			deliveryinfo[1]=checkOrderLessThan5m[2];
				String execute2 = "insert into DeliveringList values("+deliveringListKey+","+deliveryinfo[0]+","+orderKey+",'"+orderTime+"','"+deliveryinfo[1]+"')";
				System.out.println(execute2);
				statement2.execute(execute2);	
			return deliveryinfo;
		}


		//if the delivery person is free he will deliver the order
		for (int i=0;i<deliveryPersonIDs.size();i++) {

        String[] parts = orderTime.split(":");
        System.out.println(parts[0]);
        System.out.println(parts[1]);
      
        int minutsTOdeliver = 15;
   
   int mintsOrderd = 0;
   int hoursOrderd=0;

     try{
     	 mintsOrderd = Integer.parseInt(parts[1]);
     	 hoursOrderd = Integer.parseInt(parts[0]);

     }
     catch(NumberFormatException ex){
     	ex.printStackTrace();
     }


        int sum = (minutsTOdeliver+mintsOrderd);
        while(sum>=60){
        	sum =sum-60;
         	hoursOrderd=hoursOrderd+1;

         }
        String orderTimeToBeDelieverd = hoursOrderd+":"+sum;


		ResultSet resultSet2 = statement2.executeQuery("select isDelivering from DeliveryPerson where deliveryPersonID = "+deliveryPersonIDs.get(i));
		while(resultSet2.next()) {
			if (resultSet2.getString("isDelivering").equals("NO")) {
				String execute = "update DeliveryPerson set isDelivering = 'YES' where deliveryPersonID = "+deliveryPersonIDs.get(i);
				String execute2 = "insert into DeliveringList values("+deliveringListKey+","+deliveryPersonIDs.get(i)+","+orderKey+",'"+orderTime+"','"+orderTimeToBeDelieverd+"')";
				System.out.println(execute);
				System.out.println(execute2);
				statement2.execute(execute2);	
				statement2.execute(execute);	

				deliveryinfo[0]=""+deliveryPersonIDs.get(i)+"";
				deliveryinfo[1]=orderTimeToBeDelieverd; 
				System.out.println("free one here");
				return deliveryinfo ;
			}			
		  }
		}




		//check which one will come earlyer then select him to deliver the next order for this postcode
			int minPerson =0;
			int minTime=100000000;	
			int orderMin =0;
			int minOrder=0;
			String minPersonStr="";
			ArrayList orderKeyBusy = new ArrayList();			
					ArrayList<String> timeee = new ArrayList<String>();
	 String timeToddd ="";
		for (int i=0;i<deliveryPersonIDbusy.size();i++) {		

		ResultSet resultSetaa = statement.executeQuery("select ordertimetobedelivered from deliveringlist where deliverypersonid = "+deliveryPersonIDbusy.get(i)+" order by ordertimetobedelivered DESC limit 1");
		while(resultSetaa.next()) {
			timeToddd= resultSetaa.getString("OrderTimeToBeDelivered");
		}	
		}

		timeee.add(timeToddd);


		for (int i =0;i<timeee.size();i++ ) {
		ResultSet resultSet3 = statement.executeQuery("select OrderTime from DELIVERINGLIST where OrderTimeToBeDelivered = '"+timeee.get(i)+"'");
			while(resultSet3.next()){

   			String[] parts = resultSet3.getString("OrderTime").split(":");

   			String[] parts2 = timeee.get(i).split(":");


   int orderTimeToBeDeliveredINT = 0;
   int orderTimeM=0;
   int orderTimeTobeDeliver=0;

     try{
     	  orderTimeM = Integer.parseInt(parts[1]);
     	  orderTimeTobeDeliver = Integer.parseInt(parts2[1]);    	 
     }
     catch(NumberFormatException ex){
     	ex.printStackTrace();
     }

     if (orderTimeTobeDeliver<orderTimeM) {
     	orderTimeToBeDeliveredINT =(orderTimeTobeDeliver+60)-orderTimeM;
     }
     if(orderTimeTobeDeliver>orderTimeM){
     	orderTimeToBeDeliveredINT = orderTimeTobeDeliver-orderTimeM;
     }

			if (orderTimeToBeDeliveredINT<minTime) {
				minTime =orderTimeToBeDeliveredINT;
				minPersonStr = timeee.get(i);
				timeToDeliverLastOrder = parts2;
			  }		
			}			
		}
		ResultSet resultSet111 = statement.executeQuery("select deliveryPersonID from DeliveringList where OrderTimeToBeDelivered = '"+minPersonStr+"'");
		while(resultSet111.next()) {
			minPerson= resultSet111.getInt("deliveryPersonID");
		  }	



        String[] parts = orderTime.split(",");
      


        //CHECK LAST ORDER TIME TO DELIVER 


   int timeToDeliverLastOrderM=0;
   int timeToDeliverLastOrderH=0;

     try{

      	 timeToDeliverLastOrderM = Integer.parseInt(timeToDeliverLastOrder[1]);
      	 timeToDeliverLastOrderH = Integer.parseInt(timeToDeliverLastOrder[0]);
    	 

     }
     catch(NumberFormatException ex){
     	ex.printStackTrace();
     }

        int sum = (timeToDeliverLastOrderM+30);

        while(sum>=60){
        	sum =sum-60;
         	timeToDeliverLastOrderH++;

         }

		String orderTimeToBeDelieverd ="";

         if (sum < 10) {
         	orderTimeToBeDelieverd = timeToDeliverLastOrderH+":0"+sum;
         }
         if (sum>=10) {
         orderTimeToBeDelieverd = timeToDeliverLastOrderH+":"+sum;        	
         }

        String minPersons = ""+minPerson+"";
		deliveryinfo[0]=minPersons;
		deliveryinfo[1]=orderTimeToBeDelieverd;



		String execute2 = "insert into DeliveringList values("+deliveringListKey+","+minPerson+","+orderKey+",'"+orderTime+"','"+orderTimeToBeDelieverd+"')";
		System.out.println(execute2);
		statement.execute(execute2);	

	    return deliveryinfo ;

 	}


	/**
 	 * getBill a method that create an array of strings with all the detail of the order
 	 * @param orderKey the orderKey
 	 * @return ArrayList with all the detail of the order
 	 */	
 	public ArrayList<String> getBill(int orderKey)throws SQLException{

 		ArrayList<String> billArray = new ArrayList<>();

 		ArrayList<Integer> pizzaKeys = new ArrayList<>();
 		ArrayList<Integer> drinkKeys = new ArrayList<>();
 		ArrayList<Integer> dessertKeys = new ArrayList<>();

		Statement statement =connect.createStatement();

		ResultSet resultSet = statement.executeQuery("select PizzaKey from PizzaOrder where orderKey = " + orderKey);
		while(resultSet.next()) {
			 pizzaKeys.add(resultSet.getInt("PizzaKey"));
		}	
		ResultSet resultSet2 = statement.executeQuery("select DrinkKey from DrinkOrder where orderKey = " + orderKey);
		while(resultSet2.next()) {
			 drinkKeys.add(resultSet2.getInt("DrinkKey"));
		}	
		ResultSet resultSet3 = statement.executeQuery("select DessertKey from DessertOrder where orderKey = " + orderKey);
		while(resultSet3.next()) {
			 dessertKeys.add(resultSet3.getInt("DessertKey"));
		}	
		

		for (int i =0;i<pizzaKeys.size();i++) {
		ResultSet resultSet33 = statement.executeQuery("select * from Pizza where PizzaKey = " + pizzaKeys.get(i));
		while(resultSet33.next()) {
			 String name = resultSet33.getString("PizzaName");
			 String topping = resultSet33.getString("ToppingsName");
			 double price = resultSet33.getDouble("PizzaPrice");
			 billArray.add(billArray.size() + "# Pizza Name: " + name + " Topping Name: "+topping+ " Pizza Price: "+price+"$");
		}	 					
		}


		for (int i =0;i<drinkKeys.size() ;i++ ) {
		ResultSet resultSet33 = statement.executeQuery("select * from Drinks where DrinkKey = " + drinkKeys.get(i));
		while(resultSet33.next()) {
			 String name = resultSet33.getString("DrinkName");
			 double price = resultSet33.getDouble("DrinkPrice");
			 int quantity = resultSet33.getInt("Quantity");
			 billArray.add(billArray.size() + "# Drink Name: " + name + " Drink Price: "+price +"$"+ " Quantity " + quantity);
		}				
		}


		for (int i =0;i<dessertKeys.size() ;i++ ) {
		ResultSet resultSet33 = statement.executeQuery("select * from Desserts where DessertKey = " + drinkKeys.get(i));
		while(resultSet33.next()) {
			 String name = resultSet33.getString("DessertName");
			 double price = resultSet33.getDouble("DessertPrice");
			 int quantity = resultSet33.getInt("Quantity");
			 billArray.add(billArray.size() + "# Dessert Name: " + name + " Dessert Price: "+price+"$" + " Quantity " + quantity);
		}				
		}
 		


		return billArray;



 	}



  /**
 	 * getLastOrder a method that return the Last Order
 	 * @return Last Order key
 	 */	
	public int getLastOrder() throws SQLException {
		Statement statement =connect.createStatement();
		ResultSet resultSet = statement.executeQuery("select max(orderKey) from orders");

		while(resultSet.next()) {
			return resultSet.getInt("max(orderKey)");						
		}	
		return 0;
	} 	
	
	//get the satuts of the order
	public String getStatus(int orderKey) throws SQLException {
		Statement statement =connect.createStatement();
		ResultSet resultSet = statement.executeQuery("select Status from orders where orderKey = "+orderKey);

		while(resultSet.next()) {
			return resultSet.getString("Status");						
		}	
		return "";
	} 
	//get the satuts of the order
	public void updateStatus() throws SQLException {
		Statement statement =connect.createStatement();

		ArrayList<Integer> keys = new ArrayList();

		ResultSet resultSet2 = statement.executeQuery("select orderKey from orders");
		while(resultSet2.next()) {
   	  keys.add(resultSet2.getInt("orderKey"));
		}	

		for (int i =0;i<keys.size();i++ ) {
		ResultSet resultSet = statement.executeQuery("select * from orders where orderKey = "+keys.get(i));

 		String newStatus = "";

		int minutsToBeDelivered=0;
		int timeNowH=0;
		int timeNowM=0;
		int orderTimeTobeDeliverH=0;
		int orderTimeTobeDeliverM	=0;

		String[] orderTimeTobeDeliver =null;

		String status="";

		int deliveryPersonID=0;

		while(resultSet.next()) {

   	  orderTimeTobeDeliver = resultSet.getString("OrderTimeToBeDelivered").split(":");
   	  status = resultSet.getString("Status");
   	  deliveryPersonID = resultSet.getInt("deliveryPersonID");
		}	

		if (!status.equals("CANCELED")) {
		 Date currentTime = new Date();

     SimpleDateFormat timeFormat2 = new SimpleDateFormat("hh:mm");
     String currentTimes = timeFormat2.format(currentTime);

   	 String[] orderTime = currentTimes.split(":");

     try{
     	   timeNowH = Integer.parseInt(orderTime[0]);
     	   timeNowM = Integer.parseInt(orderTime[1]);

     	   orderTimeTobeDeliverH = Integer.parseInt(orderTimeTobeDeliver[0]);
     	   orderTimeTobeDeliverM = Integer.parseInt(orderTimeTobeDeliver[1]);  	 
     }
     catch(NumberFormatException ex){
     	ex.printStackTrace();
     }

     System.out.println(timeNowH);
     System.out.println(timeNowM);
     System.out.println(orderTimeTobeDeliverH);
     System.out.println(orderTimeTobeDeliverM);

     while (orderTimeTobeDeliverH>timeNowH) {
     		minutsToBeDelivered=minutsToBeDelivered+60;
     		orderTimeTobeDeliverH--;
     }
     minutsToBeDelivered = minutsToBeDelivered + (orderTimeTobeDeliverM-timeNowM);

     
     newStatus = minutsToBeDelivered +" Minuts to be delivered";

		if (minutsToBeDelivered<0) {
      newStatus = "Order is Delivered";	      
     }
     System.out.println(newStatus);

		String execute = "update orders set status = '"+newStatus+ "' where orderKey = "+keys.get(i);
		System.out.println(execute);
		statement.execute(execute);					
		}

	
		}
	} 

	/**
 	 * cancelTHEoRDER a method that check if its possible to cancel the order based on the time
 	 * @param orderKey the order key
 	 * @return  "ALREADY CANCELED" if its already canceled
	 * @return "ORDER CANCELED!" if its possible to cancel the order
	 * @return "ORDER CAN'T BE CANCELED AFTER 5 MINUTS"	 if its not possible to cancel the order
 	 */	
	public String cancelTHEoRDER(int orderKey) throws SQLException {
		Statement statement =connect.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from orders where orderKey = "+orderKey);

		int minutsORDERD=0;
		int timeNowH=0;
		int timeNowM=0;
		int orderTimeH=0;
		int orderTimeM	=0;

		String orderTime =null;

		String status="";
		int deliveryPersonID=0;

		while(resultSet.next()) {

   	  orderTime = resultSet.getString("OrderTime");
   	  status = resultSet.getString("Status");
   	  deliveryPersonID = resultSet.getInt("deliveryPersonID");
		}	
		if (status.equals("CANCELED")) {
			return "ALREADY CANCELED";
		}

		 Date currentTime = new Date();

     SimpleDateFormat timeFormat2 = new SimpleDateFormat("hh:mm");
     String currentTimes = timeFormat2.format(currentTime);

   	 String[] timeNow = currentTimes.split(":");
   	 String[] orderTimeS = orderTime.split(":");

     try{
     	   timeNowH = Integer.parseInt(timeNow[0]);
     	   timeNowM = Integer.parseInt(timeNow[1]);

     	   orderTimeH = Integer.parseInt(orderTimeS[0]);
     	   orderTimeM = Integer.parseInt(orderTimeS[1]);  	 
     }
     catch(NumberFormatException ex){
     	ex.printStackTrace();
     }

     while (orderTimeH>timeNowH) {
     		minutsORDERD=minutsORDERD+60;
     		orderTimeH--;
     }
     minutsORDERD = (minutsORDERD + timeNowM) - orderTimeM;
     System.out.println(minutsORDERD +"mints orderd");

     if (minutsORDERD<5) {
 		String execute = "update orders set status = '"+"CANCELED"+ "' where orderKey = "+orderKey;
		System.out.println(execute);
		statement.execute(execute);	    			
     	return "ORDER CANCELED!";
     }

     return "ORDER CAN'T BE CANCELED AFTER 5 MINUTS";
	} 

	/**
 	 * checkOrderLessThan5m a method that check if its possible to take the new order with same postal code with another one
 	 * @param deliveryPersonIDbusy the list delivery PersonID are busy
 	 * @param orderKey the order key
 	 * @return Array String with 3 index , index 0 Yes or No based on if its possible, index 1 the delivery person id if its possible , index 2 the time to deliver the new order if its possible to.
 	 */ 
 	public String[] checkOrderLessThan5m(ArrayList deliveryPersonIDbusy,int orderKey) throws SQLException {
		Statement statement =connect.createStatement();

		String[] returnString =new String[3];

		for (int i =0;i<deliveryPersonIDbusy.size() ;i++ ) {
		ResultSet resultSet = statement.executeQuery("select * from deliveringlist where DeliveryPersonID = "+deliveryPersonIDbusy.get(i));
			
		String orderTime =null;
		String orderTimeToBeDelieverd =null;

		while(resultSet.next()) {

   	  orderTime = resultSet.getString("OrderTime");
   	  orderTimeToBeDelieverd = resultSet.getString("OrderTimeToBeDelivered");

		}

		int minutsORDERD=0;
		int timeNowH=0;
		int timeNowM=0;
		int orderTimeH=0;
		int orderTimeM	=0;


		String status="";
		 Date currentTime = new Date();

     SimpleDateFormat timeFormat2 = new SimpleDateFormat("hh:mm");
     String currentTimes = timeFormat2.format(currentTime);

   	 String[] timeNow = currentTimes.split(":");
   	 String[] orderTimeS = orderTime.split(":");

     try{
     	   timeNowH = Integer.parseInt(timeNow[0]);
     	   timeNowM = Integer.parseInt(timeNow[1]);

     	   orderTimeH = Integer.parseInt(orderTimeS[0]);
     	   orderTimeM = Integer.parseInt(orderTimeS[1]);  	 
     }
     catch(NumberFormatException ex){
     	ex.printStackTrace();
     }

     while (orderTimeH>timeNowH) {
     		minutsORDERD=minutsORDERD+60;
     		orderTimeH--;
     }
     minutsORDERD = (minutsORDERD + timeNowM) - orderTimeM;
     System.out.println(minutsORDERD +"mints orderd");

     if (minutsORDERD<5 && minutsORDERD>=0) {
 		returnString[0]="YES";
 		returnString[1]=""+ deliveryPersonIDbusy.get(i);
 		returnString[2]=orderTimeToBeDelieverd;

		System.out.println("order can be taken with another order");
		return returnString;
     }			
		}

		returnString[0]="NO";
 		returnString[1]="NO";
 		returnString[2]="NO";
 		return returnString;

			}	

}


//first 1k line in my life :)