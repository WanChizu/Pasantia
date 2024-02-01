/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Categoria;


import entidades.Categoria;
import static Controladores.ParametrosGenericos.setParametros;
import Controladores.MyConnection;
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
public class CategoriaIndex {

    /**
     * @param args the command line arguments
     */
    public static List<Categoria> indexCategoria(Integer idCategoria, String nombre, Boolean estaActivo, ArrayList<ErrorGeneral> errores) {
        List<Categoria> categorias = new ArrayList<>();
        Connection conexion = MyConnection.getConnection();

        try {
            StringBuilder queryBuilder = new StringBuilder("SELECT * FROM categoria WHERE true");
            List<Object> parameters = new ArrayList<>();

            if (idCategoria != null && idCategoria != 0) {
                queryBuilder.append(" AND categoria_id = ?");
                parameters.add(idCategoria);
            }

            if (nombre != null && !nombre.isEmpty()) {
                queryBuilder.append(" AND nombre LIKE ?");
                parameters.add("%" + nombre + "%");
            }

            if (estaActivo != null) {
                queryBuilder.append(" AND esta_activo = ?");
                parameters.add(estaActivo);
            }
            
            if (idCategoria< 0) {
                errores.add(ErroresCategorias.ID_NEGATIVO);
            }

            PreparedStatement ps = conexion.prepareStatement(queryBuilder.toString());
            setParametros(ps, parameters);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                agregarUnaCategoriaDesdeResultSet(rs, categorias);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            errores.add(ErroresCategorias.ERROR_INESPERADO);
            ex.printStackTrace();
        }

        return categorias;
    }

    private static void agregarUnaCategoriaDesdeResultSet(ResultSet rs, List<Categoria> categorias) throws SQLException {
        int categoriaId = rs.getInt("categoria_id");
        String nombreCategoria = rs.getString("nombre");
        boolean categoriaActiva = rs.getBoolean("esta_activo");

        categorias.add(new Categoria(categoriaId, nombreCategoria, categoriaActiva));
    }

    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<ErrorGeneral> errores = new ArrayList<>();
        int codigoCategoria = 0;
        String nombreCategoria = "Prueba";
        boolean estaActivo = true;

        List<Categoria> categoriaEncontrada = indexCategoria(codigoCategoria, null, null, errores);

        if (!errores.isEmpty()) {
            for (ErrorGeneral error : errores) {
                System.out.println("Error: " + error.getMensajeError());
            }
        } else {
            System.out.println("Categorías encontradas:");
            for (Categoria categoria : categoriaEncontrada) {
                System.out.println("Categoría: " + "\n" + categoria + "\n");
            }
        }

    }

}
