/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Categoria;

import Controladores.MyConnection;
import entidades.Categoria;
import errores.ErroresCategorias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lizor
 */
public class VerCategoria {

    /**
     * @param args the command line arguments
     */
    
     public static Categoria verCategorias(int idCategoria, ArrayList<errores.ErrorGeneral> errores) {
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexion = MyConnection.getConnection();
            String query = "SELECT * FROM categoria WHERE categoria_id = ?";
            ps = conexion.prepareStatement(query);
            ps.setInt(1, idCategoria);

            rs = ps.executeQuery();

            if (rs.next()) {
                int categoriaId = rs.getInt("categoria_id");
                String nombreCategoria = rs.getString("nombre");
                boolean estaActivo = rs.getBoolean("esta_activo");

                Categoria categoria = new Categoria(categoriaId, nombreCategoria, estaActivo);

                boolean validacionExitosa = ValidacionesCategorias.validacionesGenericasDeCategorias(categoria, errores);

                if (validacionExitosa) {
                    return categoria;
                } else {

                    errores.add(ErroresCategorias.ERROR_INESPERADO);
                }
            } else {
                errores.add(ErroresCategorias.CATEGORIA_NO_ENCONTRADA);
            }
        } catch (SQLException ex) {
            errores.add(ErroresCategorias.ERROR_INESPERADO);
            ex.printStackTrace();
        }

        return null;
    }


    
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        ArrayList<errores.ErrorGeneral> errores = new ArrayList<>();
        int codigoCategoria = 3;

        Categoria categoriaEncontrada = verCategorias(codigoCategoria, errores);

        if (errores.isEmpty()) {
            System.out.println("Categoria encontrada:");
            System.out.println("Código: " + categoriaEncontrada.getCategoriaId());
            System.out.println("Nombre: " + categoriaEncontrada.getNombreCategoria());
            System.out.println("Activo: " + categoriaEncontrada.isEstaActivo());
        } else {
            ArrayList<errores.ErrorGeneral> erroresTemporales = new ArrayList<>(errores);

            for (errores.ErrorGeneral error : erroresTemporales) {
                System.out.println("Error: " + error.getMensajeError());
            }

            errores.add(ErroresCategorias.ERROR_INESPERADO);
        }

    }

}
