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
public class Clase_Proveedor {
    private int proveedorId;
    private String nombre;
    private String telefono;
    private boolean estaActivo;
    private double limiteCredito;
    
    public Clase_Proveedor(int proveedorId, String nombre, String telefono, boolean estaActivo, double limiteCredito) {
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
    
    public void insertarProveedor(Connection conexion) throws SQLException {
        String query = "INSERT INTO Proveedor (nombre, telefono, esta_activo, limite_credito) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1, nombre);
        ps.setString(2, telefono);
        ps.setBoolean(3, estaActivo);
        ps.setDouble(4, limiteCredito);
        ps.executeUpdate();
        ps.close();
    }
    
    
}
