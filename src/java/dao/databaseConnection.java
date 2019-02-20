/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class databaseConnection {
    
     static Connection con;
   
    
    public static Connection getConnect() {
        
      
        
         try {
             Class.forName("com.mysql.jdbc.Driver");
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(databaseConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        String  url = "jdbc:mysql://localhost:3306/ecommerce";
        
        try{
            con = DriverManager.getConnection(url, "ecommerce", "ecommerce");
            System.out.println("Database connection successful");
            
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Database connection fail");
        }
        
        return con;
    }
    
}
