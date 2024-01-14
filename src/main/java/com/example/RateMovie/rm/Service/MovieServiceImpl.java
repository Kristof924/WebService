package com.example.RateMovie.rm.Service;

import com.example.RateMovie.rm.Entity.MovieEntity;
import com.example.RateMovie.rm.Entity.UserEntity;
import com.example.RateMovie.rm.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private final MovieRepository movieRepository;


    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public MovieEntity getOneMovie(Long id) {
        return movieRepository.getById(id);
    }
    @Override
    public List<MovieEntity> getAllMovie() {
        return movieRepository.findAll();
    }

    @Override
    public Long findIdByTitle(String title) {
        List<MovieEntity> movies = movieRepository.findAll();

        for (int i = 1; i <= movies.size(); i++) {
            if (getOneMovie(Long.valueOf(i)).getTitle().equals(title)) {
                return Long.valueOf(i);
            }
        }

        return null;
    }

    @Override
    public void saveMovie(MovieEntity movie) {
        movieRepository.save(movie);
    }

    @Override
    public void saveImage(MultipartFile file, MovieEntity movie) throws IOException {
        String folder = "/springbootprojects/rm/src/main/resources/static/";
        byte[] bytes = file.getBytes();
        Path path = Paths.get(folder + findIdByTitle(movie.getTitle()) + ".jpg");
        Files.write(path, bytes);
    }


}
