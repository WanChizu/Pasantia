/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Lizor
 */
public class Pagos {
    private int idPagos;
    private String nombrePago;
    private int idFactura;
    private int areaId;
    private BigDecimal monto;
    private LocalDate fecha;
    private int idFormaPago;
    private boolean estadoPago;
    
    private String nombreFormaPago;
    private String nombreArea;  

    public Pagos(int idPagos, String nombrePago ,int idFactura, int areaId, BigDecimal monto, LocalDate fecha, int idFormaPago, boolean estadoPago) {
        this.idPagos = idPagos;
        this.nombrePago = nombrePago;
        this.idFactura = idFactura;
        this.areaId = areaId;
        this.monto = monto;
        this.fecha = fecha;
        this.idFormaPago = idFormaPago;
        this.estadoPago = estadoPago;
    }

    public int getIdPagos() {
        return idPagos;
    }

    public void setIdPagos(int idPagos) {
        this.idPagos = idPagos;
    }

    public String getNombrePago() {
        return nombrePago;
    }

    public void setNombrePago(String nombrePago) {
        this.nombrePago = nombrePago;
    }
    

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }
    
    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(int idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public String getNombreFormaPago() {
        return nombreFormaPago;
    }

    public void setNombreFormaPago(String nombreFormaPago) {
        this.nombreFormaPago = nombreFormaPago;
    }



    public boolean isEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(boolean estadoPago) {
        this.estadoPago = estadoPago;
    }
    
    
    
     @Override
    public String toString(){
    return "\nID del Pago: " + idPagos +
           "\nNombre del Pago: " + nombrePago +
           "\nID de la Factura: " + idFactura +
           "\nID del Área: " + areaId +
           "\nNombre del Área: " + nombreArea + 
           "\nMonto: " + monto +
           "\nFecha: " + fecha + 
           "\nForma del pago: " + nombreFormaPago +
           "\nEstado del pago: " + estadoPago;  
        
    }
    
    
}
