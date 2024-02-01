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
public class Categoria {
    private int categoriaId;
    private String nombreCategoria;
    private boolean estaActivo;

    public Categoria(int categoriaId, String nombreCategoria, boolean estaActivo) {
        this.categoriaId = categoriaId;
        this.nombreCategoria = nombreCategoria;
        this.estaActivo = estaActivo;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public boolean isEstaActivo() {
        return estaActivo;
    }

    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }
    
    public String toString() {
        return  "ID: " + categoriaId +
                "\nNombre: " + nombreCategoria +
                "\nEsta Activo: " + estaActivo;
    }
}
