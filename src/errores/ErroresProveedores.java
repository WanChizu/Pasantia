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
public class ErroresProveedores {

    public static ErrorGeneral NOMBRE_MUY_LARGO = new ErrorGeneral("Nombre muy largo","El nombre debe tener  menos de 50 letras.");
    public static ErrorGeneral NOMBRE_MUY_CORTO = new ErrorGeneral("Nombre muy corto", "El nombre debe tener mas de 5 letras.");
    public static ErrorGeneral NOMBRE_VACIO = new ErrorGeneral("Nombre está vacío","Debes agregar un nombre.");
    public static ErrorGeneral NOMBRE_EXISTENTE = new ErrorGeneral("Este nombre ya existe.","Tal vez debes cambiar los datos.");
    
    public static ErrorGeneral TELEFONO_EXISTENTE = new ErrorGeneral("Este teléfono ya esta registrado.","Asegurate que el número esté correcto.");
    public static ErrorGeneral TELEFONO_MUY_LARGO = new ErrorGeneral("Teléfono muy largo.","El teléfono debe tener menos de 12 digítos.");
    public static ErrorGeneral TELEFONO_MUY_CORTO = new ErrorGeneral("Teléfono muy corto.","El teléfono debe tener 12 digítos.");
    public static ErrorGeneral TELEFONO_VACIO = new ErrorGeneral("El teléfono no puede estar vacío.", "Agrega un teléfono.");
    
    public static ErrorGeneral LIMITE_CREDITO_NEGATIVO = new ErrorGeneral("El límite de crédito no puede ser negativo.","Por favor ajusta el crédito.");
    
    public static ErrorGeneral ERROR_INESPERADO = new ErrorGeneral("Error inesperado.", "Intenta de nuevo.");
    public static ErrorGeneral ID_NEGATIVO = new ErrorGeneral("El ID no puede ser negativo.", "");
    
    public static ErrorGeneral PROVEEDOR_NO_ENCONTRADO = new ErrorGeneral("Proveedor no encontrado.","Intenta de nuevo.");
    
    public static ErrorGeneral NO_HUBO_CAMBIOS_FILAS = new ErrorGeneral("No hubo cambios nuevos para guardar.", "Intenta hacer un cambio si es necesario.");
    
}

