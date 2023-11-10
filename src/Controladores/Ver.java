/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

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
public class Ver {

    /**
     * @param args the command line arguments
     */
    public static Proveedor verProveedor(int codigoProveedor, String nombreProveedor, boolean activo, BigDecimal credito, ArrayList<errores.ErrorGeneral> errores) throws SQLException {
        Connection conexion = MyConnection.getConnection();
        String query = "SELECT * FROM Proveedor WHERE proveedor_id = ? AND nombre = ? AND esta_activo = ? AND limite_credito = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setInt(1, codigoProveedor);
        ps.setString(2, nombreProveedor);
        ps.setBoolean(3, activo);
        ps.setBigDecimal(4, credito);

        ResultSet rs = ps.executeQuery();

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
        return null;
       
    }

    
    
   public static void main(String[] args) {
    ArrayList<errores.ErrorGeneral> errores = new ArrayList<>();
    int codigoProveedor = 1;
    String nombreProveedor = null;
    boolean activo = true; // Puedes cambiar esto según tus necesidades
    BigDecimal credito = null;

    try {
        Proveedor proveedorEncontrado = verProveedor(codigoProveedor, nombreProveedor, activo, credito, errores);

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
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}


}
