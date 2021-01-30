package com.kould.service;

import com.kould.vo.Blog;

import java.util.List;

public interface IBlogService {
    public int add(Blog blog,String userId) ;
    public int remove(String blogId) ;
    public int edit(Blog blog) ;
    public List<Blog> findByBlogTitle(String blogTitle,int index,int stepSize) ;
    public Blog findByBlogId(String blogId,int index,int stepSize) ;
    public List<Blog> allBlogList(int index,int stepSize) ;

    public List<Blog> findByUserId(String userId,int index,int stepSize) ;
    public Blog findByCommentId(String commentId,int index,int stepSize) ;
}
