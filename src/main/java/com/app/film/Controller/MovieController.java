package com.app.film.Controller;
import com.app.film.Model.Movie;

import java.util.List;

import com.app.film.Repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/film")
public class MovieController {

    @Autowired
    private  MovieRepository movieRepository;

    @GetMapping("/films")
    public @ResponseBody List<Movie> AllMovie(){
        return movieRepository.findAll();
    }

    @PostMapping("/add")

    public @ResponseBody Movie AddMovie (@RequestBody Movie movie){
       return movieRepository.save(movie);
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody List<Movie> DeleteMovie(@PathVariable long id){
        movieRepository.deleteById(id);
        return AllMovie();
    }

    @GetMapping("/movieByGenter/{gender}")
    public ResponseEntity<List<Movie>> FindMovieByIGender(@PathVariable String gender){
       return new ResponseEntity<List<Movie>>(movieRepository.findByGender(gender),HttpStatus.OK);
    }

    @GetMapping("/movieByName/{name}")
    public ResponseEntity<List<Movie>> FindMovieByName(@PathVariable String name){
       return new ResponseEntity<List<Movie>>(movieRepository.findByName(name),HttpStatus.OK);
    }

    @PostMapping("/url/{id}")
    public @ResponseBody List<Movie> updateURL(@RequestParam String url, @PathVariable Long id){
        Movie movie = movieRepository.findById(id).orElse(null);
        movie.setUrl(url);
        return AllMovie();
    }

    @RequestMapping("/movie/{id}")
    public @ResponseBody Movie FindById(@PathVariable long id){
        return movieRepository.findById(id).orElse(null);
    }

    
}
