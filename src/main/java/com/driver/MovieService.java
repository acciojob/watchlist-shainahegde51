package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void AddMovie(Movie m){
        movieRepository.Addmovie(m);
    }

    public void AddDirector(Director d){
        movieRepository.addDirectorInDB(d);
    }

    public void createMovieDirectorPair(String mName,String dName){
        movieRepository.addMovieAndDirectorInDB(mName,dName);
    }

    public Movie getMovieByName(String name){
        return movieRepository.getMovieByName(name);
    }
    public Director getDirectorByName(String name){
        return movieRepository.getDirectorByName(name);
    }
    public List<String> getMoviesByDirectorName(String name){
        return movieRepository.getMoviesByDirectorName(name);
    }

    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }
    public void deleteDirectorByName(String name){
        movieRepository.deleteDirectorByName(name);
    }
    public void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
    }
}
