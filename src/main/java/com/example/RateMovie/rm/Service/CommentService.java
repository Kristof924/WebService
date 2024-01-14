package com.example.RateMovie.rm.Service;

import com.example.RateMovie.rm.Entity.CommentEntity;
import com.example.RateMovie.rm.Entity.MovieEntity;
import com.example.RateMovie.rm.Entity.UserEntity;

import java.util.List;

public interface CommentService {

    public void saveComment(CommentEntity comment);


    CommentEntity getOneCommentById(Long id);


    List<CommentEntity> getMovieComment(Long id);
}
