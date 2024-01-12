/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import entidades.Proveedor;
import errores.ErrorGeneral;
import errores.ErroresProveedores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lizor
 */
public class Actualizar {
 
    /**
     * @param args the command line arguments
     */
    
    private static List<ErrorGeneral> validarProveedor(Proveedor proveedor) throws SQLException {
    List<ErrorGeneral> errores = new ArrayList<>();

    if (proveedor.getNombre().isEmpty()) {
        errores.add(ErroresProveedores.NOMBRE_VACIO);
        }

    if (proveedor.getNombre().length() > 50) {
        errores.add(ErroresProveedores.NOMBRE_MUY_LARGO);
        }

    if (proveedor.getNombre().length() < 5) {
        errores.add(ErroresProveedores.NOMBRE_MUY_CORTO);
        }


    if (proveedor.getTelefono().length() > 12) {
        errores.add(ErroresProveedores.TELEFONO_MUY_LARGO);
    }

    if (proveedor.getTelefono().length() < 12) {
        errores.add(ErroresProveedores.TELEFONO_MUY_CORTO);
    }

    if (proveedor.getTelefono().isEmpty()) {
        errores.add(ErroresProveedores.TELEFONO_VACIO);
    }
    

    return errores;
}
    

 
    public static void actProveedor(Proveedor proveedorAActualizar, ArrayList<errores.ErrorGeneral> errores) throws SQLException {
        conexion con = new conexion();
        Connection conexion = con.conectar();
        String query = "UPDATE Proveedor SET nombre = ?, telefono = ?, esta_activo = ?, limite_credito = ? WHERE proveedor_id = ?";
        PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        try {

            ps = conexion.prepareStatement(query);
            ps.setString(1, proveedorAActualizar.getNombre());
            ps.setString(2, proveedorAActualizar.getTelefono());
            ps.setBoolean(3, proveedorAActualizar.isEstaActivo());
            ps.setBigDecimal(4, proveedorAActualizar.getLimiteCredito());
            ps.setInt(5, proveedorAActualizar.getProveedorId());
            ps.executeUpdate();
            
            
            } catch (SQLException ex) {
                errores.add(ErroresProveedores.ERROR_INESPERADO);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    
                    errores.add(ErroresProveedores.ERROR_INESPERADO);
                }
            }
        }
    }
    
   
    
 
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Proveedor actualizarProveedor = new Proveedor(1, "Lavanderia Rosario", "849-986-0987", true, new java.math.BigDecimal(500));
        List<ErrorGeneral> errores = validarProveedor(actualizarProveedor);
        
        if (errores.isEmpty()) {
        try {
        actProveedor(actualizarProveedor, (ArrayList<ErrorGeneral>) errores);
          System.out.println("Proveedor actualizado correctamente.");
        } catch (SQLException ex) {
           errores.add(ErroresProveedores.ERROR_INESPERADO);
        }
    } else {
        for (ErrorGeneral error : errores) {
            System.out.println("Error de validación: " + error.getMensajeError());
            System.out.println(error.getMensajeSolucion());
        }
    }
}    }
    
