package com.kould.service;

import com.kould.vo.User;

import java.util.List;

public interface IUserService {
    public int add(User user) ;
    public int remove(String userId) ;
    public int edit(User user) ;
    public List<User> findByUserName(String userName,int index,int stepSize) ;
    public User findByUserId(String userId,int index,int stepSize) ;
    public User loginCheck(String phoneNumber,String passWord) ;
    public List<User> allUserList(int index,int stepSize) ;

    public User findByBlogId(String blogId,int index,int stepSize) ;
    public User findByCommentId(String commentId,int index,int stepSize) ;
    public List<User> findByCrowdId(String crowdId,int index,int stepSize) ;
}
