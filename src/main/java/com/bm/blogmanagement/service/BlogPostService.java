package com.bm.blogmanagement.service;

import com.bm.blogmanagement.dto.BlogPostDto;
import com.bm.blogmanagement.dto.CommentDto;
import com.bm.blogmanagement.entity.BlogPost;

public interface BlogPostService {
    BlogPost addBlogPost(BlogPostDto blogPostDto);

    CommentDto addComment(CommentDto commentDto);
}
