package com.bm.blogmanagement.service;

import com.bm.blogmanagement.dto.BlogPostDto;
import com.bm.blogmanagement.dto.CommentDto;

public interface BlogPostService {
    BlogPostDto addBlogPost(BlogPostDto blogPostDto);

    CommentDto addComment(CommentDto commentDto);

    String deleteComment(Integer commentId);
}
