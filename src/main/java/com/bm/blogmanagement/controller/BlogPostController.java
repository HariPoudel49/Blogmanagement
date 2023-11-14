package com.bm.blogmanagement.controller;

import com.bm.blogmanagement.config.AuthorizedUser;
import com.bm.blogmanagement.dto.BlogPostDto;
import com.bm.blogmanagement.dto.CommentDto;
import com.bm.blogmanagement.entity.BlogPost;
import com.bm.blogmanagement.service.BlogPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blog-posts")
public class BlogPostController {
    private final BlogPostService blogPostService;

    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @PostMapping("/save")
    public ResponseEntity<BlogPost> saveBlogPost(@RequestBody BlogPostDto blogPostDto) {
        AuthorizedUser.isUserLogin();
        BlogPost blogPost = blogPostService.addBlogPost(blogPostDto);
        return ResponseEntity.ok(blogPost);
    }

    @PostMapping("/comments")
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto commentDto) {
        AuthorizedUser.isUserLogin();
        CommentDto comments = blogPostService.addComment(commentDto);
        return ResponseEntity.ok(comments);
    }
}
