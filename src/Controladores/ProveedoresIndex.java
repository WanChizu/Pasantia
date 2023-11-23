/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import entidades.Proveedor;
import errores.ErroresProveedores;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lizor
 */
public class ProveedoresIndex {

    /**
     * @param args the command line arguments
     */
    
    public static Proveedor verProveedorDos (int codigoProveedor, String nombreProveedor, String telefono, boolean estaActivo, BigDecimal limiteDeCredito, ArrayList<errores.ErrorGeneral> errores) throws SQLException{
        Connection conexion = MyConnection.getConnection();
        String query = "SELECT * FROM Proveedor WHERE proveedor_id = ? AND nombre = ? AND telefono = ? AND estaActivo = ? AND limite_credito = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setInt(1, codigoProveedor);
        ps.setString(2, nombreProveedor);
        ps.setString(3, telefono);
        ps.setBoolean(4, estaActivo);
        ps.setBigDecimal(5, limiteDeCredito);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            codigoProveedor = rs.getInt("proveedor_id");
            nombreProveedor = rs.getString("nombre");
            telefono = rs.getString("telefono");
            estaActivo = rs.getBoolean("esta_activo");
            BigDecimal limiteCredito = rs.getBigDecimal("limite_credito");

            Proveedor proveedor = new Proveedor(codigoProveedor, nombreProveedor, telefono, estaActivo, limiteCredito);

            return proveedor;
        } else {
            errores.add(ErroresProveedores.PROVEEDOR_NO_ENCONTRADO);
        }
        return null;

            }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
         ArrayList<errores.ErrorGeneral> errores = new ArrayList<>();
         int codigoProveedor = 2;
    }
    
}
