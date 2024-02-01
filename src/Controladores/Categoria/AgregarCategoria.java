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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lizor
 */
public class AgregarCategoria {

    /**
     * @param args the command line arguments
     */
    
     public static int insertarCategoria(Categoria categoriaAGuardar, ArrayList<ErrorGeneral> errores) {
    Connection conexion = null;
    PreparedStatement ps = null;
    int idCategoriaInsertada = -1;

    try {

        errores.addAll(ValidacionesCategorias.validarCategoria(categoriaAGuardar));

        if (!errores.isEmpty()) {
            return idCategoriaInsertada;
        }
        
        conexion = MyConnection.getConnection();
        String query = "INSERT INTO categoria (nombre, esta_activo) VALUES (?, ?)";
        ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        
        agregarCamposAlInsert(ps, categoriaAGuardar);
        int filasAfectadas = ps.executeUpdate();

        if (filasAfectadas > 0) {
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                idCategoriaInsertada = generatedKeys.getInt(1);
            }
        }
    } catch (SQLException ex) {
        errores.add(ErroresCategorias.ERROR_INESPERADO);
        ex.printStackTrace();
    }

    return idCategoriaInsertada;
}

    private static void agregarCamposAlInsert(PreparedStatement ps, Categoria categoriaAGuardar) throws SQLException {
        ps.setString(1, categoriaAGuardar.getNombreCategoria());
        ps.setBoolean(2, categoriaAGuardar.isEstaActivo());
    }


    
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<ErrorGeneral> errores = new ArrayList<>();
        Categoria categoriaNueva = new Categoria(0, "Prueba9", false);
        int idInsertado = insertarCategoria(categoriaNueva, errores);

        if (idInsertado != -1) {
            System.out.println("Categoría insertada correctamente con ID: " + idInsertado);
        } else {
            for (ErrorGeneral error : errores) {
                System.out.println("Error de validación: " + error);
            }
        }

    }
    
}
