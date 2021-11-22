
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

    /**
     * GUImyOrders class implemnts Action Listener .
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

    JLabel[] bill = null;

    ArrayList<String> billArray = new ArrayList();

    double countAmountPaid=0;
    JLabel amountPaid = new JLabel();

    JLabel theStatus = new JLabel();
    String theStatusS = "";
    int orderKey;

   // Font font1 = new Font("Verdana",Font.PLAIN,50);
public GUImyOrders(int orderKey) {

    this.orderKey=orderKey;

    DBmaper DBmaper1 = null;
	try {
        DBmaper1 = new DBmaper();
    } catch (SQLException e2) {
        // TODO Auto-generated catch block
        e2.printStackTrace();
    }
    try {
        billArray = DBmaper1.getBill(orderKey);
        countAmountPaid = DBmaper1.countAmountPaid(orderKey);
        theStatusS = DBmaper1.getStatus(orderKey);
        DBmaper1.updateStatus();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    bill = new JLabel[billArray.size()];
    int space =100/bill.length*4;
    if (bill.length > 15) {
        space =100/bill.length*5;
    }
    for (int i =0; i< bill.length ;i++ ) {
        bill[i] = new JLabel(billArray.get(i));
        bill[i].setBounds(20,30 + (i*space),10000,100);
        bill[i].setFont(new Font("Verdana",Font.PLAIN,20));
    }


    theStatus.setText(" " + theStatusS);
    theStatus.setBounds(230,510,400,100);
    theStatus.setFont(new Font("Verdana",Font.PLAIN,20));

    amountPaid.setText("Amount " + countAmountPaid+"$");
    amountPaid.setBounds(510,510,200,100);
    amountPaid.setFont(new Font("Verdana",Font.PLAIN,20));

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

    for (int i =0; i< bill.length ;i++ ) {
    window.add(bill[i]); 
    }

    window.add(theStatus);
    window.add(amountPaid);
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

    DBmaper DBmaper = null;
    try {
        DBmaper = new DBmaper();
    } catch (SQLException e2) {
        // TODO Auto-generated catch block
        e2.printStackTrace();
    }

    if(e.getSource()==cancel){
        try {
            String canceleString = DBmaper.cancelTHEoRDER(orderKey);
            JOptionPane.showMessageDialog(cancel,canceleString);
        
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
 }
}
   
}
