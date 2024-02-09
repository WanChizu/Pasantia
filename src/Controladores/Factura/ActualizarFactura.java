/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Factura;

import static Controladores.Factura.ValidacionesFactura.validacionesGenericasDeFactura;
import Controladores.MyConnection;
import entidades.Factura;
import errores.ErrorGeneral;
import errores.ErroresFactura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lizor
 */
public class ActualizarFactura {

    /**
     * @param args the command line arguments
     */
    
    public static int actualizarFactura(Factura facturaAActualizar, ArrayList<ErrorGeneral> errores) {
        Connection conexion = null;
        PreparedStatement ps = null;

        try {
            conexion = MyConnection.getConnection();
            String query = "UPDATE factura SET fecha = ?, categoria_id = ?, proveedor_id = ?, comentario = ?, monto = ?, id_area = ? WHERE id_factura = ?";
            ps = conexion.prepareStatement(query);

            boolean validacionExitosa = validacionesGenericasDeFactura(facturaAActualizar, errores);

            if (!validacionExitosa) {
                return -1;
            }

            ps.setDate(1, java.sql.Date.valueOf(facturaAActualizar.getFecha()));
            ps.setInt(2, facturaAActualizar.getCategoriaId());
            ps.setInt(3, facturaAActualizar.getProveedorId());
            ps.setString(4, facturaAActualizar.getComentario());
            ps.setBigDecimal(5, facturaAActualizar.getMonto());
            ps.setInt(6, facturaAActualizar.getAreaId());
            ps.setInt(7, facturaAActualizar.getIdFactura());
            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                return filasAfectadas;
            }
        } catch (SQLException ex) {
            errores.add(ErroresFactura.ERROR_INESPERADO);
            ex.printStackTrace();

        }
        return 0;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<ErrorGeneral> errores = new ArrayList<>();
        Factura cambioFactura = new Factura(1, LocalDate.now(), 1, 1, "Prueba", new java.math.BigDecimal(5000), 2);

        actualizarFactura(cambioFactura, errores);
        
       if (errores.isEmpty()) {
            System.out.println("Factura actualizada correctamente.");
        } else {
            for (ErrorGeneral error : errores) {
                System.out.println("Error de validación: " + error.getMensajeError());
                System.out.println(error.getMensajeSolucion());
            }
        }
    }
    
}
