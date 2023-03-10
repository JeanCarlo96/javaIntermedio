package com.jcma.test.data;

import com.jcma.test.model.Genre;
import com.jcma.test.model.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MovieRepositoryJdbcTest {

    private MovieRepositoryJdbc movieRepositoryJdbc;
    private DriverManagerDataSource dataSource;

    @Before
    public void setUp() throws SQLException {
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void load_all_movies() throws SQLException {

        Collection<Movie> movies = movieRepositoryJdbc.findAll();
        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION)
        )));

    }

    @Test
    public void load_movie_by_id(){
        Movie movie = movieRepositoryJdbc.findById(2);

        assertThat(movie, is(new Movie(2, "Memento", 113, Genre.THRILLER)));
    }

    @Test
    public void load_movie_by_name(){
        Collection<Movie> movies = movieRepositoryJdbc.findByName("M");

        assertThat(movies, is(Arrays.asList(
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION)
        )));
    }

    @Test
    public void insert_a_movie(){
        Movie movie = new Movie(4, "Super 8", 112, Genre.THRILLER);
        movieRepositoryJdbc.saveOrUpdate(movie);
        Movie movieFromDb = movieRepositoryJdbc.findById(4);

        assertThat(movieFromDb, is(movie));
    }

    @Test
    public void return_list_for_multiple_fields(){
        Movie movieTemplate = new Movie("M", 136, null);
        Collection<Movie> moviesByTemplate = movieRepositoryJdbc.findMoviesByTemplate(movieTemplate);

        assertThat(moviesByTemplate, is(Arrays.asList(
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION)
        )));
    }

    @After
    public void tearDown() throws Exception{
        final Statement stmt = dataSource.getConnection().createStatement();
        stmt.execute("drop all objects delete files");
    }


}