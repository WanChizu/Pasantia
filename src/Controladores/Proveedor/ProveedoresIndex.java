/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Proveedor;


import Controladores.MyConnection;
import entidades.Proveedor;
import errores.ErrorGeneral;
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
    
public static List<Proveedor> IndexProveedor(Integer codigoProveedor, String nombreProveedor, String telefono, Boolean estaActivo, BigDecimal limiteDeCredito1, BigDecimal limiteDeCredito2 ,ArrayList<ErrorGeneral> errores) {
    List<Proveedor> proveedores = new ArrayList<>();
    Connection conexion = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conexion = MyConnection.getConnection();
        StringBuilder queryBuilder = new StringBuilder("SELECT proveedor_id, nombre, telefono, esta_activo, limite_credito FROM Proveedor WHERE 1 = 1");
        List<Object> parameters = new ArrayList<>();

        if (codigoProveedor != null && codigoProveedor != 0) {
            queryBuilder.append(" AND proveedor_id = ?");
            parameters.add(codigoProveedor);
        }

        if (nombreProveedor != null && !nombreProveedor.isEmpty()) {
            queryBuilder.append(" AND nombre LIKE ?");
            parameters.add("%" + nombreProveedor + "%");
        }

        if (telefono != null && !telefono.isEmpty()) {
            queryBuilder.append(" AND telefono LIKE ?");
            parameters.add("%" + telefono + "%");
        }

        if (estaActivo != null) {
            queryBuilder.append(" AND esta_activo = ?");
            parameters.add(estaActivo);
        }

        if (limiteDeCredito1 != null) {
            queryBuilder.append(" AND limite_credito >= ?");
            parameters.add(limiteDeCredito1);
        }
        
        if (limiteDeCredito2 != null) {
            queryBuilder.append(" AND limite_credito <= ?");
            parameters.add(limiteDeCredito2);
        }
        
        ps = conexion.prepareStatement(queryBuilder.toString());

       
        for (int i = 0; i < parameters.size(); i++) {
            ps.setObject(i + 1, parameters.get(i));
        }
        
         rs = ps.executeQuery();
            
            while (rs.next()) {
                agregarUnProveedorDesdeResultSet(rs, proveedores);
            }
            
            if (proveedores.isEmpty()) {
                errores.add(ErroresProveedores.PROVEEDOR_NO_ENCONTRADO);
            }
            
            rs.close();
        
        
    } catch (SQLException ex) {
        errores.add(ErroresProveedores.ERROR_INESPERADO);
        ex.printStackTrace();
   
    }

    return proveedores;
}

    private static void agregarUnProveedorDesdeResultSet(ResultSet rs, List<Proveedor> proveedores) throws SQLException {
        int proveedorId = rs.getInt("proveedor_id");
        String nombre = rs.getString("nombre");
        String telefonoProveedor = rs.getString("telefono");
        boolean proveedorActivo = rs.getBoolean("esta_activo");
        BigDecimal limiteCredito = rs.getBigDecimal("limite_credito");

        Proveedor proveedor = new Proveedor(proveedorId, nombre, telefonoProveedor, proveedorActivo, limiteCredito);
        proveedores.add(proveedor);
    }


    
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
     
         ArrayList<errores.ErrorGeneral> errores = new ArrayList<>();
        int codigoProveedor = 1;
        String nombreProveedor = "Lavanderia Rosario1";
        String telefono = "849-986-0987";
        boolean estaActivo = true;
        BigDecimal limiteCredito1 = new BigDecimal("500");
        BigDecimal limiteCredito2 = new BigDecimal("5000");

        List<Proveedor> proveedoresEncontrados = IndexProveedor(0, "", telefono, true, limiteCredito1, limiteCredito2,errores);
        if (!errores.isEmpty()) {
            for (errores.ErrorGeneral error : errores) {
                System.out.println("Error: " + error.getMensajeError());
            }
        } else {
            System.out.println("Proveedores encontrados:");
            for (Proveedor proveedor : proveedoresEncontrados) {
                System.out.println(proveedor.toString());
            }
        }
}

  
}
