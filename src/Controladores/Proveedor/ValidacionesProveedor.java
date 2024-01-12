/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Proveedor;

import Controladores.MyConnection;
import entidades.Proveedor;
import errores.ErrorGeneral;
import errores.ErroresCategorias;
import errores.ErroresProveedores;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lizor
 */
public class ValidacionesProveedor {

    /**
     * @param args the command line arguments
     */
   public static List<ErrorGeneral> validarProveedor(Proveedor proveedor) throws SQLException {
        Connection conexion = MyConnection.getConnection();
        List<ErrorGeneral> errores = new ArrayList<>();
        
        if(validacionesGenericasDeProveedores(proveedor, errores)){
            
        }
       
        if (proveedorExistente(conexion, proveedor.getNombre(), "nombre")) {
            errores.add(ErroresProveedores.NOMBRE_EXISTENTE);
        }

        if (proveedorExistente(conexion, proveedor.getTelefono(), "telefono")) {
            errores.add(ErroresProveedores.TELEFONO_EXISTENTE);
        }
        
        if (proveedor.getProveedorId() < 0) {
            errores.add(ErroresCategorias.ID_NEGATIVO);
        }
        
        return errores;
    }
   
    public static boolean validacionesGenericasDeProveedores(Proveedor proveedor, List<ErrorGeneral> errores) {
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
        
        if (proveedor.getLimiteCredito().compareTo(BigDecimal.ZERO) < 0) {
            errores.add(ErroresProveedores.LIMITE_CREDITO_NEGATIVO);

        }
        
        if (proveedor.getProveedorId() < 0) {
            errores.add(ErroresCategorias.ID_NEGATIVO);
        }
         
        return errores.isEmpty();

    }

    private static boolean proveedorExistente(Connection conexion, String valor, String campo) throws SQLException {
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
 
    public static void main(String[] args) {
        // TODO code application logic here
    }
}