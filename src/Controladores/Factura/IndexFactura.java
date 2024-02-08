/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Factura;

import Controladores.MyConnection;
import static Controladores.ParametrosGenericos.setParametros;
import entidades.Categoria;
import entidades.Factura;
import entidades.Proveedor;
import errores.ErrorGeneral;
import errores.ErroresFactura;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lizor
 */
public class IndexFactura {

    /**
     * @param args the command line arguments
     */
    
   public static List<Factura> IndexFactura(Integer idFactura, LocalDate fecha, Integer categoriaId, Integer proveedorId, String comentario, BigDecimal monto, ArrayList<ErrorGeneral> errores) {
    List<Factura> facturas = new ArrayList<>();
    Connection conexion = null;

    try {
        conexion = MyConnection.getConnection();
        StringBuilder queryBuilder = new StringBuilder("SELECT f.*, c.nombre AS nombre_categoria, p.nombre AS nombre_proveedor FROM factura f");

        queryBuilder.append(" LEFT JOIN categoria c ON f.categoria_id = c.categoria_id");

        queryBuilder.append(" LEFT JOIN proveedor p ON f.proveedor_id = p.proveedor_id");

        queryBuilder.append(" WHERE 1 = 1");

        List<Object> parameters = new ArrayList<>();

        if (categoriaId != null && categoriaId != 0) {
            queryBuilder.append(" AND f.categoria_id = ?");
            parameters.add(categoriaId);
        }

        if (proveedorId != null && proveedorId != 0) {
            queryBuilder.append(" AND f.proveedor_id = ?");
            parameters.add(proveedorId);
        }

        if (monto != null) {
            queryBuilder.append(" AND f.monto = ?");
            parameters.add(monto);
        }

        PreparedStatement ps = conexion.prepareStatement(queryBuilder.toString());
        setParametros(ps, parameters);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            agregarUnaFacturaDesdeResultSet(rs, facturas);
        }

        rs.close();
        ps.close();

    } catch (SQLException ex) {
        errores.add(ErroresFactura.ERROR_INESPERADO);
        ex.printStackTrace();
    }

    return facturas;
}

private static void agregarUnaFacturaDesdeResultSet(ResultSet rs, List<Factura> facturas) throws SQLException {
    // Obtener datos de Factura
    int idFactura = rs.getInt("id_factura");
    LocalDate fecha = rs.getDate("fecha").toLocalDate();
    int categoriaId = rs.getInt("categoria_id");
    int proveedorId = rs.getInt("proveedor_id");
    String comentario = rs.getString("comentario");
    BigDecimal monto = rs.getBigDecimal("monto");
    String nombreCategoria = rs.getString("nombre_categoria");
    String nombreProveedor = rs.getString("nombre_proveedor");
    
    
    Factura factura = new Factura(idFactura, fecha, categoriaId, proveedorId, comentario, monto);
    factura.setNombreCategoria(nombreCategoria);
    factura.setNombreProveedor(nombreProveedor);

    facturas.add(factura);
}

   
    public static void main(String[] args) {
        // TODO code application logic here
        
         ArrayList<ErrorGeneral> errores = new ArrayList<>();
         
         int codigoFactura = 0;
         LocalDate fecha = null;
         int categoriaId = 0;
         int proveedorId = 0;
         String comentario = null;
         BigDecimal monto = null;
         
         
         List<Factura> facturaEncontrada = IndexFactura(codigoFactura, fecha, categoriaId, proveedorId, comentario, monto, errores);

        if (!errores.isEmpty()) {
            for (ErrorGeneral error : errores) {
                System.out.println("Error: " + error.getMensajeError());
            }
        } else {
            System.out.println("Facturas encontradas:");
            for (Factura factura : facturaEncontrada) {
                System.out.println("Factura: " + "\n" + factura + "\n");
            }
        }
    }
    
    public static List<String> obtenerNombresCategorias() {
        List<String> nombresCategorias = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexion = MyConnection.getConnection();
            String query = "SELECT nombre FROM categoria"; // Suponiendo que el nombre de la categoría está en el campo 'nombre'
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                nombresCategorias.add(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexion != null) conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return nombresCategorias;
    }

    public static List<String> obtenerNombresProveedores() {
        List<String> nombresProveedores = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexion = MyConnection.getConnection();
            String query = "SELECT nombre FROM proveedor"; // Suponiendo que el nombre del proveedor está en el campo 'nombre'
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                nombresProveedores.add(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexion != null) conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return nombresProveedores;
    }
    
   
    
    
    
}
