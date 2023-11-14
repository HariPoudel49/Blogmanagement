package com.bm.blogmanagement.dto;

import lombok.Data;

@Data
public class BlogPostDto {


    private Long id;

    private String title;
    private String content;

    private byte[] thumbnail;
}
