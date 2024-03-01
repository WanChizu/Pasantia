/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Pagos;

import Controladores.MyConnection;
import entidades.Pagos;
import errores.ErrorGeneral;
import errores.ErroresPagos;
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
public class VerPago {

    /**
     * @param args the command line arguments
     */
    
   public static Pagos verPago(int pagoId, List<ErrorGeneral> errores) {
    Connection conexion = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conexion = MyConnection.getConnection();
        StringBuilder queryBuilder = new StringBuilder("SELECT p.id_pago, p.nombre_pago, p.id_factura, p.id_area, p.monto, p.fecha_pago, p.id_forma_pago, p.estado_pago, a.nombre AS nombre_area, f.nombre_forma FROM pagos p");

        queryBuilder.append(" LEFT JOIN area a ON p.id_area = a.id_area");
        queryBuilder.append(" LEFT JOIN forma_pago f ON p.id_forma_pago = f.id_forma_pago");
        queryBuilder.append(" WHERE p.id_pago = ?");

        ps = conexion.prepareStatement(queryBuilder.toString());
        ps.setInt(1, pagoId);

        rs = ps.executeQuery();

        if (rs.next()) {
            int idPago = rs.getInt("id_pago");
            String nombrePago = rs.getString("nombre_pago");
            int idFactura = rs.getInt("id_factura");
            int areaId = rs.getInt("id_area");
            BigDecimal monto = rs.getBigDecimal("monto");
            LocalDate fechaPago = rs.getDate("fecha_pago").toLocalDate();
            int idFormaPago = rs.getInt("id_forma_pago");
            boolean estadoPago = rs.getBoolean("estado_pago");
            String nombreArea = rs.getString("nombre_area");
            String nombreFormaPago = rs.getString("nombre_forma");

            Pagos pago = new Pagos(idPago, nombrePago, idFactura, areaId, monto, fechaPago, idFormaPago, estadoPago);
            pago.setNombreArea(nombreArea);
            pago.setNombreFormaPago(nombreFormaPago);

            boolean validacionExitosa = ValidacionesPagos.validacionesGenericasDePagos(pago, errores);

            if (validacionExitosa) {
                return pago;
            } else {
                errores.add(ErroresPagos.ERROR_INESPERADO);
            }
        } else {
            errores.add(ErroresPagos.PAGO_NO_ENCONTRADO);
        }
    } catch (SQLException ex) {
        errores.add(ErroresPagos.ERROR_INESPERADO);
    }

    return null;
}

    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<errores.ErrorGeneral> errores = new ArrayList<>();
        int codigoPago = 1;

        Pagos pagoEncontrado = verPago(codigoPago, errores);
        if (errores.isEmpty()) {
            System.out.println("Pago encontrado:");
            System.out.println(pagoEncontrado.toString());
        } else {
            ArrayList<errores.ErrorGeneral> erroresTemporales = new ArrayList<>(errores);

            for (errores.ErrorGeneral error : erroresTemporales) {
                System.out.println("Error: " + error.getMensajeError());
                errores.add(ErroresPagos.ERROR_INESPERADO);
            }
        }
    }
    
}
