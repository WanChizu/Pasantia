package Controladores;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexion {
    
    public static Connection getConnection;
    
    private static final String drive="com.mysql.jdbc.Driver";
    private static final String user="root";
    private static final String pass="irisalbania13";
    private static final String url="jdbc:mysql://localhost:3306/sistema_proveedor";
    
    public Connection conectar(){
    getConnection = null;
    try{
    getConnection = (Connection) DriverManager.getConnection(url, user, pass);
   
    }
    catch(SQLException e){
    JOptionPane.showMessageDialog(null, "Error " + e.toString());
    }
        return getConnection;
    
}
}
