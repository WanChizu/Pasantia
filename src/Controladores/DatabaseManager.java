/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author A19B59953
 */
public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_proveedor";
    private static final String USER = "root";
    private static final String PASSWORD = "irisalbania13";

 public static Map<Integer, String> obtenerProveedores() throws SQLException {
    Map<Integer, String> proveedores = new HashMap<>();
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement stmt = conn.prepareStatement("SELECT proveedor_id, nombre FROM proveedor");
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            int id = rs.getInt("proveedor_id");
            String nombre = rs.getString("nombre");
            proveedores.put(id, nombre); 
        }
    }
    return proveedores;
}

public static Map<Integer, String> obtenerCategorias() throws SQLException {
    Map<Integer, String> categorias = new HashMap<>();
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement stmt = conn.prepareStatement("SELECT categoria_id, nombre FROM categoria");
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            int id = rs.getInt("categoria_id");
            String nombre = rs.getString("nombre");
            categorias.put(id, nombre); 
        }
    }
    return categorias;
}


public static Map<Integer, String> obtenerAreas() throws SQLException {
    Map<Integer, String> areas = new HashMap<>();
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement stmt = conn.prepareStatement("SELECT id_area, nombre FROM area");
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            int id = rs.getInt("id_area");
            String nombre = rs.getString("nombre");
            areas.put(id, nombre); 
        }
    }
    return areas;
}
public static Map<Integer, String> obtenerFormaPagos() throws SQLException {
    Map<Integer, String> fp = new HashMap<>();
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement stmt = conn.prepareStatement("SELECT id_forma_pago, nombre_forma FROM forma_pago");
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            int id = rs.getInt("id_forma_pago");
            String nombre = rs.getString("nombre_forma");
            fp.put(id, nombre); 
        }
    }
    return fp;
}

public static Map<Integer, String> obtenerIdsYComentariosFactura() throws SQLException {
    Map<Integer, String> idsYComentarios = new HashMap<>();
    
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement stmt = conn.prepareStatement("SELECT id_factura, comentario FROM factura");
         ResultSet rs = stmt.executeQuery()) {
        
        while (rs.next()) {
            int id = rs.getInt("id_factura");
            String comentario = rs.getString("comentario");
            idsYComentarios.put(id, comentario);
        }
    }
    
    return idsYComentarios;
}

public static Map<Integer, String> obtenerEstadoPago() throws SQLException {
    Map<Integer, String> idEstadoPago = new HashMap<>();
    
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement stmt = conn.prepareStatement("SELECT id_pago, estado_pago FROM pagos");
         ResultSet rs = stmt.executeQuery()) {
        
        while (rs.next()) {
            int id = rs.getInt("id_pago");
            int estado = rs.getInt("estado_pago");
            String estadoStr = (estado == 1) ? "Activo" : "Inactivo";
            idEstadoPago.put(id, estadoStr);
        }
    }
    
    return idEstadoPago;
}




}
