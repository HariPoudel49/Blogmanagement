package com.bm.blogmanagement.repo;

import com.bm.blogmanagement.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
