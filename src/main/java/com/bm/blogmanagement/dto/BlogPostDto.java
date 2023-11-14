package com.bm.blogmanagement.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BlogPostDto {


    private Long id;

    private String title;
    private String content;
    private MultipartFile thumbnail;
}
