
package emolyeemanagementsystem;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");//Driver class
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem","root","Aditi@2312");
            s = c.createStatement();
            
    
        }catch (Exception e){
            e.printStackTrace();
        }
    }
   
    
}
//5-steps to connect jdbc
//1-Resgister Driver class
        //2-exceutes mysql queries 
        //3-creating statement
        //4-execute query
        //5-closing the connections
    

