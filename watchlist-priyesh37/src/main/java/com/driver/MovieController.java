package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){

        String res = movieService.addMovie(movie);
        return new ResponseEntity(res, HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-director ")
    public ResponseEntity addDirector(@RequestBody Director director)
    {
        movieService.addDirector(director);
        return new ResponseEntity("director added successfully:", HttpStatus.CREATED);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("mname") String mname , @RequestParam("dname") String dname)
    {
        movieService.addMovieDirectorPair(mname,dname);
        return new ResponseEntity("Movie-Director pair created successfully:", HttpStatus.CREATED);

    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String mname)
    {
        Movie movie = movieService.getMovieByName(mname);
        return new ResponseEntity( movie , HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String dname)
    {
        Director director = movieService.getDirectorByName(dname);
        return new ResponseEntity(director , HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String dname)
    {
        List<String> list = movieService.getMoviesByDirectorName(dname);
        return new ResponseEntity<>(list,HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity findAllMovies()
    {
        List<String> movies = movieService.findAllMovies();
        return new ResponseEntity(movies,HttpStatus.FOUND);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("dname") String dname)
    {
        movieService.deleteDirectorByName(dname);
        return new ResponseEntity<>("Director deleted successfully:" , HttpStatus.FOUND);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors ()
    {
        movieService.deleteAllDirectors ();
        return new ResponseEntity<>("Director and their movies deleted successfully:" , HttpStatus.FOUND);
    }



}
