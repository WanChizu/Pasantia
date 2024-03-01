/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Pagos;

import Controladores.MyConnection;
import static Controladores.ParametrosGenericos.setParametros;
import entidades.Pagos;
import errores.ErrorGeneral;
import errores.ErroresPagos;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
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
public class IndexPagos {

    /**
     * @param args the command line arguments
     */
    
    public static List<Pagos> IndexPagos(Integer idPago, String nombrePago, Integer idFactura, Integer idArea, BigDecimal monto1, BigDecimal monto2, LocalDate fechaInicio, LocalDate fechaFin, Integer idFormaPago, Boolean estadoPago, ArrayList<ErrorGeneral> errores) {
    List<Pagos> pagos = new ArrayList<>();
    Connection conexion = null;

    try {
        conexion = MyConnection.getConnection();
        StringBuilder queryBuilder = new StringBuilder("SELECT p.id_pago, p.nombre_pago, p.id_factura, p.id_area, p.monto, p.fecha_pago, p.id_forma_pago, p.estado_pago, a.nombre AS nombre_area, f.nombre_forma AS nombre_forma FROM pagos p");

        queryBuilder.append(" LEFT JOIN area a ON p.id_area = a.id_area");
        queryBuilder.append(" LEFT JOIN forma_pago f ON p.id_forma_pago = f.id_forma_pago");
        queryBuilder.append(" WHERE 1 = 1");

        List<Object> parameters = new ArrayList<>();

        if (idPago != null && idPago != 0) {
            queryBuilder.append(" AND p.id_pago = ?");
            parameters.add(idPago);
        }

        if (nombrePago != null && !nombrePago.isEmpty()) {
            queryBuilder.append(" AND p.nombre_pago LIKE ?");
            parameters.add("%" + nombrePago + "%");
        }

        if (idFactura != null && idFactura != 0) {
            queryBuilder.append(" AND p.id_factura = ?");
            parameters.add(idFactura);
        }

        if (idArea != null && idArea != 0) {
            queryBuilder.append(" AND p.id_area = ?");
            parameters.add(idArea);
        }

        if (monto1 != null) {
            queryBuilder.append(" AND p.monto >= ?");
            parameters.add(monto1);
        }

        if (monto2 != null) {
            queryBuilder.append(" AND p.monto <= ?");
            parameters.add(monto2);
        }

        if (fechaInicio != null) {
            queryBuilder.append(" AND p.fecha_pago >= ?");
            parameters.add(Date.valueOf(fechaInicio));
        }

        if (fechaFin != null) {
            queryBuilder.append(" AND p.fecha_pago <= ?");
            parameters.add(Date.valueOf(fechaFin));
        }

        if (idFormaPago != null && idFormaPago != 0) {
            queryBuilder.append(" AND p.id_forma_pago = ?");
            parameters.add(idFormaPago);
        }

        if (estadoPago != null) {
            queryBuilder.append(" AND p.estado_pago = ?");
            parameters.add(estadoPago);
        }

        PreparedStatement ps = conexion.prepareStatement(queryBuilder.toString());
        setParametros(ps, parameters);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            agregarUnPagoDesdeResultSet(rs, pagos);
        }

    } catch (SQLException ex) {
        errores.add(ErroresPagos.ERROR_INESPERADO);
        ex.printStackTrace();
    } finally {
        // Cierre de recursos aquí...
    }

    return pagos;
}

private static void agregarUnPagoDesdeResultSet(ResultSet rs, List<Pagos> pagos) throws SQLException {
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

    pagos.add(pago);
}



    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<ErrorGeneral> errores = new ArrayList<>();
        
        int codigoPago = 0;
        String nombrePago = "";
        int codigoFactura = 0; 
        int codigoArea = 0; 
        BigDecimal monto1 = new BigDecimal("100");
        BigDecimal monto2 = new BigDecimal("5000");
        LocalDate fechaInicio = LocalDate.of(2024, 3, 1);
         LocalDate fechaFin = LocalDate.of(2024, 3, 1);
        int idFormaPago = 0;
        Boolean estadoPago = null;
        
        List<Pagos> pagosEncontrados = IndexPagos(codigoPago, nombrePago, codigoFactura, codigoArea, monto1, monto2, fechaInicio, fechaFin, idFormaPago, estadoPago, errores);

        if (!errores.isEmpty()) {
            for (ErrorGeneral error : errores) {
                System.out.println("Error: " + error.getMensajeError());
            }
        } else {
            System.out.println("Pagos encontrados:");
            for (Pagos pago : pagosEncontrados) {
                System.out.println("Pago: " + "\n" + pago + "\n");
            }
        }
        
    }
    
}
