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
public class Actualizar {
 
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
        return false;
    }
    
    
    public static void actProveedor(Proveedor proveedorAActualizar) throws SQLException {
        Connection conexion = MyConnection.getConnection();
        String query = "UPDATE Proveedor SET telefono = ?, esta_activo = ?, limite_credito = ? WHERE proveedor_id = ?";
        PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        try {

            ps = conexion.prepareStatement(query);
            ps.setString(1, proveedorAActualizar.getTelefono());
            ps.setBoolean(2, proveedorAActualizar.isEstaActivo());
            ps.setDouble(3, proveedorAActualizar.getLimiteCredito());
            ps.setInt(4, proveedorAActualizar.getProveedorId());
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
        Proveedor actualizarProveedor = new Proveedor(2, "Plomeria SA", "849-938-0911", false,0);
        actProveedor(actualizarProveedor);
    }
    
}
