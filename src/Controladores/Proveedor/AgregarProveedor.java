/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Proveedor;

import Controladores.Proveedor.MyConnection;
import entidades.Proveedor;
import errores.ErrorGeneral;
import errores.ErroresProveedores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lizor
 */
public class AgregarProveedor {

    /**
     * @param args the command line arguments
     */

    public static int insertarProveedor(Proveedor proveedorAGuardar, ArrayList<ErrorGeneral> errores) {
    int idProveedorInsertado = -1;
    Connection conexion = null;
    PreparedStatement ps = null;

    try {
        List<ErrorGeneral> erroresValidacion = ValidacionesProveedor.validarProveedor(proveedorAGuardar);
        errores.addAll(erroresValidacion);

        if (!erroresValidacion.isEmpty()) {
            return -1;
        }

        conexion = MyConnection.getConnection();
        String query = "INSERT INTO Proveedor (nombre, telefono, esta_activo, limite_credito) VALUES (?, ?, ?, ?)";
        ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, proveedorAGuardar.getNombre());
        ps.setString(2, proveedorAGuardar.getTelefono());
        ps.setBoolean(3, proveedorAGuardar.isEstaActivo());
        ps.setBigDecimal(4, proveedorAGuardar.getLimiteCredito());
        int filasAfectadas = ps.executeUpdate();

        if (filasAfectadas > 0) {
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                idProveedorInsertado = generatedKeys.getInt(1);
            }
        }
    } catch (SQLException ex) {
        errores.add(ErroresProveedores.ERROR_INESPERADO);
        ex.printStackTrace();    
    }

    return idProveedorInsertado;
}

    
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        ArrayList<ErrorGeneral> errores = new ArrayList<>();
        Proveedor nuevoProveedor = new Proveedor(0, "Prueba2", "829-938-0976", true, new java.math.BigDecimal(5000));
        int idProveedorInsertado = insertarProveedor(nuevoProveedor, errores);

        if (idProveedorInsertado != -1) {
            System.out.println("Proveedor insertado correctamente con ID: " + idProveedorInsertado);
        } else {
            for (ErrorGeneral error : errores) {
                System.out.println("Error de validación: " + error.getMensajeError());
                System.out.println(error.getMensajeSolucion());
            }
        }

        
    }
}   
    


