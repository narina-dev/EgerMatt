/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.loginBean;
import dao.databaseConnection;
import java.sql.*;

public class userdao {
    
    static Connection currentCon = null;
    static ResultSet rs = null;
    static PreparedStatement stmt = null;
    
    public static loginBean login(loginBean x) throws ClassNotFoundException{
        
        
        String name = x.getname();
        String password = x.getPassword();  
                  
       
        String query = "SELECT * FROM users WHERE name=? ";
        //insert into users (name,email,pass,location) Values (?,?,?)
         
        
        try{
            //connect to database
            
            currentCon = databaseConnection.getConnect();            
          
            stmt = currentCon.prepareStatement(query);
           
            stmt.setString(1, name);
                       
            rs = stmt.executeQuery();
            //int i = executeUpdate
            //if i == 1 continue else error
            
            
            boolean exist = rs.next();
            
            String dbname = null;
            String dbpass = null;
            //if there are no users in the database
            if(!exist){
                x.setValid(false);
                
            }else{             
                
                    dbname= rs.getString("name");
                    dbpass = rs.getString("pass");
                   
                    if(dbpass.equals(password) && dbname.equals(name)){
                         x.setValid(true);
                         
                    }else{
                         x.setValid(false);
                    }
                    
               
            }
        }
        catch(SQLException ex){
            System.out.println("Login failed there are some errors: "+ ex);
             x.setValid(false);
            
        }
   
        
       // some more exceptions
        finally{
         if(rs!=null){
             try{
                 rs.close();
             }catch(Exception ex2){}
                 rs = null;
                        
        }
        if(stmt != null ){
            try{
                stmt.close();
            }catch(Exception ex2){}
            stmt = null;
        }
        
        if (currentCon != null ){
              try{
                currentCon.close();
            }catch(Exception ex3){}
            currentCon = null;
        }
        }
         
        return x;
    }
    
    
    
}
