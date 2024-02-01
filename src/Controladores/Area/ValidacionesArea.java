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
public class ValidacionesArea {

     public static List<ErrorGeneral> validarArea(Area area) throws SQLException {
        Connection conexion = MyConnection.getConnection();
        List<ErrorGeneral> errores = new ArrayList<>();

        if (validacionesGenericasDeArea(area, errores)) {

        if (areaExistente(conexion, area.getNombreArea(), "nombre")) {
            errores.add(ErroresArea.AREA_EXISTENTE);
            
        if (area.getIdArea() < 0) {
        errores.add(ErroresArea.ID_NEGATIVO);
       
        
            }
        }
         }
        return errores;
    }
     
     public static List<ErrorGeneral> AreaNoEncontrada(Area area) throws SQLException {
        Connection conexion = MyConnection.getConnection();
        List<ErrorGeneral> errores = new ArrayList<>();
        
    if (!areaExistente(conexion, area.getNombreArea(), "nombre")) {
            errores.add(ErroresArea.AREA_NO_ENCONTRADA);
        }
        return errores;
    }
     
     public static boolean validacionesGenericasDeArea(Area area, List<ErrorGeneral> errores) {
        if (area.getNombreArea().isEmpty()) {
            errores.add(ErroresArea.NOMBRE_VACIO);
        }
        if (area.getNombreArea().length() > 50) {
            errores.add(ErroresArea.NOMBRE_MUY_LARGO);
        }

        if (area.getNombreArea().length() < 5) {
            errores.add(ErroresArea.NOMBRE_MUY_CORTO);

        }
        
        if (area.getIdArea() < 0) {
        errores.add(ErroresArea.ID_NEGATIVO);
    }


        return errores.isEmpty();
    }
    
     
     private static boolean areaExistente(Connection conexion, String valor, String campo) throws SQLException {
        String query = "SELECT COUNT(*) FROM area WHERE " + campo + " = ?";
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
