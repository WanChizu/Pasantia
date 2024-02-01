/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Area;

import Controladores.MyConnection;
import static Controladores.ParametrosGenericos.setParametros;
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
public class AreaIndex {

    /**
     * @param args the command line arguments
     */
    
    public static List<Area> indexArea(Integer idArea, String nombre, ArrayList<ErrorGeneral> errores) {
        List<Area> area = new ArrayList<>();
        Connection conexion = MyConnection.getConnection();

        try {
            StringBuilder queryBuilder = new StringBuilder("SELECT * FROM area WHERE true");
            List<Object> parameters = new ArrayList<>();

            if (idArea != null && idArea != 0) {
                queryBuilder.append(" AND id_area = ?");
                parameters.add(idArea);
            }

            if (nombre != null && !nombre.isEmpty()) {
                queryBuilder.append(" AND nombre LIKE ?");
                parameters.add("%" + nombre + "%");
            }

            
            if (idArea< 0) {
                errores.add(ErroresArea.ID_NEGATIVO);
            }

            PreparedStatement ps = conexion.prepareStatement(queryBuilder.toString());
            setParametros(ps, parameters);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                agregarUnaAreaDesdeResultSet(rs, area);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            errores.add(ErroresArea.ERROR_INESPERADO);
            ex.printStackTrace();
        }

        return area;
    }
    
    private static void agregarUnaAreaDesdeResultSet(ResultSet rs, List<Area> area) throws SQLException {
        int IdArea = rs.getInt("id_area");
        String nombreArea = rs.getString("nombre");

        area.add(new Area(IdArea, nombreArea));
    }


    
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<ErrorGeneral> errores = new ArrayList<>();
        int codigoArea = 0;
        String nombreArea = "Prueba";

        List<Area> areaEncontrada = indexArea(codigoArea, null, errores);

        if (!errores.isEmpty()) {
            for (ErrorGeneral error : errores) {
                System.out.println("Error: " + error);
            }
        } else {
            System.out.println("Áreas encontradas:");
            for (Area area : areaEncontrada) {
                System.out.println(area);
            }
        }
    }
    
}
