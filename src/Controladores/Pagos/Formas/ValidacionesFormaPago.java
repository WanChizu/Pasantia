/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Pagos.Formas;

import Controladores.MyConnection;
import entidades.FormaPago;
import errores.ErrorGeneral;
import errores.ErroresPagos;
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
public class ValidacionesFormaPago {
    
    public static List<ErrorGeneral> validarFormaPago(FormaPago FP) throws SQLException{
        Connection conexion = MyConnection.getConnection();
        List<ErrorGeneral> errores = new ArrayList<>();
        
        if(validacionesGenericasDeFP(FP, errores)){
           
        
        if (FPExistente(conexion, FP.getNombreFormaPago(), "nombre_forma")) {
        errores.add(ErroresPagos.FORMA_PAGO_EXISTENTE);
        
        }
        
        if (FP.getIdFormaPago() < 0) {
        errores.add(ErroresPagos.ID_NEGATIVO);
        
        }
        
        }
        
        return errores;
    }
    
    public static boolean validacionesGenericasDeFP(FormaPago FP, List<ErrorGeneral> errores){
        
        if (FP.getNombreFormaPago().isEmpty()) {
            errores.add(ErroresPagos.NOMBRE_VACIO);
        }
        if (FP.getNombreFormaPago().length() > 20) {
            errores.add(ErroresPagos.NOMBRE_MUY_LARGO);
        }

        if (FP.getNombreFormaPago().length() < 5) {
            errores.add(ErroresPagos.NOMBRE_MUY_CORTO);

        }
        
        if (FP.getIdFormaPago() < 0) {
        errores.add(ErroresPagos.ID_NEGATIVO);
        }
        
    return errores.isEmpty();
    }
    
     private static boolean FPExistente(Connection conexion, String valor, String campo) throws SQLException {
        String query = "SELECT COUNT(*) FROM forma_pago WHERE " + campo + " = ?";
        PreparedStatement ps = conexion.prepareStatement(query);

        ps.setString(1, valor);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0;
        }
        return false;
    }
    
}
