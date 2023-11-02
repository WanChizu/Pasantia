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

/**
 *
 * @author Lizor
 */
public class Agregar {
    /**
     * @param args the command line arguments
     */
 //private static Connection conexion; 

 public static int insertarProveedor(Proveedor proveedorAGuardar) throws SQLException {    
    Connection conexion = MyConnection.getConnection();
    String query = "INSERT INTO Proveedor (nombre, telefono, esta_activo, limite_credito) VALUES (?, ?, ?, ?)";
    PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    int idProveedorInsertado = -1;

    try {
        if (proveedorAGuardar.getNombre().isEmpty()) {
            throw new SQLException("El nombre del proveedor no puede estar vacío.");
        }

        if (proveedorAGuardar.getNombre().length() > 50) {
            throw new SQLException("El nombre del proveedor supera la longitud máxima permitida (50 caracteres).");
        }
        
        if (proveedorAGuardar.getNombre().length() < 5) {
            throw new SQLException("El nombre del proveedor no supera la longitud requerida (debe ser mayor de 5 caracteres).");
        }

        if (proveedorAGuardar.getTelefono().length() > 12) {
            throw new SQLException("El número de teléfono supera la longitud máxima permitida (12 caracteres).");
        }
        
        if (proveedorAGuardar.getTelefono().length() < 12) {
            throw new SQLException("El número de teléfono no supera la longitud permitida (12 caracteres).");
        }

        if (proveedorAGuardar.getTelefono().isEmpty()) {
            throw new SQLException("El número de teléfono no puede estar vacío.");
        }
        
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
        Proveedor nuevoProveedor = new Proveedor(0, "Ferreteria Domingo", "849-532-0191", false,0);
        
        insertarProveedor(nuevoProveedor);
    }

    
}
