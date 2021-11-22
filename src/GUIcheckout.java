
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

    /**
     * GUIcheckout class implemnts Action Listener .
     */

public class GUIcheckout implements ActionListener  {

    /**
     * Creating new Frame (window)
     */

    JFrame window = new JFrame("Pizza Restaurant");

    /**
     * Declaring the images of the buttons
     */
    JLabel label = new JLabel();
    JLabel totalTOpay = new JLabel("");

    ImageIcon imageBackgroundlabel = new ImageIcon("src/images/background4.jpg");
    JButton pay = new JButton("PAY");
    JButton checkCode = new JButton("CHECK");

    ImageIcon icon = new ImageIcon("src/images/pizzaIcon.png");
    Color color1 = new Color(247,203,108);

    ArrayList pizzas = new ArrayList();
    ArrayList drinks = new ArrayList();
    ArrayList deserts = new ArrayList();

   JComboBox postcodes = new JComboBox();

   JTextField customerName = new JTextField();
   JTextField customerPhone = new JTextField("0");
   JTextField customerAdress = new JTextField();
   JTextField discountCode = new JTextField("0");
    DBmaper DBmaper1 = null;
		double amount =0;


   // private static DecimalFormat df2 = new DecimalFormat("#.##");

public GUIcheckout(ArrayList pizzas , ArrayList drinks,ArrayList deserts) {

	this.pizzas=pizzas;
  	this.drinks=drinks;
	this.deserts=deserts;





	try {
		DBmaper1 = new DBmaper();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	try {
		amount = DBmaper1.countAmountTOpay(pizzas,drinks,deserts);
    	totalTOpay.setText(String.format("%.2f",amount));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	

    pay.setBounds(680,530,100,50);
    pay.addActionListener(this);
	pay.setBackground(color1);
	pay.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.green , Color.black));

    checkCode.setBounds(550,440,100,50);
    checkCode.addActionListener(this);
	checkCode.setBackground(color1);
	checkCode.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    customerName.setFont(new Font("Consolas",Font.PLAIN,35));
    customerName.setForeground(Color.darkGray);
    customerName.setBackground(color1);
    customerName.setCaretColor(Color.blue);
    customerName.setBounds(350,120,350,50);

    customerPhone.setFont(new Font("Consolas",Font.PLAIN,35));
    customerPhone.setForeground(Color.darkGray);
    customerPhone.setBackground(color1);
    customerPhone.setCaretColor(Color.blue);
    customerPhone.setBounds(450,185,250,50);

    customerAdress.setFont(new Font("Consolas",Font.PLAIN,35));
    customerAdress.setForeground(Color.darkGray);
    customerAdress.setBackground(color1);
    customerAdress.setCaretColor(Color.blue);
    customerAdress.setBounds(250,280,450,50);

    discountCode.setFont(new Font("Consolas",Font.PLAIN,35));
    discountCode.setForeground(Color.darkGray);
    discountCode.setBackground(color1);
    discountCode.setCaretColor(Color.blue);
    discountCode.setBounds(330,440,200,50);

	postcodes.addItem(6211);
	postcodes.addItem(6181);
	postcodes.addItem(6222);	
    postcodes.setBounds(310,370,390,50);
    postcodes.addActionListener(this);
	postcodes.setBackground(color1);
	postcodes.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));


	totalTOpay.setBounds(500,520,400,50);
	totalTOpay.setFont(new Font("Serif", Font.PLAIN, 50));

    label.setIcon(imageBackgroundlabel);
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setVerticalAlignment(JLabel.CENTER);
    label.setBackground(Color.WHITE);
    label.setOpaque(true);
    label.add(pay);  
    label.add(customerName);  
    label.add(customerPhone);  
    label.add(customerAdress);  
    label.add(postcodes);  
    label.add(discountCode);  
    label.add(checkCode);  

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
    window.add(totalTOpay);
    window.add(label);

    window.setIconImage(icon.getImage());
    window.setVisible(true);

}

 /**
   *  Creat an Action listener method.
   *  @param e which is the buttons that have an ActionListener.
   */

@Override
public void actionPerformed(ActionEvent e){

     int postcode = (int) postcodes.getSelectedItem();
     System.out.println(postcode);

     String name = customerName.getText();
     String adress = customerAdress.getText();
     String phoneNumberStr = customerPhone.getText();
     int phoneNumber = 0;
     double totalTOpayint=0;
	     	 
     try{
     	 phoneNumber = Integer.parseInt(phoneNumberStr);
     	 totalTOpayint = Double.parseDouble(totalTOpay.getText());
     }
     catch(NumberFormatException ex){
     	ex.printStackTrace();
     }



    DBmaper DBmaper = null;
	try {
		DBmaper = new DBmaper();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}

     int code = 0;     	 
     try{
     	 code = Integer.parseInt(discountCode.getText());
     }
     catch(NumberFormatException ex){
     	ex.printStackTrace();
     }

    if(e.getSource()==checkCode){

		try {
			String validornot = DBmaper.checkDiscountCODE(code);
    		JOptionPane.showMessageDialog(checkCode,validornot);
    		if (validornot.equals("VALID")) {
    			 amount = amount-((amount*10)/100);
    			totalTOpay.setText(String.format("%.2f",amount));
    		}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

    
    }




	//SELECTING THE TOPPING 

    if(e.getSource()==pay){
    	
    	int orderKey=0;
		try {
			int customerID = DBmaper.insertCustomer(phoneNumber,name,adress,postcode,pizzas.size());
    		JOptionPane.showMessageDialog(pay,DBmaper.checkCustomerPizzasNumber(customerID) );

    		 orderKey = DBmaper.insertOrder(customerID,totalTOpayint,postcode);
    		DBmaper.InsertPizzaOrder(orderKey,pizzas);

    		if (!drinks.isEmpty()) {
    			DBmaper.InsertDrinkOrder(orderKey,drinks);
    		}
    		if (!deserts.isEmpty()) {
    			DBmaper.InsertDessertOrder(orderKey,deserts);
    		}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

    	window.dispose();
    	GUImyOrders GUImyOrders = new GUImyOrders(orderKey);

 }



}
   
}
