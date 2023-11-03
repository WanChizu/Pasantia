/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errores;

/**
 *
 * @author Lizor
 */
public class ErrorGeneral {

private  String mensajeError;
private  String mensajeSolucion;

    public ErrorGeneral(String mensajeError, String mensajeSolucion) {
        this.mensajeError = mensajeError;
        this.mensajeSolucion = mensajeSolucion;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getMensajeSolucion() {
        return mensajeSolucion;
    }

    public void setMensajeSolucion(String mensajeSolucion) {
        this.mensajeSolucion = mensajeSolucion;
    }



    
}
