package com.kould.Controller;

import com.kould.service.IBlogService;
import com.kould.vo.Blog;
import com.kould.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//public class BlogController {
//    @Autowired
//    private IBlogService blogService ;
//
//    @PostMapping("/addBlog")
//    public Object addBlog(Blog blog, User user) {
//        this.blogService.add(blog,user.getId()) ;
//    }
//
//    public Object removeBlog() {
//
//    }
//
//    public Object editBlog() {
//
//    }
//
//    public Object getBlogByBlogTitle() {
//
//    }
//
//    public Object getBlogByBlogId() {
//
//    }
//
//    public Object getBlogOfAll() {
//
//    }
//
//    public Object getBlogByUserId() {
//
//    }
//
//    public Object getBlogByCommentId() {
//
//    }
//}
