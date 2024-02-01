package minip;

import java.awt.Component;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



public class CustomerGUI {
    public static void customerMenu() throws SQLException{
      
       JFrame frame = new JFrame("MiniP - customer");
    frame.setSize(400, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    JLabel label = new JLabel("Choisissez une option:");
    label.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(label);

    JButton Button1= new JButton("addCustomer");
    Button1.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(Button1);

    JButton Button2 = new JButton("updateCustomer");
    Button2.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(Button2);

    JButton Button3 = new JButton("deleteCustomer");
    Button3.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(Button3);
    
    
    JButton Button4 = new JButton("getCustomerById");
    Button4.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(Button4);
     
    JButton Button5 = new JButton("getAllCustomers()");
    Button5.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(Button5);


    frame.add(panel);
    frame.setVisible(true);
    
    
Button1.addActionListener(e -> {
        System.out.println("\n ++++++ Choix 1 : addCustomer   ++++++ \n");
          new AddCustomerGUI();
         frame.dispose(); 
    });

    Button2.addActionListener(e -> {
        System.out.println("\n ++++++ Choix 2 : updateCustomer  ++++++ \n");
        CustomerGUI add = new CustomerGUI();
        frame.dispose();
    });

    Button3.addActionListener(e -> {
        System.out.println("\n ++++++ Choix 3 : deleteCustomer  ++++++ \n");
        CustomerGUI add = new CustomerGUI();
        frame.dispose();
    });
    
    Button4.addActionListener(e -> {
        System.out.println("\n ++++++ Choix 4 : getCustomerById  ++++++ \n");
        CustomerGUI add = new CustomerGUI();
        frame.dispose();
    });
    
    Button5.addActionListener(e -> {
        System.out.println("\n ++++++ Choix 5 : getAllCustomers()  ++++++ \n");
        new getAllCustGUI();
        frame.dispose();
    });
      
    }
    
            }

//
