/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Factura;

import Controladores.MyConnection;
import entidades.Factura;
import errores.ErrorGeneral;
import errores.ErroresFactura;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lizor
 */
public class VerFactura {

    /**
     * @param args the command line arguments
     */
    
    public static Factura verFactura(int facturaId, List<ErrorGeneral> errores) {
    Connection conexion = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conexion = MyConnection.getConnection();
        StringBuilder queryBuilder = new StringBuilder("SELECT f.id_factura, f.fecha, f.categoria_id, f.proveedor_id, f.comentario, f.monto, f.id_area, c.nombre AS nombre_categoria, p.nombre AS nombre_proveedor, a.nombre AS nombre_area FROM factura f");

        queryBuilder.append(" LEFT JOIN categoria c ON f.categoria_id = c.categoria_id");
        queryBuilder.append(" LEFT JOIN proveedor p ON f.proveedor_id = p.proveedor_id");
        queryBuilder.append(" LEFT JOIN area a ON f.id_area = a.id_area");
        queryBuilder.append(" WHERE f.id_factura = ?");

        ps = conexion.prepareStatement(queryBuilder.toString());
        ps.setInt(1, facturaId);

        rs = ps.executeQuery();

        if (rs.next()) {
            int idFactura = rs.getInt("id_factura");
            java.sql.Date fechaSQL = rs.getDate("fecha");
            LocalDate fecha = fechaSQL.toLocalDate();
            int categoriaId = rs.getInt("categoria_id");
            int proveedorId = rs.getInt("proveedor_id");
            String comentario = rs.getString("comentario");
            BigDecimal monto = rs.getBigDecimal("monto");
            int areaId = rs.getInt("id_area");
            String nombreCategoria = rs.getString("nombre_categoria");
            String nombreProveedor = rs.getString("nombre_proveedor");
            String nombreArea = rs.getString("nombre_area");

            Factura factura = new Factura(idFactura, fecha, categoriaId, proveedorId, comentario, monto, areaId);
            factura.setNombreCategoria(nombreCategoria);
            factura.setNombreProveedor(nombreProveedor);
            factura.setNombreArea(nombreArea);

            boolean validacionExitosa = ValidacionesFactura.validacionesGenericasDeFactura(factura, errores);

            if (validacionExitosa) {
                return factura;
            } else {
                errores.add(ErroresFactura.ERROR_INESPERADO);
            }
        } else {
            errores.add(ErroresFactura.CATEGORIA_NO_ENCONTRADA);
        }
    } catch (SQLException ex) {
        errores.add(ErroresFactura.ERROR_INESPERADO);
    }

    return null;
}


        
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<errores.ErrorGeneral> errores = new ArrayList<>();
        int codigoFactura = 1;

        Factura facturaEncontrada = verFactura(codigoFactura, errores);
        if (errores.isEmpty()) {
            System.out.println("Proveedor encontrada:");
            System.out.println(facturaEncontrada.toString());
        } else {
            ArrayList<errores.ErrorGeneral> erroresTemporales = new ArrayList<>(errores);

            for (errores.ErrorGeneral error : erroresTemporales) {
                System.out.println("Error: " + error.getMensajeError());
                errores.add(ErroresFactura.ERROR_INESPERADO);
            }
        }
        
    } 
}
