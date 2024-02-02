/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Proveedor;

import Controladores.MyConnection;
import static Controladores.Proveedor.ValidacionesProveedor.validacionesGenericasDeProveedores;
import entidades.Proveedor;
import errores.ErrorGeneral;
import errores.ErroresProveedores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lizor
 */
public class ActualizarProveedor {
 
    /**
     * @param args the command line arguments
     */
    
    

 
    public static int actualizarProveedor(Proveedor proveedorAActualizar, ArrayList<ErrorGeneral> errores) {
    Connection conexion = null;
    PreparedStatement ps = null;
    
    try {
        conexion = MyConnection.getConnection();
        String query = "UPDATE Proveedor SET nombre = ?, telefono = ?, esta_activo = ?, limite_credito = ? WHERE proveedor_id = ?";
        ps = conexion.prepareStatement(query);

        boolean validacionExitosa = validacionesGenericasDeProveedores(proveedorAActualizar, errores);

        if (!validacionExitosa) {
            return -1; 
        }

        ps.setString(1, proveedorAActualizar.getNombre());
        ps.setString(2, proveedorAActualizar.getTelefono());
        ps.setBoolean(3, proveedorAActualizar.isEstaActivo());
        ps.setBigDecimal(4, proveedorAActualizar.getLimiteCredito());
        ps.setInt(5, proveedorAActualizar.getProveedorId());
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
    
 
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        ArrayList<ErrorGeneral> errores = new ArrayList<>();
        Proveedor actualizarProveedor = new Proveedor(1, "Lavanderia Rosario1", "849-976-0987", true, new java.math.BigDecimal(500));
        actualizarProveedor(actualizarProveedor, errores);

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
    
