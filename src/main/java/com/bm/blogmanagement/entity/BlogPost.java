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

    @Column(name = "thumbnail_image_url")
    private String thumbnailImageUrl;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "blogPost")
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private Users users;

}

