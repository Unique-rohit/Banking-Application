
package bank.managment.system1;

import java.sql.*;


public class Conn {
    
    Connection c;
    Statement s;
   public Conn(){
       try{
           c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagmentsystem","root","Rohit@2202");
           s=c.createStatement();
       }catch(Exception e) {
           System.out.println(e);
       }
   }
    
}
