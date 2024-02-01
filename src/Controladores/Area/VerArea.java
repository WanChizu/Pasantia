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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lizor
 */
public class VerArea {

    /**
     * @param args the command line arguments
     */
    
    public static Area verAreas(int idArea, ArrayList<errores.ErrorGeneral> errores) {
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexion = MyConnection.getConnection();
            String query = "SELECT * FROM area WHERE id_area = ?";
            ps = conexion.prepareStatement(query);
            ps.setInt(1, idArea);

            rs = ps.executeQuery();

            if (rs.next()) {
                int IdArea = rs.getInt("id_area");
                String nombreArea = rs.getString("nombre");
                
                Area area = new Area(IdArea, nombreArea);

                boolean validacionExitosa = ValidacionesArea.validacionesGenericasDeArea(area, errores);

                if (validacionExitosa) {
                    return area;
                } else {

                    errores.add(ErroresArea.ERROR_INESPERADO);
                }
            } else {
                errores.add(ErroresArea.AREA_NO_ENCONTRADA);
            }
        } catch (SQLException ex) {
            errores.add(ErroresArea.ERROR_INESPERADO);
            ex.printStackTrace();
        }

        return null;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<ErrorGeneral> errores = new ArrayList<>();
        int codigoArea = 3;

        Area areaEncontrada = verAreas(codigoArea, errores);

        if (errores.isEmpty()) {
            System.out.println("Área encontrada:");
            System.out.println(areaEncontrada);
        } else {
            ArrayList<ErrorGeneral> erroresTemporales = new ArrayList<>(errores);

            for (ErrorGeneral error : erroresTemporales) {
                System.out.println("Error: " + error);
            }

            errores.add(ErroresArea.ERROR_INESPERADO);
        }

    }
    
}
