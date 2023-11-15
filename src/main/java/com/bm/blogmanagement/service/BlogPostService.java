package com.bm.blogmanagement.service;

import com.bm.blogmanagement.dto.BlogPostDto;
import com.bm.blogmanagement.dto.CommentDto;
import com.bm.blogmanagement.entity.BlogPost;

import java.util.List;

public interface BlogPostService {
    BlogPostDto addBlogPost(BlogPostDto blogPostDto);

    CommentDto addComment(CommentDto commentDto);

    String deleteComment(Integer commentId);
    String deleteBlogPost(Integer  blogpostId);
    List<BlogPost> getBlogPostList();

}
