/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Factura;

import Controladores.MyConnection;
import entidades.Factura;
import errores.ErrorGeneral;
import errores.ErroresFactura;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lizor
 */
public class AgregarFactura {

    /**
     * @param args the command line arguments
     */
    
    public static int insertarFactura(Factura facturaAGuardar, ArrayList<ErrorGeneral> errores){
    int idFacturaInsertada = -1;
    Connection conexion = null;
    PreparedStatement ps = null;
    
    
    try {
        List<ErrorGeneral> erroresValidacion = ValidacionesFactura.validarFactura(facturaAGuardar);
        errores.addAll(erroresValidacion);

        if (!erroresValidacion.isEmpty()) {
            return -1;
        }
        
        conexion = MyConnection.getConnection();
        String query = "INSERT INTO factura (fecha, categoria_id, proveedor_id, comentario, monto) VALUES (?,?,?,?,?)";
        
        ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        
        ps.setDate(1, java.sql.Date.valueOf(facturaAGuardar.getFecha()));
        ps.setInt(2, facturaAGuardar.getCategoriaId());
        ps.setInt(3, facturaAGuardar.getProveedorId());
        ps.setString(4, facturaAGuardar.getComentario());
        ps.setBigDecimal(5, facturaAGuardar.getMonto());
        int filasAfectadas = ps.executeUpdate();
        
         if (filasAfectadas > 0) {
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                idFacturaInsertada = generatedKeys.getInt(1);
            }
        }
    } catch (SQLException ex) {
        errores.add(ErroresFactura.ERROR_INESPERADO);
        ex.printStackTrace();    
    }

    return idFacturaInsertada;

    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<ErrorGeneral> errores = new ArrayList<>();

        Factura nuevaFactura = new Factura(0, LocalDate.now(), 1, 2, "Comentario de prueba3", new java.math.BigDecimal(5000));

        int idFacturaInsertada = insertarFactura(nuevaFactura, errores);

        if (idFacturaInsertada != -1) {
            System.out.println("Factura insertada correctamente con ID: " + idFacturaInsertada);
        } else {
            System.out.println("Error al insertar la factura. \nDetalles de errores:");
            for (ErrorGeneral error : errores) {
                System.out.println("Error: " + error.getMensajeError());
            }
        }
        

    }
    
    
    
  
    
}
