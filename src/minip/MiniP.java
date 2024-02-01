package minip;

import static java.lang.System.exit;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MiniP {

public static void pressEnterToContinue()
    { 
        System.out.println("\n     >>>>   Press Enter key to continue...\n\n");
        try
        {
            System.in.read();
        }  
        catch(IOException e)
        {} 
    }

   public static void menu() throws SQLException {
    JFrame frame = new JFrame("MiniP - Authentification");
    frame.setSize(400, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JLabel label = new JLabel("Choisissez une option:");
    label.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(label);

    JButton loginButton = new JButton("Se connecter à l'application pharmacie");
    loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(loginButton);

    JButton newUserButton = new JButton("Créer un nouveau compte utilisateur");
    newUserButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(newUserButton);

    JButton quitButton = new JButton("Quitter l'appli1cation");
    quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(quitButton);

    frame.add(panel);
    frame.setVisible(true);

loginButton.addActionListener(e -> {
        System.out.println("\n ++++++ Choix 1 : Se connecter à l'application pharma   ++++++ \n");
        AuthenticationGUI auth = new AuthenticationGUI();
        frame.dispose();
    });

    newUserButton.addActionListener(e -> {
        System.out.println("\n ++++++ Choix 2 : Créer un nouveau compte utilisateur  ++++++ \n");
        User u = new User();
        try {
            u.addUser();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     
        frame.dispose();
    });

    quitButton.addActionListener(e -> {
        System.out.println("\n   Merci \n   -------   Fin de Programme   -------");
        exit(0);
    });
}

   public static void main(String[] args) throws SQLException {
    SwingUtilities.invokeLater(() -> {
        try {
            menu();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    });
}
}