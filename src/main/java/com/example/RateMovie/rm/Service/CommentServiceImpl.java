package com.example.RateMovie.rm.Service;

import com.example.RateMovie.rm.Entity.CommentEntity;
import com.example.RateMovie.rm.Entity.MovieEntity;
import com.example.RateMovie.rm.Repository.CommentRepository;
import com.example.RateMovie.rm.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService{


    @Autowired
    private final CommentRepository commentRepository;

    @Autowired
    private final MovieService movieService;

    public CommentServiceImpl(CommentRepository commentRepository, MovieRepository movieRepository, MovieService movieService) {
        this.commentRepository = commentRepository;
        this.movieService = movieService;
    }

    @Override
    public void saveComment(CommentEntity comment) {
        commentRepository.save(comment);
    }

    @Override
    public CommentEntity getOneCommentById(Long id) {
        return commentRepository.getById(id);
    }


    @Override
    public List<CommentEntity> getMovieComment(Long id) {
        List<CommentEntity> comments = new ArrayList<>();
        MovieEntity movie = movieService.getOneMovie(id);
        for (int i = 1; i < commentRepository.findAll().size()-1; i++) {
            if(getOneCommentById(Long.valueOf(i)).getFilmID().equals(id)){
                comments.add(getOneCommentById(Long.valueOf(i)));
            }
        }
        return comments;
    }
}
