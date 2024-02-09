/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Factura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
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
            proveedores.put(id, nombre); // Aquí intercambiamos el ID y el nombre
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
            categorias.put(id, nombre); // Aquí intercambiamos el ID y el nombre
        }
    }
    return categorias;
}

}
