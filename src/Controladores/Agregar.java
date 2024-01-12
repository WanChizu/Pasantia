/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import entidades.Proveedor;
import errores.ErrorGeneral;
import errores.ErroresProveedores;
import java.math.BigDecimal;
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
public class Agregar {

    /**
     * @param args the command line arguments
     */

    private static List<ErrorGeneral> validarProveedor(Proveedor proveedor) throws SQLException {
        conexion con = new conexion();
        Connection conexion = con.conectar();
        List<ErrorGeneral> errores = new ArrayList<>();

        if (proveedor.getNombre().isEmpty()) {
            errores.add(ErroresProveedores.NOMBRE_VACIO);
        }

        if (proveedor.getNombre().length() > 50) {
            errores.add(ErroresProveedores.NOMBRE_MUY_LARGO);
        }

        if (proveedor.getNombre().length() < 5) {
            errores.add(ErroresProveedores.NOMBRE_MUY_CORTO);
        }

        if (campoExistente(conexion, proveedor.getNombre(), "nombre")) {
            errores.add(ErroresProveedores.NOMBRE_EXISTENTE);
        }

        if (campoExistente(conexion, proveedor.getTelefono(), "telefono")) {
            errores.add(ErroresProveedores.TELEFONO_EXISTENTE);
        }

        if (proveedor.getTelefono().length() > 12) {
            errores.add(ErroresProveedores.TELEFONO_MUY_LARGO);
        }

        if (proveedor.getTelefono().length() < 12) {
            errores.add(ErroresProveedores.TELEFONO_MUY_CORTO);
        }

        if (proveedor.getTelefono().isEmpty()) {
            errores.add(ErroresProveedores.TELEFONO_VACIO);
        }

        return errores;
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

    public static int insertarProveedor(Proveedor proveedorAGuardar, ArrayList<errores.ErrorGeneral> errores) throws SQLException {
        conexion con = new conexion();
        Connection conexion = con.conectar();
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
            errores.add(ErroresProveedores.ERROR_INESPERADO);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    errores.add(ErroresProveedores.ERROR_INESPERADO);
                }
            }
        }

        return idProveedorInsertado;
    }

    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Proveedor nuevoProveedor = new Proveedor(0, "Lavanderia Rosario1", "849-536-0987", true, new java.math.BigDecimal(5000));
        List<ErrorGeneral> errores = validarProveedor(nuevoProveedor);

        if (errores.isEmpty()) {
            try {
                insertarProveedor(nuevoProveedor, (ArrayList<ErrorGeneral>) errores);
                System.out.println("Proveedor insertado correctamente.");
            } catch (SQLException ex) {
                errores.add(ErroresProveedores.ERROR_INESPERADO);
            }
        } else {
            for (ErrorGeneral error : errores) {
                System.out.println("Error de validación: " + error.getMensajeError());
                System.out.println(error.getMensajeSolucion());
            }
        }
    }

}
