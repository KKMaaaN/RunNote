package com.kould.service;

import com.kould.vo.Blog;

import java.util.List;

public interface IBlogService {
    int add(Blog blog,String userId) ;
    int remove(String blogId) ;
    int edit(Blog blog) ;
    List<Blog> findByBlogTitle(String blogTitle,int index,int stepSize) ;
    Blog findByBlogId(String blogId,int index,int stepSize) ;
    List<Blog> allBlogList(int index,int stepSize) ;

    List<Blog> findByUserId(String userId,int index,int stepSize) ;
    Blog findByCommentId(String commentId,int index,int stepSize) ;
}
