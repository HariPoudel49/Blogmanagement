package com.bm.blogmanagement.repo;

import com.bm.blogmanagement.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepo extends JpaRepository<Comment, Long> {
    @Modifying //use to update and delete database
    @Query(value = "delete from tbl_comment where id = ?1", nativeQuery = true)
    void deleteCommentById(Integer commentId);

}
