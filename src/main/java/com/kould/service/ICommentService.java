package com.kould.service;

import com.kould.vo.Comment;

import java.util.List;

public interface ICommentService {
    public int add(Comment comment,String userId,String blogId) ;
    public int remove(String commentId) ;
    public int edit(Comment comment) ;
    public Comment findByCommentId(String commentId) ;
    public List<Comment> allCommentList(int index,int stepSize) ;

    public List<Comment> findByUserId(String userId,int index,int stepSize) ;
    public List<Comment> findByBlogId(String blogId,int index,int stepSize) ;
}
