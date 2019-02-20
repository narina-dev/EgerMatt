/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Athena
 */

import Model.registerBean;
import Model.registerBean;
import static dao.userdao.rs;
import java.sql.*;
public class registerdao {
    
    static Connection currentCon = null;
    static ResultSet rs = null;
    static PreparedStatement stmt = null;
     public static registerBean register(registerBean x) throws ClassNotFoundException{
        
        
        String name = x.getName();
        String email = x.getEmail();
        String location = x.getLocation();
        String password = x.getPassword(); 
        
        
        //insert into users(name,email,location,pass) Values(?,?,?,?);          
       
    try{
            //connect to database
            
            currentCon = databaseConnection.getConnect();            
          
            stmt = currentCon.prepareStatement("insert into users(name,pass,email,location) values(?,?,?,?)");//create statement.
            
           
            stmt.setString(1, name);
            stmt.setString(2, password);
            stmt.setString(3,email);
            stmt.setString(4, location);
 
            
            stmt.executeUpdate();
            
           

            
            stmt.close();//close statement.
            
            //currentCon.close();//close connection
            System.out.print("SUCCESFULL");
          //  return "SUCCESFULL";
                  
    }
    catch(SQLException e){
            e.printStackTrace();
             
        }

      return x;
  }
   
}
