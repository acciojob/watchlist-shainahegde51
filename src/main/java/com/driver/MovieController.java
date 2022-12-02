package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;




    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody() Movie m){
        movieService.AddMovie(m);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @PostMapping("/movies/add-director")
    public ResponseEntity addDirector(Director d){
        movieService.AddDirector(d);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movieName") String mName, @RequestParam("directorName") String dName){
        movieService.createMovieDirectorPair(mName,dName);
        return new ResponseEntity(HttpStatus.CREATED);
    }



    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name){
        return new ResponseEntity(movieService.getMovieByName(name),HttpStatus.ACCEPTED);
    }


    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name){
        return new ResponseEntity(movieService.getDirectorByName(name),HttpStatus.ACCEPTED);
    }


    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String director){
        return new ResponseEntity(movieService.getMoviesByDirectorName(director),HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        return new ResponseEntity(movieService.findAllMovies(),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("name") String name){
        movieService.deleteDirectorByName(name);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    public ResponseEntity deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}


