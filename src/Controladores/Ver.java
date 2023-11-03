/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import entidades.Proveedor;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lizor
 */
public class Ver {

    /**
     * @param args the command line arguments
     */
    public static Proveedor verProveedor(int codigoProveedor) throws SQLException {
        Connection conexion = MyConnection.getConnection();
        String query = "SELECT * FROM Proveedor WHERE proveedor_id = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setInt(1, codigoProveedor);

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
            throw new SQLException("Proveedor con código " + codigoProveedor + " no encontrado.");
        }
    }

    public static void main(String[] args) throws SQLException {
        // TODO code application logic here

        int codigoProveedor = 100;
        

        Proveedor proveedorEncontrado = verProveedor(codigoProveedor);
        System.out.println("Proveedor encontrado:");
        System.out.println("Código: " + proveedorEncontrado.getProveedorId());
        System.out.println("Nombre: " + proveedorEncontrado.getNombre());
        System.out.println("Teléfono: " + proveedorEncontrado.getTelefono());
        System.out.println("Activo: " + proveedorEncontrado.isEstaActivo());
        System.out.println("Límite de crédito: " + proveedorEncontrado.getLimiteCredito());

    }

}
