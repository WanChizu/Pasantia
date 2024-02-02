/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Factura;

import Controladores.MyConnection;
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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lizor
 */
public class ValidacionesFactura {

    /**
     * @param args the command line arguments
     */
    
    
     public static List<ErrorGeneral> validarFactura(Factura factura) throws SQLException {
        Connection conexion = MyConnection.getConnection();
        List<ErrorGeneral> errores = new ArrayList<>();
        
        if(validacionesGenericasDeFactura(factura, errores)){
            
        }
        
         if (facturaExistente(conexion, factura.getIdFactura())) {
             errores.add(ErroresFactura.FACTURA_EXISTENTE);
         }
        return errores;
    }
    
    public static boolean validacionesGenericasDeFactura(Factura factura, List<ErrorGeneral> errores){
        Proveedor proveedor = new Proveedor(0,null, null, true || false,null);
        Categoria categoria = new Categoria (0,null, true || false);
   
        
        if (factura.getMonto().compareTo(BigDecimal.ZERO) < 0) {
            errores.add(ErroresFactura.MONTO_NEGATIVO);
        }

        if (factura.getIdFactura() < 0) {
            errores.add(ErroresFactura.ID_NEGATIVO);
        }
        
        if (proveedor.getProveedorId() < 0){
        errores.add(ErroresFactura.ID_NEGATIVO);
        }
        
        if (categoria.getCategoriaId() < 0){
        errores.add(ErroresFactura.ID_NEGATIVO);
        }

        return errores.isEmpty();
    
    }
 
    
    private static boolean facturaExistente(Connection conexion, int idFactura) throws SQLException {
        String query = "SELECT COUNT(*) FROM factura WHERE id_factura = ?";
        PreparedStatement ps = conexion.prepareStatement(query);

        ps.setInt(1, idFactura);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0;
        }
        return false;
    }     
    
    

 
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
