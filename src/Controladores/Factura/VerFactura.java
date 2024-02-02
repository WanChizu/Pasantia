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
            String query = "SELECT * FROM factura WHERE id_factura = ?";
            ps = conexion.prepareStatement(query);
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

                Factura factura = new Factura(idFactura, fecha, categoriaId, proveedorId, comentario, monto);

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
            ex.printStackTrace();
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
