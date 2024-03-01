/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Pagos.Formas;

import Controladores.MyConnection;
import Controladores.Pagos.ValidacionesPagos;
import entidades.FormaPago;
import errores.ErrorGeneral;
import errores.ErroresPagos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Lizor
 */
public class AgregarFormaPago {

    /**
     * @param args the command line arguments
     */
    
     public static int insertarFP(FormaPago FPAGuardar, ArrayList<ErrorGeneral> errores) {
        Connection conexion = null;
        PreparedStatement ps = null;
        int idFPInsertada = -1;

        try {
            errores.addAll(ValidacionesFormaPago.validarFormaPago(FPAGuardar));

            if (!errores.isEmpty()) {
                return idFPInsertada;
            }

            conexion = MyConnection.getConnection();
            String query = "INSERT INTO forma_pago (nombre_forma) VALUES (?)";
            ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            agregarCamposAlInsert(ps, FPAGuardar);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    idFPInsertada = generatedKeys.getInt(1);
                }
            }
        } catch (SQLException ex) {
            errores.add(ErroresPagos.ERROR_INESPERADO);
            ex.printStackTrace();
        }
        return idFPInsertada;
    }

    private static void agregarCamposAlInsert(PreparedStatement ps, FormaPago FPAGuardar) throws SQLException {
        ps.setString(1, FPAGuardar.getNombreFormaPago());

    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<ErrorGeneral> errores = new ArrayList<>();        
        FormaPago FPNuevo = new FormaPago(0, "Tarjeta");
        int idInsertado = insertarFP(FPNuevo, errores);
        if (idInsertado != -1) {
            System.out.println("Forma de pago insertada correctamente con ID: " + idInsertado);
        } else {
            for (ErrorGeneral error : errores) {
                System.out.println(error);
            }
        }
    }
    
        
    }
    
