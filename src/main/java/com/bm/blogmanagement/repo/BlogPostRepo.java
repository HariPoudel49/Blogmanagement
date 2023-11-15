package com.bm.blogmanagement.repo;

import com.bm.blogmanagement.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BlogPostRepo extends JpaRepository<BlogPost, Long> {
    @Modifying
    @Query(value = "delete from tbl_blog_post where id = ?1", nativeQuery = true)
    void deleteBlogPostById(Integer blogpostId);

}
