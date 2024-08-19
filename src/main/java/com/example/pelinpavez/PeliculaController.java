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
        peliculas.add(new Pelicula(1, "Caballeros de la mesa cuadrada", 1975, "Monthy Python", "Comedia", "Alocada comedia que narras las peripecias del rey Arturo y de sus caballeros de la Mesa Redonda durante la búsqueda del Santo Grial. Entre muchas aventuras, el rey Arturo cabalga un caballo imaginario mientras es seguido por su lacayo golpeando unas cáscaras de cocos, se enfrenta a desagradables franceses, combate a un gigante de tres cabezas y reta a un conejo asesino"));
        peliculas.add(new Pelicula(2, "El señor de los anillos: El retorno del rey", 2003, "Peter Jackson", "Aventura, Fantasía", "Gandalf y Aragorn lideran el Mundo de los hombres, e intentarán atraer la atención de Sauron para darle a Frodo la última oportunidad de completar su misión y así tratar de evitar sucumbir a las continuas tentaciones del Anillo."));
        peliculas.add(new Pelicula(3, "SAW", 2004, "James Wan", "Horror", "Dos extraños, que se despiertan en una habitación sin recordar cómo llegaron allí, pronto descubren que son peones en un juego mortal perpetrado por un famoso asesino en serie."));
        peliculas.add(new Pelicula(4, "Milagros Inesperados", 1999, "Frank Darabont", "Drama", "La vida de los guardias en el corredor de la muerte se ve afectada por uno de los reclusos: un hombre negro acusado de violar y asesinar a un niño, pero que tiene un misterioso don."));
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
