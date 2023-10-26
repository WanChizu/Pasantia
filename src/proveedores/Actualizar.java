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
public class Actualizar {
 
    private static Connection conexion; 
    /**
     * @param args the command line arguments
     */
 
    public static void actProveedor(Proveedor proveedorAActualizar) throws SQLException {
        String query = "UPDATE Proveedor SET nombre = ?, telefono = ?, esta_activo = ?, limite_credito = ? WHERE proveedor_id = ?";
        PreparedStatement ps = null;

        try {
            ps = conexion.prepareStatement(query);
            ps.setString(1, proveedorAActualizar.getNombre());
            ps.setString(2, proveedorAActualizar.getTelefono());
            ps.setBoolean(3, proveedorAActualizar.isEstaActivo());
            ps.setDouble(4, proveedorAActualizar.getLimiteCredito());
            ps.setInt(5, proveedorAActualizar.getProveedorId()); // Suponiendo que proveedorId es el ID del proveedor que deseas actualizar
            ps.executeUpdate();
            } catch (SQLException ex) {
            // Manejo de la excepción
            throw new SQLException("Error al actualizar proveedor: " + ex.getMessage());
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
        Proveedor actualizarProveedor = new Proveedor(0,"","", true, 0);
        actProveedor(actualizarProveedor);
    }
    
}
