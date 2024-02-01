package minip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddCustomerGUI extends JFrame implements ActionListener {
    private JTextField idField, nameField, emailField, phoneField;
    private JButton addButton;

    public AddCustomerGUI() {
        setTitle("Add Customer");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        JLabel phoneLabel = new JLabel("Phone:");
        phoneField = new JTextField();

        addButton = new JButton("Add");
        addButton.addActionListener(this);

        panel.add(idLabel);
        panel.add(idField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(addButton);

        add(panel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String email = emailField.getText();
                int phone = Integer.parseInt(phoneField.getText());

                Customer customer = new Customer(id, name, email, phone);
                Customer.addCustomer(customer);
                
                JOptionPane.showMessageDialog(this, "Customer added successfully!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error adding customer:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number for ID and phone!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    
}
