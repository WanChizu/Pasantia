/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Area;

import Controladores.MyConnection;
import entidades.Area;
import errores.ErrorGeneral;
import errores.ErroresArea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lizor
 */
public class ActualizarArea {

    /**
     * @param args the command line arguments
     */
    
    public static int actualizarArea(Area areaActualizar, ArrayList<ErrorGeneral> errores) {
        Connection conexion = null;
        PreparedStatement ps = null;

        try {
            conexion = MyConnection.getConnection();
            String query = "UPDATE area SET nombre = ? WHERE id_area = ?";
            ps = conexion.prepareStatement(query);

            boolean validacionExitosa = ValidacionesArea.validacionesGenericasDeArea(areaActualizar, errores);

            if (!validacionExitosa) {
                return -1;
            }

            ps.setString(1, areaActualizar.getNombreArea());
            ps.setInt(2, areaActualizar.getIdArea());
            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                return filasAfectadas;
            }
        } catch (SQLException ex) {
            errores.add(ErroresArea.ERROR_INESPERADO);
            ex.printStackTrace();
        }
        return 0;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<ErrorGeneral> errores = new ArrayList<>();
        Area actualizarArea = new Area(1, "Prueba");
        actualizarArea(actualizarArea, errores);

        if (errores.isEmpty()) {
            System.out.println("La área fue actualizada correctamente:\n" + actualizarArea);
        } else {
            for (ErrorGeneral error : errores) {
                System.out.println(error);
            }
        }
    }
    
}
