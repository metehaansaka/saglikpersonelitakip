/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Metehan
 */
public class DBConnection {
     public Connection connect(){
          Connection con=null;
          try{
           Class.forName("com.mysql.jdbc.Driver").newInstance();
           con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/saglikpersonelitakip","root","1233210011");
        
           
          } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
              System.out.println(ex.getMessage());
          }
          return con;
      }
}
