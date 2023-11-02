/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import entidades.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Lizor
 */
public class Agregar {
    /**
     * @param args the command line arguments
     */ 
    
    
    private static boolean revisarProveedor(Proveedor revisarNombre) throws SQLException{
        Connection conexion = MyConnection.getConnection();
     if (revisarNombre.getNombre().isEmpty()) {
        throw new SQLException("El nombre del proveedor no puede estar vacío.");
    }

    if (revisarNombre.getNombre().length() > 50) {
        throw new SQLException("El nombre del proveedor supera la longitud máxima permitida (50 caracteres).");
    }
    
    if (revisarNombre.getNombre().length() < 5) {
         throw new SQLException("El nombre del proveedor no supera la longitud requerida (debe ser mayor de 5 caracteres).");
    }
    
    if (campoExistente(conexion, revisarNombre.getNombre(), "nombre")) {
         throw new SQLException("El nombre del proveedor ya existe en la base de datos.");
    }
        
        return false;
          
    }
    
    private static boolean revisarTelefono(Proveedor revisarTelefono) throws SQLException{
        Connection conexion = MyConnection.getConnection();
    if (revisarTelefono.getTelefono().length() > 12) {
             throw new SQLException("El número de teléfono supera la longitud máxima permitida (12 caracteres).");
        }
        
        if (revisarTelefono.getTelefono().length() < 12) {
             throw new SQLException("El número de teléfono no supera la longitud permitida (12 caracteres).");
        }

        if (revisarTelefono.getTelefono().isEmpty()) {
             throw new SQLException(null,"El número de teléfono no puede estar vacío.");
        }
        
        if (campoExistente(conexion, revisarTelefono.getTelefono(), "telefono")) {
             throw new SQLException("El número de teléfono ya está registrado en la base de datos.");
        }
        return false;
    }
    
    private static boolean campoExistente(Connection conexion, String valor, String campo) throws SQLException {
    String query = "SELECT COUNT(*) FROM Proveedor WHERE " + campo + " = ?";
    PreparedStatement ps = conexion.prepareStatement(query);
    ps.setString(1, valor);

    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
        int count = rs.getInt(1);
        return count > 0;
    }

    return false;
}

    
/*private static boolean nombreExistente(String Nombre, Connection conexion) throws SQLException {
    String query = "SELECT COUNT(*) FROM Proveedor WHERE nombre = ?";
    PreparedStatement ps = conexion.prepareStatement(query);
    ps.setString(1, Nombre);

    ResultSet rs = ps.executeQuery();
    rs.next();
    int count = rs.getInt(1);

    return count > 0;
}

private static boolean telefonoExistente(Connection conexion, String telefono) throws SQLException {
    String query = "SELECT COUNT(*) FROM Proveedor WHERE telefono = ?";
    PreparedStatement ps = conexion.prepareStatement(query);
    ps.setString(1, telefono);
    
    ResultSet rs = ps.executeQuery();
    rs.next();
    int count = rs.getInt(1);

    return count > 0;
}*/

   

 public static int insertarProveedor(Proveedor proveedorAGuardar) throws SQLException {    
    Connection conexion = MyConnection.getConnection();
    String query = "INSERT INTO Proveedor (nombre, telefono, esta_activo, limite_credito) VALUES (?, ?, ?, ?)";
    PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    int idProveedorInsertado = -1;

    try {

        ps.setString(1, proveedorAGuardar.getNombre());
        ps.setString(2, proveedorAGuardar.getTelefono());
        ps.setBoolean(3, proveedorAGuardar.isEstaActivo());
        ps.setDouble(4, proveedorAGuardar.getLimiteCredito());
        int filasAfectadas = ps.executeUpdate();

        if (filasAfectadas > 0) {
            // Obtener el ID del proveedor insertado (si es aplicable)
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                idProveedorInsertado = generatedKeys.getInt(1);
            }
            
        }
    } catch (SQLException ex) {
         throw new SQLException("Error al insertar proveedor: " + ex.getMessage());
    } finally {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                throw new SQLException("Error al cerrar el PreparedStatement: " + ex.getMessage());
            }
        }
    }

    return idProveedorInsertado;
}


 
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Proveedor nuevoProveedor = new Proveedor(0, "OrteGAS", "849-234-1923", false,0);
        revisarProveedor(nuevoProveedor);
        revisarTelefono(nuevoProveedor);
        insertarProveedor(nuevoProveedor);
        
    }

    
}
