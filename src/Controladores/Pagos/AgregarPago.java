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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lizor
 */
public class AgregarPago {

    /**
     * @param args the command line arguments
     */
    
    public static int insertarPago(Pagos pagoAGuardar, ArrayList<ErrorGeneral> errores){
    int idPagoInsertado = -1;
    Connection conexion = null;
    PreparedStatement ps = null;
    
    try {
        List<ErrorGeneral> erroresValidacion = ValidacionesPagos.validarPago(pagoAGuardar);
        errores.addAll(erroresValidacion);

        if (!erroresValidacion.isEmpty()) {
            return -1;
        }
        
        conexion = MyConnection.getConnection();
        String query = "INSERT INTO pagos (nombre_pago, id_factura, id_area, monto, fecha_pago, id_forma_pago, estado_pago) VALUES (?,?,?,?,?,?,?)";
        
        ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        
        ps.setString(1, pagoAGuardar.getNombrePago());
        ps.setInt(2, pagoAGuardar.getIdFactura());
        ps.setInt(3, pagoAGuardar.getAreaId());
        ps.setBigDecimal(4,  pagoAGuardar.getMonto());
        ps.setDate(5, java.sql.Date.valueOf(pagoAGuardar.getFecha()));
        ps.setInt(6, pagoAGuardar.getIdFormaPago());
        ps.setBoolean(7, pagoAGuardar.isEstadoPago());
        int filasAfectadas = ps.executeUpdate();
        
        if (filasAfectadas > 0) {
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                idPagoInsertado = generatedKeys.getInt(1);
            }
        }
    } catch (SQLException ex) {
        errores.add(ErroresPagos.ERROR_INESPERADO);
        ex.printStackTrace();    
    }

    return idPagoInsertado;

    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<ErrorGeneral> errores = new ArrayList<>();
        
        Pagos nuevoPago = new Pagos(0, "Pago de Luz", 1, 2, new java.math.BigDecimal(5000), LocalDate.now(), 1, false);
        
        int idPagoInsertado = insertarPago(nuevoPago, errores);

        if (idPagoInsertado != -1) {
            System.out.println("Pago insertada correctamente con ID: " + idPagoInsertado);
        } else {
            System.out.println("Error al insertar el pago. \nDetalles de errores:");
            for (ErrorGeneral error : errores) {
                System.out.println("Error: " + error.getMensajeError());
            }
        }
    }
    
}
