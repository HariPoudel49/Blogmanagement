package com.bm.blogmanagement.controller;

import com.bm.blogmanagement.config.AuthorizedUser;
import com.bm.blogmanagement.dto.BlogPostDto;
import com.bm.blogmanagement.dto.CommentDto;
import com.bm.blogmanagement.entity.BlogPost;
import com.bm.blogmanagement.service.BlogPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog-posts")
public class BlogPostController {
    private final BlogPostService blogPostService;

    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @PostMapping("/save")
    public ResponseEntity<BlogPostDto> saveBlogPost(@ModelAttribute BlogPostDto blogPostDto) {
        AuthorizedUser.isUserLogin();
        BlogPostDto blogPost = blogPostService.addBlogPost(blogPostDto);
        return ResponseEntity.ok(blogPost);
    }

    @PostMapping("/comments")
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto commentDto) {
        AuthorizedUser.isUserLogin();
        CommentDto comments = blogPostService.addComment(commentDto);
        return ResponseEntity.ok(comments);
    }

    @DeleteMapping("/comment/delete/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Integer commentId) {
        AuthorizedUser.isUserLogin();
        String isDeleted = blogPostService.deleteComment(commentId);
        return ResponseEntity.ok(isDeleted);
    }
    @DeleteMapping("/delete/{blogPostId}")
    public ResponseEntity<String> deleteBlogPost(@PathVariable Integer blogPostId){
        AuthorizedUser.isUserLogin();
       return ResponseEntity.ok(blogPostService.deleteBlogPost(blogPostId));
    }
    @GetMapping("/list")
    public ResponseEntity<List<BlogPost>> getAllBlogPost(){
        AuthorizedUser.isUserLogin();
        return ResponseEntity.ok(blogPostService.getBlogPostList());
    }

}
