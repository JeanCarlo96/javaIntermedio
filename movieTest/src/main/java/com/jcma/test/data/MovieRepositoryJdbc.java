package com.jcma.test.data;

import com.jcma.test.model.Genre;
import com.jcma.test.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieRepositoryJdbc implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        Object[] args = { id };
        return jdbcTemplate.queryForObject("select * from movies where id = ?", movieMapper, args);
    }

    @Override
    public Collection<Movie> findByName(String name) {
        Collection<Movie> allMovies = this.jdbcTemplate.query("select * from movies", movieMapper);
        Collection<Movie> moviesFound = new ArrayList<>();

        for(Movie movie : allMovies){
            if(movie.getName().toLowerCase().contains(name.toLowerCase())){
                moviesFound.add(movie);
            }
        }

        return moviesFound;
    }

    @Override
    public Collection<Movie> findAll() {
        return this.jdbcTemplate.query("select * from movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("insert into movies(name, minutes, genre) values (?, ?, ?)",
                movie.getName(), movie.getMinutes(), movie.getGenre().toString());

    }

    @Override
    public Collection<Movie> findMoviesByTemplate(Movie template) {
        List<Movie> allMovies = this.jdbcTemplate.query("select * from movies", movieMapper);

        List<Predicate<Movie>>  filters = new ArrayList<>();

        // Search by name
        if(template.getName() != null){
            filters.add(movie -> movie.getName().toLowerCase().contains(template.getName().toLowerCase()));
        }

        // Serach by minutes
        if(template.getMinutes() != null){
            filters.add(movie -> movie.getMinutes() <= template.getMinutes());
        }

        // Search by genre
        if(template.getGenre() != null){
            filters.add(movie -> movie.getGenre().equals(template.getGenre()));
        }

        return allMovies.stream()
                .filter(movie -> filters.stream().allMatch(filter -> filter.test(movie)))
                .collect(Collectors.toList());
    }

    private static RowMapper<Movie> movieMapper = (rs, rowNum) -> new Movie(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("minutes"),
            Genre.valueOf(rs.getString("genre")));
}
