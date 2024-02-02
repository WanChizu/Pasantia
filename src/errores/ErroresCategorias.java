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
public class ErroresCategorias {
    
    public static ErrorGeneral ERROR_INESPERADO = new ErrorGeneral("Error inesperado.", "Intenta de nuevo.");
    public static ErrorGeneral ID_NEGATIVO = new ErrorGeneral("El ID no puede ser negativo.", "Agrega un digito positivo.");
    
    public static ErrorGeneral CATEGORIA_EXISTENTE = new ErrorGeneral ("Esta categoría ya existe.","Puedes intentar de nuevo con otro ID.");
    public static ErrorGeneral CATEGORIA_NO_ENCONTRADA = new ErrorGeneral("La categoría no fue encontrada.","Intenta de nuevo.");
    
    public static ErrorGeneral NOMBRE_MUY_LARGO = new ErrorGeneral("Nombre muy largo","El nombre debe tener  menos de 50 letras.");
    public static ErrorGeneral NOMBRE_MUY_CORTO = new ErrorGeneral("Nombre muy corto", "El nombre debe tener mas de 5 letras.");
    public static ErrorGeneral NOMBRE_VACIO = new ErrorGeneral("Nombre está vacío","Debes agregar un nombre.");
}
