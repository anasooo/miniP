
package minip;

import java.sql.*;


public class DataBaseConn {
  private static Connection conn = null;
    
  public static Connection getConnection() {
    if (conn == null) {
      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
         String protocole = "jdbc:mysql:";
	        String ip = "localhost";
	        String port = "3306";
	        String nomBase = "ph00";
	        String url = protocole + "//" + ip + ":" + port + "/" + nomBase;
	        String user = "root";
	        String password = "0000";
        conn = DriverManager.getConnection(url, user,password);
      } catch(ClassNotFoundException | SQLException e){
           System.out.println(e);
       }
  }
    return conn;
  }
}