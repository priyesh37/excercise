package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository

public class MovieRepository {

    HashMap<String , Movie> mdb = new HashMap<>();
    HashMap<String , Director> ddb = new HashMap<>();

    HashMap<String , List<String>> mddb = new HashMap<>();

    public String addMovie(Movie movie) {
        mdb.put(movie.getName() , movie);
        return "Movie added success";
    }

    public void addDirector(Director director) {
        ddb.put(director.getName() , director);
    }

    public void addMovieDirectorPair(String mname, String dname) {

        if(mddb.containsKey(dname)) {
            List<String> res = mddb.get(dname);
            res.add(mname);
            mddb.put(dname, res);
        }
        else {


            List<String> newlist = new ArrayList<>();
            newlist.add(mname);
            mddb.put(dname,newlist);
        }
    }

    public Movie getMovieByName(String mname){
        return mdb.get(mname);
    }

    public Director getDirectorByName(String dname) {
        return ddb.get(dname);
    }

    public List<String> getMoviesByDirectorName(String dname) {

        return mddb.get(dname);
    }

    public List<Movie> findAllMovies() {

        List<Movie> list =  new ArrayList<>(mdb.values());
        return list;
    }

    public void deleteDirectorByName(String dname) {
        List<String> movies = mddb.get(dname);
        for(String mname: movies)
        {
            mdb.remove(mname);
        }
        ddb.remove(dname);
        mddb.remove(dname);
    }

    public void deleteAllDirectors() {

        List<String> dnames = new ArrayList<>();
//        List<List<String>> mnames = new ArrayList<>();
        List<List<String>> mnames = new ArrayList<>(mddb.values());
        for(String dname : ddb.keySet())
        {
            ddb.remove(dname);

            mddb.remove(dname);
        }
        for(List<String> movies : mnames)
        {
            for(String name : movies)
            {
                mdb.remove(name);
            }
        }
    }
}
