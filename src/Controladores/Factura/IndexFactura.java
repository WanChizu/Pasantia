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
import errores.ErrorGeneral;
import errores.ErroresFactura;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lizor
 */
public class IndexFactura {

    /**
     */
    
public static List<Factura> IndexFactura(Integer idFactura, LocalDate fechaInicio, LocalDate fechaFin, Integer categoriaId, Integer proveedorId, String comentario1, String comentario2, BigDecimal monto1, BigDecimal monto2, Integer areaId, ArrayList<ErrorGeneral> errores) {
    List<Factura> facturas = new ArrayList<>();
    Connection conexion = null;

    try {
        conexion = MyConnection.getConnection();
        StringBuilder queryBuilder = new StringBuilder("SELECT f.id_factura, f.fecha, f.categoria_id, f.proveedor_id, f.comentario, f.monto, f.id_area, c.nombre AS nombre_categoria, p.nombre AS nombre_proveedor, a.nombre AS nombre_area FROM factura f");

        queryBuilder.append(" LEFT JOIN categoria c ON f.categoria_id = c.categoria_id");
        queryBuilder.append(" LEFT JOIN proveedor p ON f.proveedor_id = p.proveedor_id");
        queryBuilder.append(" LEFT JOIN area a ON f.id_area = a.id_area");

        queryBuilder.append(" WHERE 1 = 1");

        List<Object> parameters = new ArrayList<>();

        if (fechaInicio != null) {
            queryBuilder.append(" AND f.fecha >= ?");
            parameters.add(fechaInicio);
        }

        if (fechaFin != null) {
            queryBuilder.append(" AND f.fecha <= ?");
            parameters.add(fechaFin);
        }

        if (categoriaId != null && categoriaId != 0) {
            queryBuilder.append(" AND f.categoria_id = ?");
            parameters.add(categoriaId);
        }

        if (proveedorId != null && proveedorId != 0) {
            queryBuilder.append(" AND f.proveedor_id = ?");
            parameters.add(proveedorId);
        }

        if (comentario1 != null) {
            queryBuilder.append(" AND f.comentario LIKE ?");
            parameters.add("%" + comentario1 + "%");
        }

        if (comentario2 != null) {
            queryBuilder.append(" AND f.comentario LIKE ?");
            parameters.add("%" + comentario2 + "%");
        }

        if (monto1 != null) {
            queryBuilder.append(" AND f.monto >= ?");
            parameters.add(monto1);
        }

        if (monto2 != null) {
            queryBuilder.append(" AND f.monto <= ?");
            parameters.add(monto2);
        }

        if (areaId != null && areaId != 0) {
            queryBuilder.append(" AND f.id_area = ?");
            parameters.add(areaId);
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

public static void agregarUnaFacturaDesdeResultSet(ResultSet rs, List<Factura> facturas) throws SQLException {
    int idFactura = rs.getInt("id_factura");
    LocalDate fecha = rs.getDate("fecha").toLocalDate();
    int categoriaId = rs.getInt("categoria_id");
    int proveedorId = rs.getInt("proveedor_id");
    String comentario = rs.getString("comentario");
    BigDecimal monto = rs.getBigDecimal("monto");
    int areaId = rs.getInt("id_area");
    String nombreCategoria = rs.getString("nombre_categoria");
    String nombreProveedor = rs.getString("nombre_proveedor");
    String nombreArea = rs.getString("nombre_area");
    
    
    Factura factura = new Factura(idFactura, fecha, categoriaId, proveedorId, areaId, comentario, monto);
    factura.setNombreCategoria(nombreCategoria);
    factura.setNombreProveedor(nombreProveedor);
    factura.setNombreArea(nombreArea);

    facturas.add(factura);
}

   
    public static void main(String[] args) {
        // TODO code application logic here
        
         ArrayList<ErrorGeneral> errores = new ArrayList<>();
         
         int codigoFactura = 0;
         LocalDate fechaInicio = null;
         LocalDate fechaFin = null;
         int categoriaId = 0;
         int proveedorId = 0;
         String comentario1 = null;
         String comentario2 = null;
         BigDecimal monto1 = null;
         BigDecimal monto2 = null; 
         int areaId = 0;
         
         
         List<Factura> facturaEncontrada = IndexFactura(codigoFactura, fechaInicio, fechaFin, categoriaId, proveedorId, comentario1, comentario2, monto1, monto2, areaId, errores);

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
}
