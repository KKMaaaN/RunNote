package com.kould.Controller;

import com.kould.Bean.Message;
import com.kould.service.IUserService;
import com.kould.vo.Blog;
import com.kould.vo.Comment;
import com.kould.vo.Crowd;
import com.kould.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUserService userService ;

    @PostMapping("/addUser")
    public Message<String> addUser(User user) {
        this.userService.add(user) ;
        return new Message<>("插入成功","0001") ;
    }

    @PostMapping("/removeUser")
    public Message<String> removeUser(User user) {
        this.userService.remove(user.getId()) ;
        return new Message<>("刪除成功","0002") ;
    }

    @PostMapping("/editUser")
    public Message<String> editUser(User user) {
        this.userService.edit(user) ;
        return new Message<>("修改成功","0003") ;
    }

    @PostMapping("/getUserByUserName")
    public Message<List<User>> getUserByUserName(User user, int index, int stepSize) {
        return new Message<>(this.userService.findByUserName(user.getName(), index ,stepSize),"0004") ;
    }

    @PostMapping("/getUserByUserId")
    public Message<User> getUserByUserId(User user, int index, int stepSize) {
        return new Message<>(this.userService.findByUserId(user.getId(), index, stepSize),"0005") ;
    }

    @PostMapping("/getAllUser")
    public Message<List<User>> getAllUser(int index, int stepSize) {
        return new Message<>(this.userService.allUserList(index, stepSize),"0004") ;
    }

    @PostMapping("/getUserByBlogId")
    public Message<User> getUserByBlogId(Blog blog, int index, int stepSize){
        return new Message<>(this.userService.findByBlogId(blog.getId(), index, stepSize),"0005") ;
    }

    @PostMapping("/getUserByCommentId")
    public Message<User> getUserByCommentId(Comment comment, int index, int stepSize) {
        return new Message<>(this.userService.findByCommentId(comment.getId(), index, stepSize),"0005") ;
    }

    @PostMapping("/getUserByCrowdId")
    public Message<List<User>> getUserByCrowdId(Crowd crowd, int index, int stepSize) {
        return new Message<>(this.userService.findByCrowdId(crowd.getId(), index, stepSize), "0004") ;
    }
}
