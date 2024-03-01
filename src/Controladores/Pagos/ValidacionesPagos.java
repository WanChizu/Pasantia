/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Pagos;

import Controladores.MyConnection;
import entidades.Area;
import entidades.Factura;
import entidades.FormaPago;
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
public class ValidacionesPagos {

    /**
     * @param args the command line arguments
     */
    
    public static List<ErrorGeneral> validarPago(Pagos pagos) throws SQLException {
        Connection conexion = MyConnection.getConnection();
        List<ErrorGeneral> errores = new ArrayList<>();
        
        if(validacionesGenericasDePagos(pagos, errores)){
            
        }
        
         if (PagoExistente(conexion, pagos.getIdFactura())) {
             errores.add(ErroresPagos.PAGO_EXISTENTE);
         }
        return errores;
    }
    
    
    public static boolean validacionesGenericasDePagos(Pagos pagos, List<ErrorGeneral> errores){
        Factura factura = new Factura(0, LocalDate.now(), 0, 0, 0, "", new java.math.BigDecimal(0));
        Area area = new Area(0, "");
        FormaPago fp = new FormaPago(0,"");
        
         if (pagos.getMonto().compareTo(BigDecimal.ZERO) < 0) {
            errores.add(ErroresPagos.MONTO_NEGATIVO);
            
         }
         
         if (pagos.getIdPagos() < 0) {
            errores.add(ErroresPagos.ID_NEGATIVO);
        }
         
         if(factura.getIdFactura() < 0){
            errores.add(ErroresPagos.ID_NEGATIVO);
        }
         
         if (area.getIdArea() < 0) {
            errores.add(ErroresPagos.ID_NEGATIVO);
        }
         
         if (pagos.getIdFormaPago() < 0) {
            errores.add(ErroresPagos.ID_NEGATIVO);
        }
         
    
        return errores.isEmpty();
    }
    
     private static boolean PagoExistente(Connection conexion, int idPago) throws SQLException {
        String query = "SELECT COUNT(*) FROM pagos WHERE id_pago = ?";
        PreparedStatement ps = conexion.prepareStatement(query);

        ps.setInt(1, idPago);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0;
        }
        return false;
    }     
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
