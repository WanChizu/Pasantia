/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Categoria;

import Controladores.Proveedor.MyConnection;
import entidades.Categoria;
import errores.ErrorGeneral;
import errores.ErroresCategorias;
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
public class ValidacionesCategorias {

    public static List<ErrorGeneral> validarCategoria(Categoria categoria) throws SQLException {
        Connection conexion = MyConnection.getConnection();
        List<ErrorGeneral> errores = new ArrayList<>();

        if (validacionesGenericasDeCategorias(categoria, errores)) {

        if (categoriaExistente(conexion, categoria.getNombreCategoria(), "nombre")) {
            errores.add(ErroresCategorias.CATEGORIA_EXISTENTE);
            
        if (categoria.getCategoriaId() < 0) {
        errores.add(ErroresCategorias.ID_NEGATIVO);
       
        
            }
        }
         }
        return errores;
    }
    
    public static List<ErrorGeneral> CategoriaNoEncontrada(Categoria categoria) throws SQLException {
        Connection conexion = MyConnection.getConnection();
        List<ErrorGeneral> errores = new ArrayList<>();
        
    if (!categoriaExistente(conexion, categoria.getNombreCategoria(), "nombre")) {
            errores.add(ErroresCategorias.CATEGORIA_NO_ENCONTRADA);
        }
        return errores;
    }
    

    public static boolean validacionesGenericasDeCategorias(Categoria categoria, List<ErrorGeneral> errores) {
        if (categoria.getNombreCategoria().isEmpty()) {
            errores.add(ErroresCategorias.NOMBRE_VACIO);
        }
        if (categoria.getNombreCategoria().length() > 50) {
            errores.add(ErroresCategorias.NOMBRE_MUY_LARGO);
        }

        if (categoria.getNombreCategoria().length() < 5) {
            errores.add(ErroresCategorias.NOMBRE_MUY_CORTO);

        }
        
        if (categoria.getCategoriaId() < 0) {
        errores.add(ErroresCategorias.ID_NEGATIVO);
    }


        return errores.isEmpty();
    }

    private static boolean categoriaExistente(Connection conexion, String valor, String campo) throws SQLException {
        String query = "SELECT COUNT(*) FROM categoria WHERE " + campo + " = ?";
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
