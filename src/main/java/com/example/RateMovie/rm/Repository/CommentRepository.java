package com.example.RateMovie.rm.Repository;

import com.example.RateMovie.rm.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity,Long> {
}
