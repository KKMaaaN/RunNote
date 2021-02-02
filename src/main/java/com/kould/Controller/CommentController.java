package com.kould.Controller;

import com.kould.Bean.Message;
import com.kould.service.ICommentService;
import com.kould.vo.Blog;
import com.kould.vo.Comment;
import com.kould.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private ICommentService commentService ;

    @PostMapping("/addComment")
    public Message<String> addComment(Comment comment, User user, Blog blog) {
        this.commentService.add(comment,user.getId(),blog.getId()) ;
        return new Message<String>("插入成功","0001") ;
    }

    @PostMapping("/removeComment")
    public Message<String> removeComment(Comment comment) {
        this.commentService.remove(comment.getId()) ;
        return new Message<>("刪除成功","0002") ;
    }

    @PostMapping("/editComment")
    public Message<String> editComment(Comment comment) {
        this.commentService.edit(comment) ;
        return new Message<>("修改成功","0003") ;
    }

    @PostMapping("/getCommentByCommentId")
    public Message<Comment> findByCommentId(Comment comment) {
        return new Message<>(this.commentService.findByCommentId(comment.getId()),"0005") ;
    }

    @PostMapping("/getAllComment")
    public Message<List<Comment>> findAllComment(int index, int stepSize) {
        return new Message<>(this.commentService.allCommentList(index,stepSize),"0004") ;
    }

    @PostMapping("/getCommentByUserId")
    public Message<List<Comment>> findByUserId(User user, int index, int stepSize) {
        return new Message<>(this.commentService.findByUserId(user.getId(),index,stepSize), "0004") ;
    }

    @PostMapping("getCommentByBlogId")
    public Message<List<Comment>> findByBlogId(Blog blog, int index, int stepSize) {
        return new Message<>(this.commentService.findByBlogId(blog.getId(),index,stepSize),"0004") ;
    }
}
