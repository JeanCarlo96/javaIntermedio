package com.jcma.test.data;

import com.jcma.test.model.Movie;

import java.util.Collection;

public interface MovieRepository {

    Movie findById(long id);
    Collection<Movie> findByName(String name);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);

    Collection<Movie> findMoviesByTemplate(Movie template);

}
