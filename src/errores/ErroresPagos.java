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
public class ErroresPagos {
    
    public static ErrorGeneral PAGO_EXISTENTE = new ErrorGeneral("Este pago ya esta registrado.", "Intente de nuevo con un ID diferente");
    public static ErrorGeneral PAGO_NO_ENCONTRADO = new ErrorGeneral("El pago no fue encontrado.","Por favor, intenta de nuevo.");
    
    public static ErrorGeneral ERROR_INESPERADO = new ErrorGeneral("Error inesperado.","Intenta de nuevo.");
    public static ErrorGeneral ID_NEGATIVO = new ErrorGeneral("El ID no puede ser negativo.","Agrega un digito positivo.");
    
    public static ErrorGeneral FACTURA_NO_ENCONTRADA = new ErrorGeneral("La factura no fue encontrada.","Por favor, intenta de nuevo.");
    public static ErrorGeneral FACTURA_VACIA = new ErrorGeneral("No se ha especificado el ID de la Factura.","Por favor, escribe el ID indicado.");
    
    public static ErrorGeneral AREA_NO_ENCONTRADA = new ErrorGeneral("Área no encontrada.","Intenta de nuevo.");
    public static ErrorGeneral AREA_VACIA = new ErrorGeneral("No se ha específicado el ID del Área.","Por favor, escribe el ID indicado.");
    
    public static ErrorGeneral MONTO_NEGATIVO = new ErrorGeneral("El monto no puede ser negativo.","Por favor edite los digitos.");
    public static ErrorGeneral MONTO_VACIO = new ErrorGeneral("El monto no puede estar vacío.", "Por favor agregue un monto.");
    
    public static ErrorGeneral FORMA_PAGO_CORTO = new ErrorGeneral("La forma de pago no puede tener menos de 5 carácteres.", "Formas de pago existentes: crédito, transferencia, efectivo.");
    public static ErrorGeneral FORMA_PAGO_LARGO = new ErrorGeneral("La forma de pago no puede tener más de 20 carácteres.", "Formas de pago existentes: crédito, transferencia, efectivo.");
}
