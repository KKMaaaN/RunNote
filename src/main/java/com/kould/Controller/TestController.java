package com.kould.Controller;

import com.kould.dao.ICommentDAO;
import com.kould.service.IBlogService;
import com.kould.service.ICommentService;
import com.kould.service.ICrowdService;
import com.kould.service.IUserService;
import com.kould.vo.Blog;
import com.kould.vo.Comment;
import com.kould.vo.Crowd;
import com.kould.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private IBlogService blogService ;

    @Autowired
    private ICommentService commentService ;

    @Autowired
    private ICrowdService crowdService ;

    @Autowired
    private IUserService userService ;

    @RequestMapping("errorTest")
    public String errorMethod() {
        int result = 10/0 ;
        return "Test";
    }

    @RequestMapping("FindTest")
    public Object findTest() {
        return this.blogService.findByUserId("0f7e9831-a339-447a-a276-13be4bd933a3",1,5) ;
    }
}
