package com.bm.blogmanagement.entity;



import jakarta.persistence.*;
import lombok.Data;


import java.util.List;
@Table(name = "tbl_blog_post")
@Entity
@Data
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "blogPost")
    private List<Comment> comments;

    @Lob
    private byte[] thumbnail;


}

