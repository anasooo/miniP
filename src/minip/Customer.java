

// our code:
package minip;
import java.sql.*;
import java.util.*;



public class Customer {
    private int id;
    private String name;
    private String email;
    private int phone;

    public Customer(){};
    public Customer(int id, String name, String email, int phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    
    public static void addCustomer(Customer cust) throws SQLException {
        String query = "INSERT INTO customers (id , name, email, phone) VALUES (? ,?, ?, ?)";
        PreparedStatement stmt ;
        stmt = DataBaseConn.getConnection().prepareStatement(query);
        stmt.setInt(1, cust.getId());
        stmt.setString(2, cust.getName());
        stmt.setString(3, cust.getEmail());
        stmt.setInt(4, cust.getPhone());
        stmt.executeUpdate();
        stmt.close();
    }

    public static void updateCustomer(Customer cust) throws SQLException {
        String query = "UPDATE customers SET name = ?, email = ?, phone = ? WHERE id = ?";
        PreparedStatement stmt ;
        stmt = DataBaseConn.getConnection().prepareStatement(query);
        stmt.setString(1, cust.getName());
        stmt.setString(2, cust.getEmail());
        stmt.setInt(3, cust.getPhone());
        stmt.setInt(4, cust.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public static void deleteCustomer(int id) throws SQLException {
        String query = "DELETE FROM customers WHERE id = ?";
        PreparedStatement stmt ;
        stmt = DataBaseConn.getConnection().prepareStatement(query);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public static Customer getCustomerById(int id) throws SQLException {
        String query = "SELECT * FROM customers WHERE id = ?";
        PreparedStatement stmt ;
        stmt = DataBaseConn.getConnection().prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Customer cust = null;
        if (rs.next()) {
             cust = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getInt("phone"));
        }
        rs.close();
        stmt.close();
        return cust;
    }

    public static List<Customer> getAllCustomers() throws SQLException {
        String query = "SELECT * FROM customers";
        PreparedStatement stmt ;
        stmt = DataBaseConn.getConnection().prepareStatement(query);
        ResultSet rs = stmt.executeQuery(query);
        List<Customer> custs = new ArrayList<>();
        while (rs.next()) {
            Customer cust = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getInt("phone"));
            custs.add(cust);
        }
        rs.close();
        stmt.close();
        return custs;
    }
}

//test code: 
