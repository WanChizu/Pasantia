/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Proveedor;

import Controladores.MyConnection;
import entidades.Proveedor;
import errores.ErroresProveedores;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lizor
 */
public class VerProveedor {

    /**
     * @param args the command line arguments
     */
    public static Proveedor verProveedor(int codigoProveedor, ArrayList<errores.ErrorGeneral> errores) {
    Connection conexion = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conexion = MyConnection.getConnection();
        String query = "SELECT * FROM Proveedor WHERE proveedor_id = ?";
        ps = conexion.prepareStatement(query);
        ps.setInt(1, codigoProveedor);

        rs = ps.executeQuery();

        if (rs.next()) {
            int proveedorId = rs.getInt("proveedor_id");
            String nombre = rs.getString("nombre");
            String telefono = rs.getString("telefono");
            boolean estaActivo = rs.getBoolean("esta_activo");
            BigDecimal limiteCredito = rs.getBigDecimal("limite_credito");

            Proveedor proveedor = new Proveedor(proveedorId, nombre, telefono, estaActivo, limiteCredito);

            return proveedor;
        } else {
            errores.add(ErroresProveedores.PROVEEDOR_NO_ENCONTRADO);
        }
    } catch (SQLException ex) {
        errores.add(ErroresProveedores.ERROR_INESPERADO);
        ex.printStackTrace();
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            errores.add(ErroresProveedores.ERROR_INESPERADO);
            ex.printStackTrace();
        }
    }

    return null;
}

    
    
   public static void main(String[] args) {
    ArrayList<errores.ErrorGeneral> errores = new ArrayList<>();
    int codigoProveedor = 2;

    Proveedor proveedorEncontrado = verProveedor(codigoProveedor, errores);
    if (errores.isEmpty()) {
        System.out.println("Proveedor encontrado:");
        System.out.println("Código: " + proveedorEncontrado.getProveedorId());
        System.out.println("Nombre: " + proveedorEncontrado.getNombre());
        System.out.println("Teléfono: " + proveedorEncontrado.getTelefono());
        System.out.println("Activo: " + proveedorEncontrado.isEstaActivo());
        System.out.println("Límite de crédito: " + proveedorEncontrado.getLimiteCredito());
        
    } else {
        ArrayList<errores.ErrorGeneral> erroresTemporales = new ArrayList<>();
        
        for (errores.ErrorGeneral error : errores) {
            erroresTemporales.add(error);
        }
        
        errores.addAll(erroresTemporales);
        
        for (errores.ErrorGeneral error : errores) {
            System.out.println("Error: " + error.getMensajeError());
            errores.add(ErroresProveedores.ERROR_INESPERADO);
            
        }
    }
}


}
