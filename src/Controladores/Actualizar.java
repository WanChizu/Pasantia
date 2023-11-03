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
    
    private static boolean validarProveedor(Proveedor proveedor) throws SQLException {

    if (proveedor.getTelefono().length() > 12) {
        throw new SQLException("El número de teléfono supera la longitud máxima permitida (12 caracteres).");
    }

    if (proveedor.getTelefono().length() < 12) {
        throw new SQLException("El número de teléfono no cumple con la longitud requerida (debe ser de 12 caracteres).");
    }

    if (proveedor.getTelefono().isEmpty()) {
        throw new SQLException("El número de teléfono no puede estar vacío.");
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
            ps.setBigDecimal(3, proveedorAActualizar.getLimiteCredito());
            ps.setInt(4, proveedorAActualizar.getProveedorId());
            ps.executeUpdate();
            
            
            } catch (SQLException ex) {

            throw new SQLException("Error al actualizar proveedor: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    
                    throw new SQLException("Error al cerrar el PreparedStatement: " + ex.getMessage());
                }
            }
        }
    }
    
   
    
 
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Proveedor actualizarProveedor = new Proveedor(1, "Lavanderia Rosario", "849-853-0987", true, new java.math.BigDecimal(500));
        validarProveedor(actualizarProveedor);
        actProveedor(actualizarProveedor);
    }
    
}
