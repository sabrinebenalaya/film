package com.app.film.Repository;

import java.util.List;

import com.app.film.Model.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

    List<Movie> findByGender(String gender);
    List<Movie> findByName(String gender);
}