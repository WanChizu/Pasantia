/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author A19B59953
 */
public class MyConnection {
    public static Connection getConnection(){
    //para conectar a la base de datos
     Connection con = null;
    
     
     
     try {
     
      Class.forName("com.mysql.cj.jdbc.Driver");
      
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_proveedor","root","irisalbania13");
<<<<<<< HEAD
//      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pasantia","root","020512");
=======
      
>>>>>>> e359a932c1b4449fb8bcc1870c507e78795ab3f7
     } catch (ClassNotFoundException | SQLException ex){
     
         System.out.println(ex.getMessage());
     
     }
      return con;
}
    
    
}