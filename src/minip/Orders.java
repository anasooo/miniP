
package minip;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class Orders {
    public void addOrder() throws SQLException{
        Scanner s=new Scanner(System.in);
         System.out.println("Ajout d'un nouveau order : ");
         System.out.print("   >  Entrer customer id :   ");
         int cusID=s.nextInt();
         System.out.print("   >  Entrer drug id :   ");
         int drugID=s.nextInt();
         PreparedStatement stmt ;
         stmt = DataBaseConn.getConnection().prepareStatement("INSERT INTO orders( customer_id , drug_id) VALUES (?,?)");
         stmt.setInt(1, cusID);
         stmt.setInt(2,drugID);
         stmt.executeUpdate();
         System.out.println("\n\n Done");
    }
    
    public void deleteOrder() throws SQLException{
        System.out.print("\n   - Entrer > ID order to delete   :   "); 
         Scanner s=new Scanner(System.in);
         int id =s.nextInt(); 
         PreparedStatement stmt ;
         stmt = DataBaseConn.getConnection().prepareStatement("DELETE FROM orders WHERE id = ?");

            stmt.setInt(1,id);
            stmt.executeUpdate(); 
            System.out.println(" Suppression ...");
           
           System.out.println("Done");

    
    }
}
