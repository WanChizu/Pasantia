/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.math.BigDecimal;


/**
 *
 * @author Lizor
 */
public class Proveedor {
    private int proveedorId;
    private String nombre;
    private String telefono;
    private boolean estaActivo;
    private BigDecimal limiteCredito;
    
    public Proveedor(int proveedorId, String nombre, String telefono, boolean estaActivo, BigDecimal limiteCredito) {
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

    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(BigDecimal limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
  
    public String toString() {
        return  "ID: " + proveedorId +
                "\nNombre: " + nombre +
                "\nTeléfono: " + telefono +
                "\nEsta Activo: " + estaActivo +
                "\nLimite De Crédito: " + limiteCredito;
    }
    
}
