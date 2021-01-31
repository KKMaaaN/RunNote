package com.kould.service;

import com.kould.vo.User;

import java.util.List;

public interface IUserService {
    int add(User user) ;
    int remove(String userId) ;
    int edit(User user) ;
    List<User> findByUserName(String userName,int index,int stepSize) ;
    User findByUserId(String userId,int index,int stepSize) ;
    List<User> allUserList(int index,int stepSize) ;

    User findByBlogId(String blogId,int index,int stepSize) ;
    User findByCommentId(String icommentId,int index,int stepSize) ;
    List<User> findByCrowdId(String crowdId,int index,int stepSize) ;
}
