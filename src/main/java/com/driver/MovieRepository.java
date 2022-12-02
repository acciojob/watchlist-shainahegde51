package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
@Component
public class MovieRepository {
    HashMap<String,Movie>ListOfMovies = new HashMap<>();
    HashMap<String,Director>ListOfDirectors = new HashMap<>();
    HashMap<String, List<String>> MovieAndDirector =new HashMap<>();
    List<String>movieList;
    public void Addmovie(Movie m){
        ListOfMovies.put(m.getName(),m);
    }
    public void addDirectorInDB(Director d){
        ListOfDirectors.put(d.getName(),d);
    }
    public void addMovieAndDirectorInDB(String directorName,String movieName ){
        movieList=new ArrayList<>();
        if (MovieAndDirector.containsKey(directorName)){
           movieList=MovieAndDirector.get(directorName);
        }
        else {
            movieList.add(movieName);
            MovieAndDirector.put(directorName, movieList);
        }
    }
    public Movie getMovieByName(String name){
        return ListOfMovies.get(name);
    }

    public Director getDirectorByName(String name){
        return ListOfDirectors.get(name);
    }

    public List<String> getMoviesByDirectorName(String name){
        return MovieAndDirector.get(name);
    }

    public List<String> findAllMovies(){
        List<String> allMovies=new ArrayList<>();
        for(Movie m:ListOfMovies.values()){
            allMovies.add(m.getName());
        }
        return allMovies;
    }

    public void deleteDirectorByName(String name){
        MovieAndDirector.remove(name);
    }

    public void deleteAllDirectors(){
        for(String key:MovieAndDirector.keySet()){
            MovieAndDirector.remove(key);
        }
    }
}