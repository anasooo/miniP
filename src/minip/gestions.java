package minip;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;



public class gestions {
    public gestions() throws SQLException{
      
      
      Scanner scanner =  new Scanner(System.in);
      
      while(true){
          System.out.println("1 - GESTION CUSTOMER");
          System.out.println("2 - GESTION DRUGS");
          System.out.println("3 - GESTION ORDERS");
          System.out.println("4 - QUITTER");

          int choice = scanner.nextInt();
          switch(choice){
              case 1 :
                  while(true){
                         System.out.println("QUE VOULEZ VOUS FAIRE");
                         System.out.println("1 AJOUTER UN CUSTOMER");
                         System.out.println("2 SUPPRIMER UN CUSTOMER");
                         System.out.println("3 CHERCHE UN CUSTOMER");
                         System.out.println("4 Mis a jour UN CUSTOMER");
                         System.out.println("5 GET ALL CUSTOMERS");
                         System.out.println("6 GO BACK");
          
                         int choix = scanner.nextInt();
          
                         switch(choix){
                            case 1 -> {
                                System.out.println("ID");
                                int id = scanner.nextInt();
                                System.out.println("PHONE");
                                int d = scanner.nextInt();
                                System.out.println("NAME");
                                scanner.nextLine();
                                String x = scanner.nextLine();
                                System.out.println("EMAIL");
                                scanner.nextLine();
                                String n = scanner.nextLine();
                                Customer cust = new Customer(id , x , n , d);
                                Customer.addCustomer(cust);
                                
                  }
                            case 2 -> {
                                System.out.print("id a supprimer :");
                                int idD = scanner.nextInt();
                                Customer.deleteCustomer(idD);
                  }
                            case 3 -> {
                                System.out.print("ID a rechercher :");
                                int idR = scanner.nextInt();
                                Customer cs = new Customer();
                                cs = Customer.getCustomerById(idR);
                                System.out.println("id :" + cs.getId() +"  name :"+ cs.getName()+"   email :" + cs.getEmail()+"   phone : "+cs.getPhone()+"\n");
                  }
                            case 4 -> {
                                System.out.println("ID");
                                int id1 = scanner.nextInt();
                                System.out.println("PHONE");
                                int d1 = scanner.nextInt();
                                System.out.println("NAME");
                                scanner.nextLine();
                                String x1 = scanner.nextLine();
                                System.out.println("EMAIL");
                                scanner.nextLine();
                                String n1 = scanner.nextLine();
                                Customer cust1 = new Customer(id1 , x1 , n1 , d1);
                                Customer.updateCustomer(cust1);
                  }
                            case 5 -> {
                                List<Customer> myList = Customer.getAllCustomers();
                                for (Customer c : myList) {
                                    System.out.println("id :" + c.getId() +"  name :"+ c.getName()+"   email :" + c.getEmail()+"   phone : "+c.getPhone()+"\n");
                                }
                  }
                            case 6 -> { gestions ges = new gestions();}
                            default -> System.out.println("choix invalide");
                            }
                             
      }
              case 2 :
                  while(true){
                         System.out.println("QUE VOULEZ VOUS FAIRE");
                         System.out.println("1 AJOUTER UN DRUG");
                         System.out.println("2 SUPPRIMER UN DRUG");
                         System.out.println("3 CHERCHE UN DRUG");
                         System.out.println("4 Mis a jour UN DRUG");
                         System.out.println("5 GET ALL DRUGS");
                         System.out.println("6 GO BACK");
          
                         int choix = scanner.nextInt();
          
                         switch(choix){
                            case 1 -> {
                                System.out.println("ID");
                                int id = scanner.nextInt();
                                System.out.println("quantity");
                                int d = scanner.nextInt();
                                System.out.println("price");
                                double x = scanner.nextDouble();
                                System.out.println("name");
                                scanner.nextLine();
                                String n = scanner.nextLine();
                                Drug drug = new Drug(id , n , d , x);
                                Drug.addDrug(drug);
                  }
                            case 2 -> {
                                System.out.print("id a supprimer :");
                                int idD = scanner.nextInt();
                                Drug.deleteDrug(idD);
                  }
                            case 3 -> {
                                System.out.print("ID a rechercher :");
                                int idR = scanner.nextInt();
                                Drug dr = new Drug();
                                dr = Drug.getDrugById(idR);
                                System.out.println("id :" + dr.getId() +"  name :"+ dr.getName()+"   price :" + dr.getPrice()+"   quantite : "+dr.getQuantity()+"\n");
                  }
                            case 4 -> {
                                System.out.println("Update drug ");
                                System.out.println("ID");
                                int idU = scanner.nextInt();
                                System.out.println("quantity");
                                int dU = scanner.nextInt();
                                System.out.println("price");
                                double xU = scanner.nextDouble();
                                System.out.println("name");
                                scanner.nextLine();
                                String nU = scanner.nextLine();
                                Drug drugU = new Drug(idU , nU, dU, xU);
                                Drug.updateDrug(drugU);
                  }
                            case 5 -> {
                                List<Drug> myList = Drug.getAllDrugs();
                                for (Drug e : myList) {
                                    System.out.println("id :" + e.getId() +"  name :"+ e.getName()+"   price :" + e.getPrice()+"   quantite : "+e.getQuantity()+"\n");
                                }
                  }
                            case 6 -> { gestions ges = new gestions();}
                            default -> System.out.println("choix invalide");
                            }
                             
                            
                            }
              case 3 : while (true){
                         System.out.println("QUE VOULEZ VOUS FAIRE");
                         System.out.println("1 AJOUTER UN ORDER");
                         System.out.println("2 SUPPRIMER UN ORDER");
                         System.out.println("3 GO BACK");
                         
                         int choix = scanner.nextInt();
                         
                         switch(choix){
                             case 1 : { Orders o = new Orders() ;
                                       o.addOrder();
                             }
                             case 2 : { Orders o = new Orders() ;
                                       o.deleteOrder();
                             }
                             case 3 : { gestions ges = new gestions();}
                         }
                  
              }
              case 4 :
                  System.exit(0);
                  break;
             
                  
              default : System.out.println("choix invalide");
              break;
          
       } 

      
      }
    }
}

//test:   
