/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Proveedor;


import Controladores.MyConnection;
import static Controladores.ParametrosGenericos.setParametros;
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
    
public static List<Proveedor> IndexProveedor(Integer codigoProveedor, String nombreProveedor, String telefono, Boolean estaActivo, BigDecimal limiteDeCredito, ArrayList<ErrorGeneral> errores) {
    List<Proveedor> proveedores = new ArrayList<>();
    Connection conexion = MyConnection.getConnection();

    try {
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM Proveedor WHERE 1 = 1");
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

        if (estaActivo) {
            queryBuilder.append(" AND esta_activo = ?");
            parameters.add(estaActivo);
        }

        if (limiteDeCredito != null) {
            queryBuilder.append(" AND limite_credito = ?");
            parameters.add(limiteDeCredito);
        }
        
            PreparedStatement ps = conexion.prepareStatement(queryBuilder.toString());
            setParametros(ps, parameters);
            ResultSet rs = ps.executeQuery();


        while (rs.next()) {
            int proveedorId = rs.getInt("proveedor_id");
            String nombre = rs.getString("nombre");
            String telefonoProveedor = rs.getString("telefono");
            boolean proveedorActivo = rs.getBoolean("esta_activo");
            BigDecimal limiteCredito = rs.getBigDecimal("limite_credito");

            Proveedor proveedor = new Proveedor(proveedorId, nombre, telefonoProveedor, proveedorActivo, limiteCredito);
            proveedores.add(proveedor);
        }

        if (proveedores.isEmpty()) {
            errores.add(ErroresProveedores.PROVEEDOR_NO_ENCONTRADO);
        }

        rs.close();
        ps.close();
    } catch (SQLException ex) {
        errores.add(ErroresProveedores.ERROR_INESPERADO);
        ex.printStackTrace();
    } finally {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            errores.add(ErroresProveedores.ERROR_INESPERADO);
            ex.printStackTrace();
        }
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

        List<Proveedor> proveedoresEncontrados = IndexProveedor(0, "", telefono, true, null, errores);
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
