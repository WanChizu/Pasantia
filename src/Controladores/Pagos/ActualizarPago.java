/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Pagos;

import Controladores.MyConnection;
import static Controladores.Pagos.ValidacionesPagos.validacionesGenericasDePagos;
import entidades.Pagos;
import errores.ErrorGeneral;
import errores.ErroresPagos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Lizor
 */
public class ActualizarPago {

    /**
     * @param args the command line arguments
     */
    
    public static int actualizarPago(Pagos pagoAActualizar, ArrayList<ErrorGeneral> errores) {
        Connection conexion = null;
        PreparedStatement ps = null;

        try {
            conexion = MyConnection.getConnection();
            String query = "UPDATE pagos SET nombre_pago = ?, id_factura = ?, id_area = ?, monto = ?, fecha_pago = ?, id_forma_pago = ?, estado_pago = ? WHERE id_pago= ?";
            ps = conexion.prepareStatement(query);

            boolean validacionExitosa = validacionesGenericasDePagos(pagoAActualizar, errores);
            
             if (!validacionExitosa) {
                return -1;
            }
             
             ps.setString(1, pagoAActualizar.getNombrePago());
             ps.setInt(2, pagoAActualizar.getIdFactura());
             ps.setInt(3, pagoAActualizar.getAreaId());
             ps.setBigDecimal(4, pagoAActualizar.getMonto());
             ps.setDate(5, java.sql.Date.valueOf(pagoAActualizar.getFecha()));
             ps.setInt(6, pagoAActualizar.getIdFormaPago());
             ps.setBoolean(7, pagoAActualizar.isEstadoPago());
             ps.setInt(8, pagoAActualizar.getIdPagos());
            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                return filasAfectadas;
            }
        } catch (SQLException ex) {
            errores.add(ErroresPagos.ERROR_INESPERADO);
            ex.printStackTrace();

        }
        return 0;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<ErrorGeneral> errores = new ArrayList<>();
        
        Pagos actPago = new Pagos(1, "Pago de Luz", 1, 2, new java.math.BigDecimal(5000), LocalDate.now(), 2, true);
        
        actualizarPago(actPago, errores);
        
       if (errores.isEmpty()) {
            System.out.println("Pago actualizado correctamente.");
        } else {
            for (ErrorGeneral error : errores) {
                System.out.println("Error de validación: " + error.getMensajeError());
                System.out.println(error.getMensajeSolucion());
            }
        }
    }
    
}
