package minip;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AuthenticationGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    private JTextField usernameField;
    private JPasswordField passwordField;

    public AuthenticationGUI() {
        super("Authentification");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Nom d'utilisateur:");
        userLabel.setBounds(10, 20, 120, 25);
        panel.add(userLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(130, 20, 165, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Mot de passe:");
        passwordLabel.setBounds(10, 50, 120, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(130, 50, 165, 25);
        panel.add(passwordField);

        JButton loginButton = new JButton("Se connecter");
        loginButton.setBounds(130, 90, 120, 25);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                try {
                    Connection conn = DataBaseConn.getConnection();
                    String strSql = "SELECT * FROM users WHERE login=? AND passwd=?";
                    PreparedStatement stmt = conn.prepareStatement(strSql);
                    stmt.setString(1, username);
                    stmt.setString(2, password);
                    ResultSet res = stmt.executeQuery();

                    if (res.next()) {
                        strSql = "UPDATE users SET ConnectionNbr=ConnectionNbr+1 WHERE iduser=?";
                        PreparedStatement stUpdate = conn.prepareStatement(strSql);
                        stUpdate.setInt(1, res.getInt("iduser"));
                        stUpdate.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Connexion réussie", "Succès",
                                JOptionPane.INFORMATION_MESSAGE);
                        dispose(); // close the authentication window
                        gestionGUI.gestionsMenu(); // open the main application window
                    } else {
                        JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe incorrect", "Erreur",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erreur lors de la connexion à la base de données", "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(loginButton);

        getContentPane().add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AuthenticationGUI();
        
  
    }
}
