
package minip;

import java.util.*;
import java.sql.* ;


public class Drug {
    private int id;
    private String name;
    private int quantity;
    private double price;
    
    public Drug(){};
    public Drug(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    // DAO
    



    public static void addDrug(Drug drug) throws SQLException {
        String query = "INSERT INTO drugs (id , name, quantity, price) VALUES (? ,?, ?, ?)";
        PreparedStatement stmt ;
        stmt = DataBaseConn.getConnection().prepareStatement(query);
        stmt.setInt(1, drug.id);
        stmt.setString(2, drug.getName());
        stmt.setInt(3, drug.getQuantity());
        stmt.setDouble(4, drug.getPrice());
        stmt.executeUpdate();
        stmt.close();
    }

    public static void updateDrug(Drug drug) throws SQLException {
        String query = "UPDATE drugs SET name = ?, quantity = ?, price = ? WHERE id = ?";
        PreparedStatement stmt ;
        stmt = DataBaseConn.getConnection().prepareStatement(query);
        stmt.setString(1, drug.getName());
        stmt.setInt(2, drug.getQuantity());
        stmt.setDouble(3, drug.getPrice());
        stmt.setInt(4, drug.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public static void deleteDrug(int id) throws SQLException {
        String query = "DELETE FROM drugs WHERE id = ?";
        PreparedStatement stmt ;
        stmt = DataBaseConn.getConnection().prepareStatement(query);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public static Drug getDrugById(int id) throws SQLException {
        String query = "SELECT * FROM drugs WHERE id = ?";
        PreparedStatement stmt ;
        stmt = DataBaseConn.getConnection().prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Drug drug = null;
        if (rs.next()) {
            drug = new Drug(rs.getInt("id"), rs.getString("name"), rs.getInt("quantity"), rs.getDouble("price"));
        }
        rs.close();
        stmt.close();
        return drug;
    }

    public static List<Drug> getAllDrugs() throws SQLException {
        String query = "SELECT * FROM drugs";
        PreparedStatement stmt ;
        stmt = DataBaseConn.getConnection().prepareStatement(query);
        ResultSet rs = stmt.executeQuery(query);
        List<Drug> drugs = new ArrayList<>();
        while (rs.next()) {
            Drug drug = new Drug(rs.getInt("id"), rs.getString("name"), rs.getInt("quantity"), rs.getDouble("price"));
            drugs.add(drug);
        }
        rs.close();
        stmt.close();
        return drugs;
    }
}
