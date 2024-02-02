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
    
   public static List<Factura> IndexFactura(Integer idFactura, LocalDate fecha, Integer categoriaId, Integer proveedorId, String comentario, BigDecimal monto, ArrayList<ErrorGeneral> errores){
   List<Factura> facturas = new ArrayList<>();
    Connection conexion = null;
       
    try {
        conexion = MyConnection.getConnection();
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM factura WHERE 1 = 1");
        List<Object> parameters = new ArrayList<>();
        
        if (categoriaId != null & categoriaId != 0){
         queryBuilder.append(" AND categoria_id = ?");   
         parameters.add(categoriaId);   
        }
            
        
        if (proveedorId != null && proveedorId != 0) {
            queryBuilder.append(" AND proveedor_id = ?");
            parameters.add(proveedorId);
        }
        
        if (monto != null) {
            queryBuilder.append(" AND monto = ?");
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
        int id = rs.getInt("id_factura");
        java.sql.Date fechaSQL = rs.getDate("fecha");
        LocalDate fec = fechaSQL.toLocalDate();
        int cId = rs.getInt("categoria_id");
        int pId = rs.getInt("proveedor_id");
        String com = rs.getString("comentario");
        BigDecimal mon = rs.getBigDecimal("monto");
        
         facturas.add(new Factura(id, fec, cId, pId, com, mon));

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
    
}
