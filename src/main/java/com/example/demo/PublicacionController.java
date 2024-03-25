package com.example.demo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Controlador REST para gestionar publicaciones.
 * Provee endpoints para obtener publicaciones y calcular promedios de calificaciones.
 */
@RestController
public class PublicacionController {
    // Lista para almacenar las publicaciones de forma temporal.
    private List<Publicacion> publicacion = new ArrayList<>();

    /**
     * Constructor que inicializa la lista de publicaciones con datos de muestra.
     */
    public PublicacionController() {
        // Agrega tres publicaciones de ejemplo a la lista de publicaciones.
        publicacion.add(new Publicacion(1, "Delincuencia en chile", "Autor1",
                Arrays.asList(new Comentarios("COM1", "Comentario1"), new Comentarios("COM2", "Comentario2")),
                llenarListaCalificaciones("Comentario1", 6.8, 2.1, 5.9)));
        
        publicacion.add(new Publicacion(2, "Robos en chile", "Autor2",
                Arrays.asList(new Comentarios("COM1", "Comentario1"), new Comentarios("COM2", "Comentario2")),
                llenarListaCalificaciones("Comentario1", 4.0, 3.7, 7.0)));

        publicacion.add(new Publicacion(3, "Triunfo de chile", "Autor3",
                Arrays.asList(new Comentarios("COM1", "Comentario1"), new Comentarios("COM2", "Comentario2")),
                llenarListaCalificaciones("Comentario1", 7.0, 4.8, 7.0)));
    }

    /**
     * Crea un mapa de calificaciones asociadas a un comentario.
     * 
     * @param comentarios El comentario asociado a las calificaciones.
     * @param calificacion1 Primera calificación.
     * @param calificacion2 Segunda calificación.
     * @param calificacion3 Tercera calificación.
     * @return Un mapa que asocia el comentario con una lista de calificaciones.
     */
    private Map<String, List<Double>> llenarListaCalificaciones(String comentarios, double calificacion1, double calificacion2, double calificacion3) {
        Map<String, List<Double>> retorno = new HashMap<>();
        List<Double> calificaciones = Arrays.asList(calificacion1, calificacion2, calificacion3);
        retorno.put(comentarios, calificaciones);
        return retorno;
    }

    /**
     * Obtiene todas las publicaciones.
     * 
     * @return Una lista de todas las publicaciones.
     */
    @GetMapping("/publicacion")
    public List<Publicacion> getPublicacion() {
        return publicacion;
    }

    /**
     * Obtiene una publicación por su ID.
     * 
     * @param id El ID de la publicación a buscar.
     * @return La publicación encontrada o null si no existe.
     */
    @GetMapping("/publicacion/{id}")
    public Publicacion getPublicacionById(@PathVariable int id) {
        return publicacion.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    /**
     * Calcula el promedio de todas las calificaciones de una publicación específica por su ID.
     * 
     * @param id El ID de la publicación.
     * @return El promedio de calificaciones o 0.0 si no hay calificaciones.
     */
    @GetMapping("/publicacion/{id}/promedioCalificaciones")
    public Double getPromedioCalificaciones(@PathVariable int id) {
        return publicacion.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .map(p -> p.getCalificaciones().values().stream()
                          .flatMap(List::stream)
                          .mapToDouble(Double::doubleValue)
                          .average()
                          .orElse(0.0))
                .orElse(0.0);
    }
}
