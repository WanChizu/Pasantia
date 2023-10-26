/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasantia_proyect.controlador;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Lizor
 */
public class Proveedor {
    private int proveedorId;
    private String nombre;
    private String telefono;
    private boolean estaActivo;
    private double limiteCredito;
    
    public Proveedor(int proveedorId, String nombre, String telefono, boolean estaActivo, double limiteCredito) {
        this.proveedorId = proveedorId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.estaActivo = estaActivo;
        this.limiteCredito = limiteCredito;
    }
    
    public int getProveedorId() {
        return proveedorId;
    }
    
    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }
    
    public String getNombre() {
        return nombre;
    }
    
     public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     
      public String getTelefono() {
        return telefono;
    }
      
      public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEstaActivo() {
        return estaActivo;
    }
    
     public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
    
    
//    public static void insertarProveedor(Proveedor proveedorAGuardar) throws SQLException {
//        String query = "INSERT INTO Proveedor (nombre, telefono, esta_activo, limite_credito) VALUES (?, ?, ?, ?)";
//        PreparedStatement ps = null
//                
//        PreparedStatement ps = conexion.prepareStatement(query);
//        ps.setString(1, proveedorAGuardar.getNombre());
//        ps.setString(2, proveedorAGuardar.getTelefono());
//        ps.setBoolean(3, proveedorAGuardar.getEstaActivo());
//        ps.setDouble(4, proveedorAGuardar.getLimiteCredito());
//        ps.executeUpdate();
//        ps.close();
//    }
    
    public static void insertarProveedor(Proveedor proveedorAGuardar) throws SQLException {
        MyConnection conexion = new MyConnection();
        Connection con = conexion.getConnection();
    String query = "INSERT INTO Proveedor (nombre, telefono, esta_activo, limite_credito) VALUES (?, ?, ?, ?)";
    PreparedStatement ps = null;

    try {
        ps = conexion.prepareStatement(query);
        ps.setString(1, proveedorAGuardar.getNombre());
        ps.setString(2, proveedorAGuardar.getTelefono());
        ps.setBoolean(3, proveedorAGuardar.getestaActivo());
        ps.setDouble(4, proveedorAGuardar.getLimiteCredito());
        ps.executeUpdate();
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
}

    private boolean getestaActivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
    
    public static void main(String[] args) {
        
        
        Proveedor nuevoProveor=new Proveedor(1, "Liz Tejada", "8295683522", true,10000000);
    }
    
}
