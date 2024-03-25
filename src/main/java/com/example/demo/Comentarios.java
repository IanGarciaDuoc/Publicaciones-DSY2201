package com.example.demo;

/**
 * Representa un comentario asociado a una publicación.
 * Cada comentario tiene un código único y un nombre (o contenido del comentario).
 */
public class Comentarios {
    // Código único del comentario, que puede usarse como identificador.
    private String codigo;
    
    // Nombre o contenido del comentario.
    private String nombre;
    
    /**
     * Constructor para crear un nuevo comentario.
     *
     * @param codigo El código único del comentario.
     * @param nombre El nombre o contenido del comentario.
     */
    public Comentarios(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    /**
     * Obtiene el código del comentario.
     *
     * @return El código único del comentario.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Obtiene el nombre o contenido del comentario.
     *
     * @return El nombre o contenido del comentario.
     */
    public String getNombre() {
        return nombre;
    }
}


