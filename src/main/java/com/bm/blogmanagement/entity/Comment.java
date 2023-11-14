package com.bm.blogmanagement.entity;



import jakarta.persistence.*;
import lombok.Data;

@Table(name ="tbl_comment")
@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "blog_post_id")
    private BlogPost blogPost;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private Users users;


}
