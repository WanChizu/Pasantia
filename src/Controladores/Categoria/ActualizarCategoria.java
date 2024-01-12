/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Categoria;

import Controladores.MyConnection;
import entidades.Categoria;
import errores.ErrorGeneral;
import errores.ErroresProveedores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lizor
 */
public class ActualizarCategoria {

    /**
     * @param args the command line arguments
     */
    
    public static int actualizarCategoria(Categoria categoriaActualizar, ArrayList<ErrorGeneral> errores) {
        Connection conexion = null;
        PreparedStatement ps = null;

        try {
            conexion = MyConnection.getConnection();
            String query = "UPDATE categoria SET nombre = ?, esta_activo = ? WHERE categoria_id = ?";
            ps = conexion.prepareStatement(query);

            boolean validacionExitosa = ValidacionesCategorias.validacionesGenericasDeCategorias(categoriaActualizar, errores);

            if (!validacionExitosa) {
                return -1;
            }

            ps.setString(1, categoriaActualizar.getNombreCategoria());
            ps.setBoolean(2, categoriaActualizar.isEstaActivo());
            ps.setInt(3, categoriaActualizar.getCategoriaId());
            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                return filasAfectadas;
            }
        } catch (SQLException ex) {
            errores.add(ErroresProveedores.ERROR_INESPERADO);
            ex.printStackTrace();
        }
        return 0;
    }

     
     
    public static void main(String[] args) {
        // TODO code application logic here
       ArrayList<ErrorGeneral> errores = new ArrayList<>();
       Categoria actualizarCategoria = new Categoria(1, "Prueba1", true);
       actualizarCategoria(actualizarCategoria, errores);
       
        if (errores.isEmpty()) {
            System.out.println("Proveedor actualizado correctamente.");
        } else {
            for (ErrorGeneral error : errores) {
                System.out.println("Error de validación: " + error.getMensajeError());
                System.out.println(error.getMensajeSolucion());
            }
        }

    }
    
}
