package minip;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

public class User extends JFrame {
    private JTextField loginField, passwdField;
    private JButton addButton;

    public User() {
        super("MiniP - Ajout d'utilisateur");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel label = new JLabel("Ajout d'un nouveau utilisateur:");
        label.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(label);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        JLabel loginLabel = new JLabel("Login:");
        inputPanel.add(loginLabel);
        loginField = new JTextField(20);
        inputPanel.add(loginField);
        JLabel passwdLabel = new JLabel("Mot de passe:");
        inputPanel.add(passwdLabel);
        passwdField = new JTextField(20);
        inputPanel.add(passwdField);
        panel.add(inputPanel);

        addButton = new JButton("Ajouter");
        addButton.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(addButton);

        add(panel);

        addButton.addActionListener(e -> {
            String slog = loginField.getText();
            String spass = passwdField.getText();
            PreparedStatement stmt;
            try {
                stmt = DataBaseConn.getConnection().prepareStatement("INSERT INTO users(login, passwd) VALUES (?,?)");
                stmt.setString(1, slog);
                stmt.setString(2, spass);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "L'utilisateur " + slog + " est ajouté avec succès");
                dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erreur: " + ex.getMessage(), "Erreur d'ajout", JOptionPane.ERROR_MESSAGE);
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void addUser() throws SQLException {
    User gui = new User();
}

}

/*khesna ndirou 2 class addUser() et deleteUser() le code li lfou9 howa addUser() w hada li te7t howa delete 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class DeleteUserGUI {

    public static void display() {
        JFrame frame = new JFrame("MiniP - Suppression d'utilisateur");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel label = new JLabel("Supprimer un utilisateur :");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);

        JTextField loginField = new JTextField(20);
        loginField.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(loginField);

        JButton deleteButton = new JButton("Supprimer");
        deleteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(deleteButton);

        JButton cancelButton = new JButton("Annuler");
        cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cancelButton);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        deleteButton.addActionListener((ActionEvent e) -> {
            try {
                String login = loginField.getText().trim();
                User user = new User();
                user.deleteUser(login);
                JOptionPane.showMessageDialog(null, "L'utilisateur " + login + " a été supprimé avec succès.");
                frame.dispose();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de la suppression de l'utilisateur.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener((ActionEvent e) -> {
            frame.dispose();
        });
    }
}

*/