/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author A19B59953
 */
public class MyConnection {
    public static Connection getConnection(){
    Connection conexion = null;
    
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    //conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pasantia","root","irisalbanaia13");
    conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pasantia","root","020512");
    } catch (ClassNotFoundException | SQLException ex){
        System.out.println(ex.getMessage());
    }
    return conexion;
    
    }
    
}
