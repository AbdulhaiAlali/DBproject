
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

    /**
     * GUIToppings class implemnts Action Listener .
     */

public class GUIToppings implements ActionListener  {

    /**
     * Creating new Frame (window)
     */

    JFrame window = new JFrame("Pizza Restaurant ");

    /**
     * Declaring the images of the buttons
     */

    ImageIcon icon = new ImageIcon("src/images/pizzaIcon.png");


    /**
     * Create a genearl label .Creating 3 Buttons and add thier icons (play , settings , exit ).
     */

    JLabel labelTopping = new JLabel();
    ImageIcon imageBackgroundlabelTopping = new ImageIcon("src/images/background3.png");
    JButton mushroom = new JButton("Mushroom");
    JButton salami = new JButton("Salami");
    JButton pineapple = new JButton("Pineapple");
    JButton union = new JButton("Union");
    JButton potato = new JButton("Potato");
    JButton cheese = new JButton("Cheese");
    JButton garlic = new JButton("Garlic");
    JButton chicken = new JButton("Chicken");
    JButton tomatoes = new JButton("Tomatoes");
    JButton redpepper = new JButton("Red pepper");


    Color color1 = new Color(247,203,108);

    boolean clicked = false;

    String selectedTopping="s";
    ArrayList drinkss = new ArrayList();
    ArrayList desertss = new ArrayList();

    ArrayList pizzas = new ArrayList();
    String pizza = "";

public GUIToppings(String pizza , ArrayList pizzas , ArrayList drinkss , ArrayList desertss) {

	this.pizza=pizza;
	this.pizzas=pizzas;
	this.drinkss =drinkss;
	this.desertss = desertss;

   /**
    * Implement the buttonS. set the bounds,the background color,the border and add the actionlistener
    */

    mushroom.setBounds(50,200,120,45);
    mushroom.addActionListener(this);
	mushroom.setBackground(color1);
	mushroom.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    salami.setBounds(50,275,120,45);
    salami.addActionListener(this);
	salami.setBackground(color1);
	salami.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    pineapple.setBounds(50,350,120,45);
    pineapple.addActionListener(this);
	pineapple.setBackground(color1);
	pineapple.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    union.setBounds(50,425,120,45);
    union.addActionListener(this);
	union.setBackground(color1);
	union.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    potato.setBounds(50,500,120,45);
    potato.addActionListener(this);
	potato.setBackground(color1);
	potato.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    cheese.setBounds(620,200,120,45);
    cheese.addActionListener(this);
	cheese.setBackground(color1);
	cheese.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    garlic.setBounds(620,275,120,45);
    garlic.addActionListener(this);
	garlic.setBackground(color1);
	garlic.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    chicken.setBounds(620,350,120,45);
    chicken.addActionListener(this);
	chicken.setBackground(color1);
	chicken.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    tomatoes.setBounds(620,425,120,45);
    tomatoes.addActionListener(this);
	tomatoes.setBackground(color1);
	tomatoes.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    redpepper.setBounds(620,500,120,45);
    redpepper.addActionListener(this);
	redpepper.setBackground(color1);
	redpepper.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

   /**
    *  Set the label icon
    *  Set the label location
    *  Set the label background color.
    *  Add the buttons to one label.
    */
    labelTopping.setIcon(imageBackgroundlabelTopping);
    labelTopping.setHorizontalAlignment(JLabel.CENTER);
    labelTopping.setVerticalAlignment(JLabel.CENTER);
    labelTopping.setBackground(Color.WHITE);
    labelTopping.setOpaque(true);
    labelTopping.add(mushroom);
    labelTopping.add(salami);
    labelTopping.add(pineapple);
    labelTopping.add(union);
    labelTopping.add(potato);
    labelTopping.add(cheese);
    labelTopping.add(garlic);
    labelTopping.add(chicken);
    labelTopping.add(tomatoes);
    labelTopping.add(redpepper);

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
    window.add(labelTopping);
    window.setIconImage(icon.getImage());
    window.setVisible(true);

}

public String selectedTopping(){
	System.out.println(selectedTopping);
	return selectedTopping;
}
public boolean clicked(){
		System.out.println(clicked);

	return clicked;
}
 /**
   *  Creat an Action listener method.
   *  @param e which is the buttons that have an ActionListener.
   */


@Override
public void actionPerformed(ActionEvent e){

 

    DBmaper DBmaper = null;
	try {
		DBmaper = new DBmaper();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}

	//SELECTING THE TOPPING 



	Object source = e.getSource();
	String butText = "";

    if(source instanceof JButton){
		JButton btn = (JButton)source;
		butText = btn.getText();
		try {
			pizzas.add(DBmaper.insertPizza(pizza,butText,1));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	     window.dispose();

    	GUImenu GUImenu = new GUImenu(pizzas,drinkss,desertss);

 }

}
   
}
