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
public class Factura {
    private int idFactura;
    private LocalDate fecha;
    private int categoriaId;
    private int proveedorId;
    private String comentario;
    private BigDecimal monto;
    
    private String nombreCategoria;
    private String nombreProveedor;

    public Factura(int idFactura, LocalDate fecha, int categoriaId, int proveedorId, String comentario, BigDecimal monto) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.categoriaId = categoriaId;
        this.proveedorId = proveedorId;
        this.comentario = comentario;
        this.monto = monto;
    }


    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public int getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }
    
    
    
    @Override
    public String toString(){
    return "ID: " + idFactura +
           "\nFecha: " + fecha +
           "\nID de Categoría: " + categoriaId +
           "\nNombre de la Categoria: " + nombreCategoria + 
           "\nID del Proveedor: " + proveedorId + 
           "\nNombre del Proveedor: " + nombreProveedor + 
           "\nComentario agregado: " + comentario +
           "\nMonto: " + monto;
         
    
}
    
}