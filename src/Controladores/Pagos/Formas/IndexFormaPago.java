/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Pagos.Formas;

import Controladores.MyConnection;
import static Controladores.ParametrosGenericos.setParametros;
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
public class IndexFormaPago {

    /**
     * @param args the command line arguments
     */
    
     public static List<FormaPago> indexFP(Integer idFormaPago, String nombreFormaPago, ArrayList<ErrorGeneral> errores) {
        List<FormaPago> FP = new ArrayList<>();
        Connection conexion = MyConnection.getConnection();

        try {
            StringBuilder queryBuilder = new StringBuilder("SELECT id_forma_pago, nombre_forma FROM forma_pago WHERE true");
            List<Object> parameters = new ArrayList<>();

            if (idFormaPago != null && idFormaPago != 0) {
                queryBuilder.append(" AND id_forma_pago = ?");
                parameters.add(idFormaPago);
            }

            if (nombreFormaPago != null && !nombreFormaPago.isEmpty()) {
                queryBuilder.append(" AND nombre_forma LIKE ?");
                parameters.add("%" + nombreFormaPago + "%");
            }

            
            if (idFormaPago < 0) {
                errores.add(ErroresPagos.ID_NEGATIVO);
            }

            PreparedStatement ps = conexion.prepareStatement(queryBuilder.toString());
            setParametros(ps, parameters);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                agregarUnaFPDesdeResultSet(rs, FP);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            errores.add(ErroresPagos.ERROR_INESPERADO);
            ex.printStackTrace();
        }

        return FP;
    }
     
     private static void agregarUnaFPDesdeResultSet(ResultSet rs, List<FormaPago> FP) throws SQLException {
        int IdFormaPago = rs.getInt("id_forma_pago");
        String nombreFormaPago = rs.getString("nombre_forma");

        FP.add(new FormaPago(IdFormaPago, nombreFormaPago));
    }

    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<ErrorGeneral> errores = new ArrayList<>();
        int codigoFP = 0;
        String nombreFP = "Tarjeta";

        List<FormaPago> FPEncontrada = indexFP(codigoFP, null, errores);

        if (!errores.isEmpty()) {
            for (ErrorGeneral error : errores) {
                System.out.println("Error: " + error);
            }
        } else {
            System.out.println("Formas de pago encontradas:");
            for (FormaPago FP : FPEncontrada) {
                System.out.println(FP);
            }
        }
    }
    
}
