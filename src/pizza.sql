drop database pizza;
create database pizza;
	use pizza;


	create table ToppingsList(
		ToppingsName varchar(25),
		ToppingsPrice float,
		constraint toppings_pk primary key(ToppingsName)
		);


	create table PizzasList(
		PizzaName varchar(25),
		Price float,
		constraint pizzas_pk primary key(PizzaName)
		);


	create table Pizza(
		PizzaKey int,
		PizzaName varchar(25),
		ToppingsName varchar(25),		
		PizzaPrice float ,
		Quantity int,
		primary key(PizzaKey),
		foreign key(PizzaName) REFERENCES PizzasList(PizzaName),
		foreign key(ToppingsName) REFERENCES ToppingsList(ToppingsName)
		);	


	create table Drinks(
		DrinkKey int,
		DrinkName varchar(25),
		PizzaPrice float ,
		Quantity int,
		primary key(DrinkKey)
		);
	create table Desserts(
		DessertKey int,
		DessertName varchar(25),
		PizzaPrice float ,
		Quantity int,
		primary key(DessertKey)
		);

	create table Customer(
		CustomerID int,
		PhoneNumber int,
		Name varchar(25),		
		Address varchar(25) ,
		PostalCode int,
		NumberOFpizzas int,
		primary key(CustomerID)
		);
	create table Discount(
		DiscountKey int,
		CustomerID int,
		DiscountCode int,
		DiscountUSEDorNOT varchar(25),
		primary key(DiscountKey),
		foreign key(CustomerID) REFERENCES Customer(CustomerID)
		);	
	create table DeliveryPerson(
		DeliveryPersonID int,
		OrderKey int DEFAULT NULL,
		PostalCode int,
		isDelivering varchar(25),
		primary key(DeliveryPersonID)
		);	
	create table Orders(
		OrderKey int,
		OrderDate varchar(25),
		OrderTime varchar(25),
		OrderTimeToDeliver varchar(25),
		CustomerID int,
		DeliveryPersonID int,		
		AmountPaid float,
		primary key(OrderKey),
		foreign key(CustomerID) REFERENCES Customer(CustomerID),
		foreign key(DeliveryPersonID) REFERENCES DeliveryPerson(DeliveryPersonID)
		);

	create table PizzaOrder(
		PizzaOrderKey int,
		OrderKey int,
		PizzaKey int,
		primary key(PizzaOrderKey),
		foreign key(OrderKey) REFERENCES Orders(OrderKey),		
		foreign key(PizzaKey) REFERENCES Pizza(PizzaKey)	
		);
	create table DrinkOrder(
		DrinkOrderKey int,
		OrderKey int,
		DrinkKey int,
		primary key(DrinkOrderKey),
		foreign key(OrderKey) REFERENCES Orders(OrderKey),	
		foreign key(DrinkKey) REFERENCES Drinks(DrinkKey)		
		);
	create table DessertOrder(
		DessertOrderKey int,
		OrderKey int,
		DessertKey int,
		primary key(DessertOrderKey),
		foreign key(OrderKey) REFERENCES Orders(OrderKey),	
		foreign key(DessertKey) REFERENCES Desserts(DessertKey)		
		);	
/**********************************************************************************/
