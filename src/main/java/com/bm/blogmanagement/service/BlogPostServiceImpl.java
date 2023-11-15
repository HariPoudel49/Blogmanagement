package com.bm.blogmanagement.service;

import com.bm.blogmanagement.config.AuthorizedUser;
import com.bm.blogmanagement.dto.BlogPostDto;
import com.bm.blogmanagement.dto.CommentDto;
import com.bm.blogmanagement.entity.BlogPost;
import com.bm.blogmanagement.entity.Comment;
import com.bm.blogmanagement.repo.BlogPostRepo;
import com.bm.blogmanagement.repo.CommentRepo;
import jakarta.transaction.Transactional;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class BlogPostServiceImpl implements BlogPostService {

    private final BlogPostRepo blogPostRepo;
    private final CommentRepo commentRepo;

    public BlogPostServiceImpl(BlogPostRepo blogPostRepo, CommentRepo commentRepo) {
        this.blogPostRepo = blogPostRepo;
        this.commentRepo = commentRepo;
    }


    @Override
    public BlogPostDto addBlogPost(BlogPostDto blogPostDto) {

        BlogPost blogPost = new BlogPost();
        blogPost.setId(blogPostDto.getId());
        blogPost.setTitle(blogPostDto.getTitle());
        blogPost.setContent(blogPostDto.getContent());
        try {
            blogPost.setThumbnailImageUrl(saveImage(blogPostDto.getThumbnail()));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        blogPost.setUsers(AuthorizedUser.getUsers());
        blogPostRepo.save(blogPost);
        blogPostDto.setThumbnail(null);
        return blogPostDto;

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
        comment.setUsers(AuthorizedUser.getUsers());
        commentRepo.save(comment);

        return commentDto;

    }

    @Override
    @Transactional //use to roll back in case of Exception
    public String deleteComment(Integer commentId) {
        try {
            commentRepo.deleteCommentById(commentId);
            return "Comment Deleted Successfully..!";
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    private String saveImage(MultipartFile image) throws IOException {
        String fileDir = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "blog";
        File path = new File(fileDir);
        if (!path.exists()) {
            path.mkdirs();
        }
        String filePath;
        String ext = FilenameUtils.getExtension(image.getOriginalFilename());
        assert ext != null;
        if (ext.equalsIgnoreCase("jpg") ||
                ext.equalsIgnoreCase("png") ||
                ext.equalsIgnoreCase("jpeg")) {
            UUID uuid = UUID.randomUUID();
            filePath = fileDir + File.separator + uuid + "-" + image.getOriginalFilename();
            File newFile = new File(filePath);
            image.transferTo(newFile);
        } else {
            throw new RuntimeException("Invalid file");
        }
        return filePath;
    }
}
