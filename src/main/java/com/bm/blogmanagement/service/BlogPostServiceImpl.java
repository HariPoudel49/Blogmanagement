package com.bm.blogmanagement.service;

import com.bm.blogmanagement.dto.BlogPostDto;
import com.bm.blogmanagement.dto.CommentDto;
import com.bm.blogmanagement.entity.BlogPost;
import com.bm.blogmanagement.entity.Comment;
import com.bm.blogmanagement.repo.BlogPostRepo;
import com.bm.blogmanagement.repo.CommentRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogPostServiceImpl implements BlogPostService {

    private final BlogPostRepo blogPostRepo;
    private final CommentRepo commentRepo;

    public BlogPostServiceImpl(BlogPostRepo blogPostRepo, CommentRepo commentRepo) {
        this.blogPostRepo = blogPostRepo;
        this.commentRepo = commentRepo;
    }


    @Override
    public BlogPost addBlogPost(BlogPostDto blogPostDto) {

        BlogPost blogPost = new BlogPost();
        blogPost.setTitle(blogPostDto.getTitle());
        blogPost.setContent(blogPostDto.getContent());
        blogPost.setThumbnail(blogPostDto.getThumbnail()); // Assuming the thumbnail is a byte array

        return blogPostRepo.save(blogPost);

    }

    @Override
    public CommentDto addComment(CommentDto commentDto) {
        BlogPost blogPost = blogPostRepo.findById(commentDto.getBlogPostId()).get();
        Comment comment = new Comment();
        comment.setId(null);
        comment.setContent(commentDto.getCommentContent());
        comment.setBlogPost(blogPost);

        if (blogPost.getComments() == null) {
            blogPost.setComments(new ArrayList<>());
        }
        blogPost.getComments().add(comment);

        commentRepo.save(comment);

        return commentDto;


    }
}
