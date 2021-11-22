
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

    /**
     * Menu class implemnts Action Listener .
     */

public class GUImyOrders implements ActionListener  {

    /**
     * Creating new Frame (window)
     */

    JFrame window = new JFrame("Pizza Restaurant ");

    /**
     * Declaring the images of the buttons
     */
    JLabel label = new JLabel();
    ImageIcon imageBackgroundlabel = new ImageIcon("src/images/background6.jpg");
    JButton cancel = new JButton("cancel");
    ImageIcon imageback = new ImageIcon("src/images/back.png");

    ImageIcon icon = new ImageIcon("src/images/pizzaIcon.png");
    Color color1 = new Color(247,203,108);
    JButton back = new JButton(imageback);

public GUImyOrders() {

    back.setBounds(0,0,40,40);
    back.addActionListener(this);
    back.setBackground(color1);

    cancel.setBounds(680,540,100,40);
    cancel.addActionListener(this);
    cancel.setBackground(color1);
    cancel.setBorder(BorderFactory.createBevelBorder(1, Color.black , Color.black , Color.red , Color.black));

    label.setIcon(imageBackgroundlabel);
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setVerticalAlignment(JLabel.CENTER);
    label.setBackground(Color.WHITE);
    label.setOpaque(true);
    label.add(cancel);  
    label.add(back);  

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
    if(e.getSource()==back){
     window.dispose();
     GUIstart GUIstart = new GUIstart();
 }

}
   
}
