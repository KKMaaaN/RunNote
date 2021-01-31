package com.kould.service;

import com.kould.vo.Comment;

import java.util.List;

public interface ICommentService {
    int add(Comment comment,String userId,String blogId) ;
    int remove(String commentId) ;
    int edit(Comment comment) ;
    Comment findByCommentId(String commentId) ;
    List<Comment> allCommentList(int index,int stepSize) ;

    List<Comment> findByUserId(String userId,int index,int stepSize) ;
    List<Comment> findByBlogId(String blogId,int index,int stepSize) ;
}
