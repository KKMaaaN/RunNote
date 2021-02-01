package com.kould.Controller;

import com.kould.Bean.Message;
import com.kould.service.IBlogService;
import com.kould.vo.Blog;
import com.kould.vo.Comment;
import com.kould.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BlogController {
    @Autowired
    private IBlogService blogService ;

    @PostMapping("/addBlog")
    public Message<String> addBlog(Blog blog, User user) {
        this.blogService.add(blog,user.getId()) ;
        return new Message<String>("插入成功","0001") ;
    }

    @PostMapping("/removeBlog")
    public Message<String> removeBlog(Blog blog) {
        this.blogService.remove(blog.getId()) ;
        return new Message<String>("刪除成功","0002") ;
    }

    @PostMapping("/editBlog")
    public Message<String> editBlog(Blog blog) {
        this.blogService.edit(blog) ;
        return new Message<String>("修改成功","0003") ;
    }

    @PostMapping("getBlogByBlogTitle")
    public Message<List<Blog>> getBlogByBlogTitle(Blog blog, int index, int stepSize) {
        return new Message<List<Blog>>(this.blogService.findByBlogTitle(blog.getTitle(),index,stepSize),"0004") ;
    }

    @PostMapping("getBlogByBlogId")
    public Message<Blog> getBlogByBlogId(Blog blog,int index,int stepSize) {
        return new Message<Blog>(this.blogService.findByBlogId(blog.getId(),index,stepSize),"0005") ;
    }

    @PostMapping("getAllBlog")
    public Message<List<Blog>> getBlogOfAll(int index,int stepSize) {
        return new Message<List<Blog>>(this.blogService.allBlogList(index,stepSize),"0004") ;
    }

    @PostMapping("getBlogByUserId")
    public Message<List<Blog>> getBlogByUserId(User user,int index,int stepSize) {
        return new Message<List<Blog>>(this.blogService.findByUserId(user.getId(),index,stepSize),"0004") ;
    }

    @PostMapping("getBlogByCommentId")
    public Message<Blog> getBlogByCommentId(Comment comment, int index, int stepSize) {
        return new Message<Blog>(this.blogService.findByCommentId(comment.getId(),index,stepSize),"0005") ;
    }
}
