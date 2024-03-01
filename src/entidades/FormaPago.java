/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Lizor
 */
public class FormaPago {
    private int idFormaPago;
    private String nombreFormaPago;

    public FormaPago(int idFormaPago, String nombreFormaPago) {
        this.idFormaPago = idFormaPago;
        this.nombreFormaPago = nombreFormaPago;
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

    @Override
    public String toString() {
        return "ID: " + idFormaPago + 
                "\nNombre: " + nombreFormaPago;
    }
    
    
}
