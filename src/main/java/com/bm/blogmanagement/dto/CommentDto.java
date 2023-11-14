package com.bm.blogmanagement.dto;

import lombok.Data;

@Data
public class CommentDto {

    private Long blogPostId;

    private String commentContent;
}
