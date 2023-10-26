/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proveedores;

import entidades.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Lizor
 */
public class Agregar {
    /**
     * @param args the command line arguments
     */
 private static Connection conexion; 
 
 public static void insertarProveedor(Proveedor proveedorAGuardar) throws SQLException {
        String query = "INSERT INTO Proveedor (nombre, telefono, esta_activo, limite_credito) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = null;

        try {
            ps = conexion.prepareStatement(query);
            ps.setString(1, proveedorAGuardar.getNombre());
            ps.setString(2, proveedorAGuardar.getTelefono());
            ps.setBoolean(3, proveedorAGuardar.isEstaActivo());
            ps.setDouble(4, proveedorAGuardar.getLimiteCredito());
            ps.executeUpdate();
        } catch (SQLException ex) {
            // Manejo de la excepción
            throw new SQLException("Error al insertar proveedor: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    // Manejo de la excepción al cerrar el PreparedStatement
                    throw new SQLException("Error al cerrar el PreparedStatement: " + ex.getMessage());
                }
            }
        }
    }
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Proveedor nuevoProveedor = new Proveedor(0, "", "", true,0);
        
        insertarProveedor(nuevoProveedor);
    }

    
}
