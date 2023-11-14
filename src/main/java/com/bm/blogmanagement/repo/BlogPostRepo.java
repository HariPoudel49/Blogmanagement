package com.bm.blogmanagement.repo;

import com.bm.blogmanagement.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepo extends JpaRepository<BlogPost, Long> {
}
