/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import entidades.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lizor
 */
public class Actualizar {
 
    /**
     * @param args the command line arguments
     */
 
    public static void actProveedor(Proveedor proveedorAActualizar) throws SQLException {
        Connection conexion = MyConnection.getConnection();
        String query = "UPDATE Proveedor SET nombre = ?, telefono = ?, esta_activo = ?, limite_credito = ? WHERE proveedor_id = ?";
        PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        try {
            if (proveedorAActualizar.getNombre().isEmpty()) {
            throw new SQLException("El nombre del proveedor no puede estar vacío.");
        }

        if (proveedorAActualizar.getNombre().length() > 100) {
            throw new SQLException("El nombre del proveedor supera la longitud máxima permitida (100 caracteres).");
        }

        if (proveedorAActualizar.getTelefono().length() > 12) {
            throw new SQLException("El número de teléfono supera la longitud máxima permitida (12 caracteres).");
        }

        if (proveedorAActualizar.getTelefono().isEmpty()) {
            throw new SQLException("El número de teléfono no puede estar vacío.");
        }

            
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
        Proveedor actualizarProveedor = new Proveedor(1, "Ferreteria Domingo", "849-532-0191", true,40000);
        actProveedor(actualizarProveedor);
    }
    
}
