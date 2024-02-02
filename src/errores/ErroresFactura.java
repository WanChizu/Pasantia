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
public class ErroresFactura {
    public static ErrorGeneral ERROR_INESPERADO = new ErrorGeneral("Error inesperado.","Intenta de nuevo.");
    public static ErrorGeneral ID_NEGATIVO = new ErrorGeneral("El ID no puede ser negativo.","Agrega un digito positivo.");
    
    public static ErrorGeneral FACTURA_NO_ENCONTRADA = new ErrorGeneral("La factura no fue encontrada.","Por favor, intenta de nuevo.");
    public static ErrorGeneral FACTURA_EXISTENTE = new ErrorGeneral("Esta factura ya esta registrada.", "Puedes intentar de nuevo con otro ID.");
    
    public static ErrorGeneral CATEGORIA_NO_ENCONTRADA = new ErrorGeneral("La categoría no fue encontrada.","Intenta de nuevo.");
    public static ErrorGeneral CATEGORIA_VACIA = new ErrorGeneral("No ha especificado el ID de categoría.","Por favor, escriba el ID indicado.");
    
    public static ErrorGeneral PROVEEDOR_NO_ENCONTRADO = new ErrorGeneral("Proveedor no encontrado.","Intenta de nuevo.");
    public static ErrorGeneral PROVEEDOR_VACIO = new ErrorGeneral("No ha específicado el ID del proveedor", "Por favor, escriba el ID indicado.");
    
    public static ErrorGeneral MONTO_NEGATIVO = new ErrorGeneral("El monto no puede ser negativo.","Por favor edite los digitos.");
    public static ErrorGeneral MONTO_VACIO = new ErrorGeneral("El monto no puede estar vacío.", "Por favor agregue un monto.");
    
    
    
}
