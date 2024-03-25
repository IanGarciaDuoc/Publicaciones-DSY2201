package com.example.demo;

import java.util.List;
import java.util.Map;

/**
 * Clase que representa una publicación.
 * Contiene información sobre la publicación como su ID, nombre, autor, comentarios y calificaciones.
 */
public class Publicacion {
    // Identificador único de la publicación
    private int id;
    
    // Nombre de la publicación
    private String name;
    
    // Autor de la publicación
    private String autor;
    
    // Lista de comentarios asociados a la publicación
    private List<Comentarios> comentarios;
    
    // Mapa de calificaciones asociadas a la publicación.
    // Las claves son strings que identifican el aspecto calificado y los valores son listas de calificaciones (doubles)
    private Map<String, List<Double>> calificaciones;

    /**
     * Constructor para crear una nueva instancia de Publicacion.
     *
     * @param id El identificador único de la publicación.
     * @param name El nombre de la publicación.
     * @param autor El autor de la publicación.
     * @param comentarios Lista de comentarios asociados a la publicación.
     * @param calificaciones Mapa de calificaciones asociadas a la publicación.
     */
    public Publicacion(int id, String name, String autor, List<Comentarios> comentarios, Map<String, List<Double>> calificaciones) {
        this.id = id;   
        this.name = name;
        this.autor = autor;
        this.comentarios = comentarios;
        this.calificaciones = calificaciones;
    }
    // Getters

    /**
     * Obtiene el ID de la publicación.
     *
     * @return El ID de la publicación.
     */
    public int getId() {
        return id;
    }
    /**
     * Obtiene el nombre de la publicación.
     *
     * @return El nombre de la publicación.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene el autor de la publicación.
     *
     * @return El autor de la publicación.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Obtiene la lista de comentarios asociados a la publicación.
     *
     * @return Lista de comentarios de la publicación.
     */
    public List<Comentarios> getComentarios() {
        return comentarios;
    }

    /**
     * Obtiene el mapa de calificaciones asociadas a la publicación.
     * Las claves del mapa representan diferentes aspectos o comentarios y los valores son listas de calificaciones.
     *
     * @return Mapa de calificaciones de la publicación.
     */
    public Map<String, List<Double>> getCalificaciones() {
        return calificaciones;
    }
}
