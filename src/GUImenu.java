
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

    /**
     * Menu class implemnts Action Listener .
     */

public class GUImenu implements ActionListener  {

    /**
     * Creating new Frame (window)
     */

    JFrame window = new JFrame("Pizza Restaurant");

    /**
     * Declaring the images of the buttons
     */

    ImageIcon imageCheckout = new ImageIcon("src/images/checkout.png");
    ImageIcon imageback = new ImageIcon("src/images/back.png");

    ImageIcon backgroundVeg = new ImageIcon("src/images/pizzaVegetarian.jpg");
    ImageIcon backgroundMeat = new ImageIcon("src/images/pizzaMeat.jpg");
    ImageIcon backgroundDrinks = new ImageIcon("src/images/backgroundDrinks.jpg");
    ImageIcon backgroundDessert = new ImageIcon("src/images/backgroundDessert.jpg");

    ImageIcon icon = new ImageIcon("src/images/pizzaIcon.png");


    /**
     * Create a genearl label .Creating 3 Buttons and add thier icons (play , settings , exit ).
     */

    JLabel labelPizzaMeat = new JLabel();
    JLabel labelPizzaVeg = new JLabel();
    JLabel labelDrinks = new JLabel();
    JLabel labelDessert = new JLabel();

    JButton checkout = new JButton(imageCheckout);
    JButton back = new JButton(imageback);

    JButton pizzaChicken = new JButton("Chicken");
    JButton pizzaPepperoni = new JButton("Pepperoni");
    JButton pizzaMeat = new JButton("Meat");
    JButton pizzaBBQ = new JButton("BBQ");
    JButton pizzaSalami = new JButton("Salami");

    JButton pizzaVeggie = new JButton("Veggie");
    JButton pizzaMargherita = new JButton("Margherita");
    JButton pizzaCheese = new JButton("Cheese");
    JButton pizzaHawaaian = new JButton("Hawaaian");
    JButton pizzaVegetables = new JButton("Vegetables");

    JButton drinksCola = new JButton("Cola");
    JButton drinksJuice = new JButton("Juice");
    JButton drinksFanta = new JButton("Fanta");
    JButton drinksWater = new JButton("Water");

    JButton dessertsCake = new JButton("Cake");
    JButton dessertsWafel = new JButton("Wafel");

    JComboBox products = new JComboBox();

    Color color1 = new Color(247,203,108);

    boolean labelMeat =true;
	boolean labelVeg;
	boolean labelDrink;
	boolean labelDess;


	//DBmaper DBmaper = new DBmaper();

    ArrayList pizzas = new ArrayList();
    ArrayList drinkss = new ArrayList();
    ArrayList desertss = new ArrayList();

public GUImenu(ArrayList pizzas,ArrayList drinkss,ArrayList desertss) {

	this.pizzas = pizzas;
	this.drinkss =drinkss;
	this.desertss = desertss;


	products.addItem("Meat Pizzas");
	products.addItem("Vegetarian Pizzas");
	products.addItem("Drinks");
	products.addItem("Desserts");
    products.setBounds(490,25,216,37);
    products.addActionListener(this);
	products.setBackground(color1);
	products.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));


   /**
    * Implement the  buttons. set the bounds,the background color,the border and add the actionlistener
    */

    checkout.setBounds(580,550,216,37);
    checkout.addActionListener(this);
	checkout.setBackground(color1);
	checkout.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    back.setBounds(0,0,40,40);
    back.addActionListener(this);
	back.setBackground(color1);

//
    pizzaChicken.setBounds(20,300,200,37);
    pizzaChicken.addActionListener(this);
	pizzaChicken.setBackground(color1);
	pizzaChicken.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    pizzaPepperoni.setBounds(20,513,200,37);
    pizzaPepperoni.addActionListener(this);
	pizzaPepperoni.setBackground(color1);
	pizzaPepperoni.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    pizzaMeat.setBounds(300,300,200,37);
    pizzaMeat.addActionListener(this);
	pizzaMeat.setBackground(color1);		
	pizzaMeat.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    pizzaBBQ.setBounds(300,513,200,37);
    pizzaBBQ.addActionListener(this);
	pizzaBBQ.setBackground(color1);
	pizzaBBQ.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    pizzaSalami.setBounds(560,300,200,37);
    pizzaSalami.addActionListener(this);
	pizzaSalami.setBackground(color1);		
	pizzaSalami.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

//
    pizzaVeggie.setBounds(20,300,200,37);
    pizzaVeggie.addActionListener(this);
	pizzaVeggie.setBackground(color1);
	pizzaVeggie.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    pizzaMargherita.setBounds(20,513,200,37);
    pizzaMargherita.addActionListener(this);
	pizzaMargherita.setBackground(color1);
	pizzaMargherita.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    pizzaCheese.setBounds(300,300,200,37);
    pizzaCheese.addActionListener(this);
	pizzaCheese.setBackground(color1);		
	pizzaCheese.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    pizzaHawaaian.setBounds(300,513,200,37);
    pizzaHawaaian.addActionListener(this);
	pizzaHawaaian.setBackground(color1);
	pizzaHawaaian.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    pizzaVegetables.setBounds(560,300,200,37);
    pizzaVegetables.addActionListener(this);
	pizzaVegetables.setBackground(color1);		
	pizzaVegetables.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));



    drinksCola.setBounds(20,300,200,37);
    drinksCola.addActionListener(this);
	drinksCola.setBackground(color1);
	drinksCola.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    drinksJuice.setBounds(20,513,200,37);
    drinksJuice.addActionListener(this);
	drinksJuice.setBackground(color1);
	drinksJuice.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    drinksFanta.setBounds(300,300,200,37);
    drinksFanta.addActionListener(this);
	drinksFanta.setBackground(color1);	
	drinksFanta.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    drinksWater.setBounds(560,300,200,37);
    drinksWater.addActionListener(this);
	drinksWater.setBackground(color1);	
	drinksWater.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    dessertsCake.setBounds(20,300,200,37);
    dessertsCake.addActionListener(this);
	dessertsCake.setBackground(color1);
	dessertsCake.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    dessertsWafel.setBounds(300,300,200,37);
    dessertsWafel.addActionListener(this);
	dessertsWafel.setBackground(color1);	
	dessertsWafel.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

   /**
    *  Set the label icon
    *  Set the label location
    *  Set the label background color.
    *  Add the buttons to one label.
    */

    labelPizzaMeat.setIcon(backgroundMeat);
    labelPizzaMeat.setHorizontalAlignment(JLabel.CENTER);
    labelPizzaMeat.setVerticalAlignment(JLabel.CENTER);
    labelPizzaMeat.setBackground(Color.WHITE);
    labelPizzaMeat.setOpaque(true);

    labelPizzaMeat.add(pizzaChicken);
    labelPizzaMeat.add(pizzaPepperoni);
    labelPizzaMeat.add(pizzaMeat);
    labelPizzaMeat.add(pizzaBBQ);
    labelPizzaMeat.add(pizzaSalami);

    labelPizzaVeg.setIcon(backgroundVeg);
    labelPizzaVeg.setHorizontalAlignment(JLabel.CENTER);
    labelPizzaVeg.setVerticalAlignment(JLabel.CENTER);
    labelPizzaVeg.setBackground(Color.WHITE);
    labelPizzaVeg.setOpaque(true);

    labelPizzaVeg.add(pizzaVeggie);
    labelPizzaVeg.add(pizzaMargherita);
    labelPizzaVeg.add(pizzaCheese);
    labelPizzaVeg.add(pizzaHawaaian);
    labelPizzaVeg.add(pizzaVegetables);
    labelPizzaVeg.setVisible(false);

    labelDrinks.setIcon(backgroundDrinks);
    labelDrinks.setHorizontalAlignment(JLabel.CENTER);
    labelDrinks.setVerticalAlignment(JLabel.CENTER);
    labelDrinks.setBackground(Color.WHITE);
    labelDrinks.setOpaque(true);
    labelDrinks.add(drinksWater);
    labelDrinks.add(drinksFanta);
    labelDrinks.add(drinksJuice);
    labelDrinks.add(drinksCola);
    labelDrinks.setVisible(false);

    labelDessert.setIcon(backgroundDessert);
    labelDessert.setHorizontalAlignment(JLabel.CENTER);
    labelDessert.setVerticalAlignment(JLabel.CENTER);
    labelDessert.setBackground(Color.WHITE);
    labelDessert.add(dessertsWafel);
    labelDessert.add(dessertsCake);
    labelDessert.setOpaque(true);

    labelDessert.setVisible(false);




    /**
     *  Set how to close the frame.
     *  Set the size of the frame.
     *  Adding the label to the frame.
     *  Set the frame visible.
     */
    window.setUndecorated(true);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(800, 600);
    window.setLocationRelativeTo(null);
    window.add(checkout);	
    window.add(products);
    window.add(back);
    window.add(labelPizzaMeat); 	


    window.setIconImage(icon.getImage());
    window.setVisible(true);

}

 /**
   *  Creat an Action listener method.
   *  @param e which is the buttons that have an ActionListener.
   */


@Override
public void actionPerformed(ActionEvent e){

    /**
     *  selecting the pizza and the topping
     */

	String butText = "";


    if(e.getSource()==back){
     window.dispose();
     GUIstart GUIstart = new GUIstart();
 }
    if(e.getSource()==checkout && !pizzas.isEmpty()){
     window.dispose();
     GUIcheckout GUIcheckout = new GUIcheckout(pizzas,drinkss,desertss);
 }
    if(e.getSource()==checkout && pizzas.isEmpty()){
     JOptionPane.showMessageDialog(checkout,"Order At Least 1 Pizza" );
 }




     String selected = (String) products.getSelectedItem();

         window.repaint();	

    if(selected=="Meat Pizzas"){
         labelPizzaMeat.setVisible(true);
         labelPizzaVeg.setVisible(false);
         labelDessert.setVisible(false);
         labelDrinks.setVisible(false);

    }
    if(selected=="Vegetarian Pizzas"){
         labelPizzaVeg.setVisible(true);
         labelDessert.setVisible(false);
         labelPizzaMeat.setVisible(false);
         labelDrinks.setVisible(false);
          window.add(labelPizzaVeg); 	

    }
    if(selected=="Drinks"){
         labelPizzaMeat.setVisible(false);
         labelPizzaVeg.setVisible(false);
         labelDessert.setVisible(false);
         labelDrinks.setVisible(true);
         window.add(labelDrinks); 	

    }
    if(selected=="Desserts"){
         labelPizzaMeat.setVisible(false);
         labelPizzaVeg.setVisible(false);
         labelDessert.setVisible(true);
         labelDrinks.setVisible(false);
         window.add(labelDessert); 
    }    

	Object source = e.getSource();
	if(source instanceof JButton &&e.getSource()!=back &&e.getSource()!=checkout && selected!="Drinks"&& selected!="Desserts") {
		JButton btn = (JButton)source;
		butText = btn.getText();
		System.out.println(butText);
		     window.dispose();
     GUIToppings GUIToppings = new GUIToppings(butText,pizzas,drinkss,desertss);
	}
 	if(source instanceof JButton && selected=="Drinks" ) {
		JButton btn = (JButton)source;
		String textBtn = btn.getText();
		System.out.println(textBtn);
		drinkss.add(textBtn);

	}  
 	if(source instanceof JButton && selected=="Desserts" ) {
		JButton btn = (JButton)source;
		String textBtn = btn.getText();
		System.out.println(textBtn);
		desertss.add(textBtn);
	} 	
}}
