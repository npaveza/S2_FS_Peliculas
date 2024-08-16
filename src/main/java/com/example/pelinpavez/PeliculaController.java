package com.example.pelinpavez;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class PeliculaController {
    private List<Pelicula> peliculas = new ArrayList<>();

    public PeliculaController(){
        //Inicializar lista
        peliculas.add(new Pelicula(1, "Pelicula1", 2011, "Director1", "Comedia", "DescripcionPelicula"));
        peliculas.add(new Pelicula(2, "Pelicula2", 2012, "Director2", "Drama", "DescripcionPelicula"));
        peliculas.add(new Pelicula(3, "Pelicula3", 2013, "Director3", "Terror", "DescripcionPelicula"));
        peliculas.add(new Pelicula(4, "Pelicula4", 2014, "Director4", "Acción", "DescripcionPelicula"));
    }

    @GetMapping("/peliculas")
    public List<Pelicula> getPeliculas(){
        return peliculas;
    }
    
    @GetMapping("/peliculas/{id}")
    public ResponseEntity<Pelicula> getPeliculaById(@PathVariable int id) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getId() == id) {
                return ResponseEntity.ok(pelicula);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Si no se encuentra la película
    }
}
