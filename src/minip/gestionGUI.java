package minip;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



public class gestionGUI {
    public static void gestionsMenu() throws SQLException{
      
       JFrame frame = new JFrame("MiniP - gestion");
    frame.setSize(400, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    JLabel label = new JLabel("Choisissez une option:");
    label.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(label);

    JButton loginButton = new JButton("GESTION CUSTOMER");
    loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(loginButton);

    JButton newUserButton = new JButton("GESTION DRUGS");
    newUserButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(newUserButton);

    JButton quitButton = new JButton("GESTION ORDERS");
    quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(quitButton);

    frame.add(panel);
    frame.setVisible(true);
    
    
loginButton.addActionListener((ActionEvent e) -> {
        System.out.println("\n ++++++ Choix 1 : GESTION CUSTOMER   ++++++ \n");
        try {
            CustomerGUI.customerMenu();
        } catch (SQLException ex) {
        }
     
        frame.dispose();
   
    });

    newUserButton.addActionListener(e -> {
        System.out.println("\n ++++++ Choix 2 : GESTION DRUGS  ++++++ \n");
           try {
            CustomerGUI.customerMenu();
        } catch (SQLException ex) {
        }
     
        frame.dispose();
   
    });
    }
    

   public static void main(String[] args) throws SQLException {
    SwingUtilities.invokeLater(() -> {
        try {
            gestionsMenu();
        } catch (SQLException e) {
            e.printStackTrace();
        }
});

            }
}
//
