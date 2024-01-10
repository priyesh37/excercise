package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie) {
        if (movie.getName().isEmpty()) {
            return "please mention movie name";
        }
        if (movie.getImdbRating() < 0) {
            return "imdb should be greater than 0";
        }
        if (movie.getDurationInMinutes() <= 0) {
            return "duration should bve greater than 0";
        } else {
            return movieRepository.addMovie(movie);

        }

    }
        public void addDirector(Director director) {
            movieRepository.addDirector(director);
        }

        public void addMovieDirectorPair(String mname, String dname) {
            movieRepository.addMovieDirectorPair(mname,dname);
        }

        public Movie getMovieByName(String mname) {
            return movieRepository.getMovieByName(mname);
        }

        public Director getDirectorByName(String dname) {
            return movieRepository.getDirectorByName(dname);
        }

    public List<String> getMoviesByDirectorName(String dname) {
        List<String> res = movieRepository.getMoviesByDirectorName(dname);
        return res;
    }

    public void deleteDirectorByName(String dname) {

        movieRepository.deleteDirectorByName(dname);
    }

    public void deleteAllDirectors() {

        movieRepository.deleteAllDirectors();
    }

    public List<String> findAllMovies() {
        List<Movie> movie = movieRepository.findAllMovies();
        List<String> res = new ArrayList<>();
        for(Movie movies : movie)
        {
            res.add(movies.getName());
        }
        return res;
    }


}
