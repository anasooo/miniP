package minip;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class getAllCustGUI extends JFrame {
    private JTable customersTable;

    public getAllCustGUI() {
        // Set window properties
        setTitle("Customers List");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create table
        customersTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(customersTable);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Add button to getALLCustomer table
        JButton refreshButton = new JButton("getAllCustomer");
        refreshButton.addActionListener(e -> getAllCustomersTable());
        getContentPane().add(refreshButton, BorderLayout.SOUTH);
    
        // Show window
        setVisible(true);
    }

    private void getAllCustomersTable() {
        try {
            List<Customer> customers = Customer.getAllCustomers();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Name");
            model.addColumn("Email");
            model.addColumn("Phone");
            for (Customer customer : customers) {
                model.addRow(new Object[]{customer.getId(), customer.getName(), customer.getEmail(), customer.getPhone()});
            }
            customersTable.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error refreshing customers table:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Initialize database connection
        DataBaseConn.getConnection();

        // Create and show GUI
        SwingUtilities.invokeLater(getAllCustGUI::new);

    }
}
