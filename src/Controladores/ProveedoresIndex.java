/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import static Controladores.Ver.verProveedor;
import entidades.Proveedor;
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
public class ProveedoresIndex {

    /**
     * @param args the command line arguments
     */
    
public static List<Proveedor> verProveedorDos(Integer codigoProveedor, String nombreProveedor, String telefono, boolean estaActivo, BigDecimal limiteDeCredito, ArrayList<errores.ErrorGeneral> errores) throws SQLException {
    Connection conexion = MyConnection.getConnection();
    StringBuilder queryBuilder = new StringBuilder("SELECT * FROM Proveedor WHERE 1 = 1");

    if (codigoProveedor != null && codigoProveedor != 0) {
        queryBuilder.append(" AND proveedor_id = ?");
    }

    if (nombreProveedor != null && !nombreProveedor.isEmpty()) {
        queryBuilder.append(" AND nombre = ?");
    }

    PreparedStatement ps = conexion.prepareStatement(queryBuilder.toString());

    int parameterIndex = 1;
    if (codigoProveedor != null && codigoProveedor != 0) {
        ps.setInt(parameterIndex++, codigoProveedor);
    }

    if (nombreProveedor != null && !nombreProveedor.isEmpty()) {
        ps.setString(parameterIndex++, nombreProveedor);
    }


    ResultSet rs = ps.executeQuery();
    List<Proveedor> proveedores = new ArrayList<>();

    while (rs.next()) {
        int proveedorId = rs.getInt("proveedor_id");
        String nombre = rs.getString("nombre");
        String telefonoProveedor = rs.getString("telefono");
        boolean proveedorActivo = rs.getBoolean("activo");
        BigDecimal limiteCredito = rs.getBigDecimal("limite_credito");

        Proveedor proveedor = new Proveedor(proveedorId, nombre, telefonoProveedor, proveedorActivo, limiteCredito);
        proveedores.add(proveedor);
    }

    if (proveedores.isEmpty()) {
        errores.add(ErroresProveedores.PROVEEDOR_NO_ENCONTRADO);
    }

    return proveedores;
}


    
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
         ArrayList<errores.ErrorGeneral> errores = new ArrayList<>();
         int codigoProveedor = 1;
         String nombreProveedor = "Lavanderia Rosario1";
         String telefono = "849-986-0987";
         boolean estaActivo = true;
         BigDecimal limiteCredito = new BigDecimal("500");

         List<Proveedor> proveedoresEncontrados = verProveedorDos(0, "", telefono, true, null, errores);
         if (!errores.isEmpty()) {
             for (errores.ErrorGeneral error : errores) {
                 System.out.println("Error: " + error.getMensajeError());
             }
         } else {
             System.out.println("Proveedores encontrados:");
             for (Proveedor proveedor : proveedoresEncontrados) {
                 System.out.println("Código: " + proveedor.getProveedorId());
                 System.out.println("Nombre: " + proveedor.getNombre());
                 System.out.println("Teléfono: " + proveedor.getTelefono());
                 System.out.println("Activo: " + proveedor.isEstaActivo());
                 System.out.println("Límite de crédito: " + proveedor.getLimiteCredito());
             }
         }
    }
}
