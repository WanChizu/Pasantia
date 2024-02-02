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
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Lizor
 */
public class AgregarArea {

    /**
     * @param args the command line arguments
     */
    
     public static int insertarArea(Area areaAGuardar, ArrayList<ErrorGeneral> errores) {
        Connection conexion = null;
        PreparedStatement ps = null;
        int idAreaInsertada = -1;

        try {
            errores.addAll(ValidacionesArea.validarArea(areaAGuardar));

            if (!errores.isEmpty()) {
                return idAreaInsertada;
            }

            conexion = MyConnection.getConnection();
            String query = "INSERT INTO area (nombre) VALUES (?)";
            ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            agregarCamposAlInsert(ps, areaAGuardar);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    idAreaInsertada = generatedKeys.getInt(1);
                }
            }
        } catch (SQLException ex) {
            errores.add(ErroresArea.ERROR_INESPERADO);
            ex.printStackTrace();
        }
        return idAreaInsertada;
    }

    private static void agregarCamposAlInsert(PreparedStatement ps, Area areaAGuardar) throws SQLException {
        ps.setString(1, areaAGuardar.getNombreArea());

    }
    
    public static void main(String[] args) {
        // TODO code application logic here  
        
//Que presente el codigo actual pq da 0 
        ArrayList<ErrorGeneral> errores = new ArrayList<>();        
        Area areaNueva = new Area(0, "Prueba8");
        int idInsertado = insertarArea(areaNueva, errores);
        if (idInsertado != -1) {
            System.out.println("Área insertada correctamente con ID: " + idInsertado);
        } else {
            for (ErrorGeneral error : errores) {
                System.out.println(error);
            }
        }
    }
    
}
