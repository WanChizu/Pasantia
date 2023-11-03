/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import entidades.Proveedor;
import errores.ErroresProveedores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Lizor
 */
public class Agregar {
    /**
     * @param args the command line arguments
     */

 
private static ArrayList<errores.ErrorGeneral> validarProveedor(Proveedor proveedor) throws SQLException {
    Connection conexion = MyConnection.getConnection();
ArrayList<errores.ErrorGeneral> respuesta= new ArrayList<>();
    if (proveedor.getNombre().isEmpty()) {
        throw new SQLException("El nombre del proveedor no puede estar vacío.");
    }

    if (proveedor.getNombre().length() > 50) {
        respuesta.add(ErroresProveedores.NOMBRE_MUY_LARGO);
        throw new SQLException("El nombre del proveedor supera la longitud máxima permitida (50 caracteres).");
    }

    if (proveedor.getNombre().length() < 5) {
        throw new SQLException("El nombre del proveedor no cumple con la longitud requerida (debe ser mayor de 5 caracteres).");
    }

    if (campoExistente(conexion, proveedor.getNombre(), "nombre")) {
        throw new SQLException("El nombre del proveedor ya existe en la base de datos.");
    }

    if (campoExistente(conexion, proveedor.getTelefono(), "telefono")) {
        throw new SQLException("El número de teléfono ya está registrado en la base de datos.");
    }

    if (proveedor.getTelefono().length() > 12) {
        throw new SQLException("El número de teléfono supera la longitud máxima permitida (12 caracteres).");
    }

    if (proveedor.getTelefono().length() < 12) {
        throw new SQLException("El número de teléfono no cumple con la longitud requerida (debe ser de 12 caracteres).");
    }

    if (proveedor.getTelefono().isEmpty()) {
        throw new SQLException("El número de teléfono no puede estar vacío.");
    }

    return false;
}


private static boolean campoExistente(Connection conexion, String valor, String campo) throws SQLException {
    String query = "SELECT COUNT(*) FROM Proveedor WHERE " + campo + " = ?";
    PreparedStatement ps = conexion.prepareStatement(query);
    ps.setString(1, valor);

    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
        int count = rs.getInt(1);
        return count > 0;
    }
    return false;
}


 public static int insertarProveedor(Proveedor proveedorAGuardar,ArrayList<errores.ErrorGeneral> errores) throws SQLException {    
    Connection conexion = MyConnection.getConnection();
    String query = "INSERT INTO Proveedor (nombre, telefono, esta_activo, limite_credito) VALUES (?, ?, ?, ?)";
    PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    int idProveedorInsertado = -1;

    try {
       
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
        throw new SQLException("Error al insertar proveedor: " + ex.getMessage());
    } finally {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                throw new SQLException("Error al cerrar el PreparedStatement: " + ex.getMessage());
            }
        }
    }
    

    return idProveedorInsertado;
}


 
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Proveedor nuevoProveedor = new Proveedor(0, "Lavanderia Rosario2", "849-536-0987", true, new java.math.BigDecimal(5000));
        ArrayList<errores.ErrorGeneral> errores=   validarProveedor(nuevoProveedor);
        insertarProveedor(nuevoProveedor,errores);

    }
}
