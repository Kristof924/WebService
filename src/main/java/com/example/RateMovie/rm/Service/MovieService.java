package com.example.RateMovie.rm.Service;

import com.example.RateMovie.rm.Entity.MovieEntity;
import com.example.RateMovie.rm.Entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface MovieService {

    MovieEntity getOneMovie(Long id);

     List<MovieEntity> getAllMovie();

    Long findIdByTitle(String title);

    public void saveMovie(MovieEntity movie);

    void saveImage(MultipartFile file, MovieEntity movie) throws IOException;
}
