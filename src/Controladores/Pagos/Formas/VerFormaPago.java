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

/**
 *
 * @author Lizor
 */
public class VerFormaPago {

    /**
     * @param args the command line arguments
     */
    
     public static FormaPago verFP(int FPId, ArrayList<errores.ErrorGeneral> errores) {
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexion = MyConnection.getConnection();
            String query = "SELECT * FROM forma_pago WHERE id_forma_pago = ?";
            ps = conexion.prepareStatement(query);
            ps.setInt(1, FPId);

            rs = ps.executeQuery();

            if (rs.next()) {
                int idFormaPago = rs.getInt("id_forma_pago");
                String nombreFormaPago = rs.getString("nombre_forma");
                
                FormaPago FP = new FormaPago(idFormaPago, nombreFormaPago);

                boolean validacionExitosa = ValidacionesFormaPago.validacionesGenericasDeFP(FP, errores);

                if (validacionExitosa) {
                    return FP;
                } else {

                    errores.add(ErroresPagos.ERROR_INESPERADO);
                }
            }
        } catch (SQLException ex) {
            errores.add(ErroresPagos.ERROR_INESPERADO);
            ex.printStackTrace();
        }

        return null;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<ErrorGeneral> errores = new ArrayList<>();
        int FPId = 3;

        FormaPago FPEncontrada = verFP(FPId, errores);

        if (errores.isEmpty()) {
            System.out.println("Forma de pago encontrada:");
            System.out.println(FPEncontrada);
        } else {
            ArrayList<ErrorGeneral> erroresTemporales = new ArrayList<>(errores);

            for (ErrorGeneral error : erroresTemporales) {
                System.out.println("Error: " + error);
            }

            errores.add(ErroresPagos.ERROR_INESPERADO);
        }

    }
    
}
