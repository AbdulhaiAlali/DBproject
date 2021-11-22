
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

    /**
     * Menu class implemnts Action Listener .
     */

public class GUIstart implements ActionListener  {

    /**
     * Creating new Frame (window)
     */

    JFrame window = new JFrame("Pizza Restaurant ");

    /**
     * Declaring the images of the buttons
     */

    ImageIcon imageNewOrder = new ImageIcon("src/images/neworder.png");
    ImageIcon imageMyorders = new ImageIcon("src/images/myorders.png");
    ImageIcon imageExit = new ImageIcon("src/images/close.png");
    ImageIcon imageBackground = new ImageIcon("src/images/background.jpg");
    ImageIcon icon = new ImageIcon("src/images/pizzaIcon.png");


    /**
     * Create a genearl label .Creating 3 Buttons and add thier icons (play , settings , exit ).
     */

    JLabel label = new JLabel();
    JLabel label2 = new JLabel();

    JButton neworder = new JButton(imageNewOrder);
    JButton myorders = new JButton(imageMyorders);
    JButton exit = new JButton(imageExit);

    Color color1 = new Color(189,228,247);

public GUIstart() {


   /**
    * Implement the neworder button. set the bounds,the background color,the border and add the actionlistener
    */

    neworder.setBounds(225,338,350,100);
    neworder.addActionListener(this);
	neworder.setBackground(color1);
//	play.setBorder(BorderFactory.createBevelBorder(1, Color.red , Color.blue , Color.blue , Color.red));

   /**
    * Implement the myorders button. set the bounds,the background color,the border and add the actionlistener
    */

    myorders.setBounds(225,476,350,100);
    myorders.addActionListener(this);
    myorders.setBackground(color1);
  //  settings.setBorder(BorderFactory.createBevelBorder(1, Color.red , Color.blue , Color.blue , Color.red));

   /**
    * Implement the exit button. set the bounds,the background color,the border and add the actionlistener
    */

    exit.setBounds(750,11,34,34);
    exit.addActionListener(this);
    exit.setBackground(color1);
   // exit.setBorder(BorderFactory.createBevelBorder(1, Color.red , Color.blue , Color.blue , Color.red));



   /**
    *  Set the label icon
    *  Set the label location
    *  Set the label background color.
    *  Add the buttons to one label.
    */
    label.setIcon(imageBackground);
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setVerticalAlignment(JLabel.CENTER);
    label.setBackground(Color.WHITE);
    label.setOpaque(true);
    label.add(neworder);
    label.add(myorders);
    label.add(exit);

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
    window.add(label2);
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

    /**
     *  If neworder button clicked create new GUImenu class.
     *  Dispose the current frame.
     */

    if(e.getSource()==neworder){
     window.dispose();
            ArrayList pizzas = new ArrayList();

     GUImenu GUImenu = new GUImenu(pizzas);}

    /**
     *  If myorders button clicked create new GUImyOrders class.
     *  Dispose the current frame.
     */

    if(e.getSource()==myorders){
     window.dispose();
     GUImyOrders GUImyOrders = new GUImyOrders();
     }
    /**
     *  If exit clicked close the frame.
     *  Dispose the current frame.
     */

    if(e.getSource()==exit){
     window.dispose();
    }




}
    public static void main(String[] args) {
        GUIstart GUIstart = new GUIstart();
    }
}
