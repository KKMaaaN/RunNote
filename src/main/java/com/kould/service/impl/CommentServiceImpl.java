package com.kould.service.impl;

import com.kould.adapter.IPageAdapter;
import com.kould.dao.IBlogDAO;
import com.kould.dao.ICommentDAO;
import com.kould.dao.IUserDAO;
import com.kould.service.ICommentService;
import com.kould.vo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private IPageAdapter pageAdapter ;
    @Autowired
    private ICommentDAO commentDAO ;

    @Autowired
    private IUserDAO userDAO ;

    @Autowired
    private IBlogDAO blogDAO ;


    @Override
    public int add(Comment comment, String userId, String blogId) {
        this.commentDAO.insert(comment) ;
        this.commentDAO.insertUserDependence(comment.getId(),userId) ;
        this.commentDAO.insertBlogDependence(comment.getId(),blogId) ;
        return 1 ;
    }

    @Override
    public int remove(String commentId) {
        this.commentDAO.deleteUserDependence(commentId) ;
        this.commentDAO.deleteBlogDependence(commentId) ;
        this.commentDAO.delete(commentId) ;
        return 1 ;
    }

    @Override
    public int edit(Comment comment) {
        return this.commentDAO.update(comment);
    }

    @Override
    public Comment findByCommentId(String commentId) {
        return setComment(this.commentDAO.selectByCommentId(commentId));
    }

    @Override
    public List<Comment> allCommentList(int index,int stepSize) {
        return setComments(this.commentDAO.selectOfCommentAll(pageAdapter.indexBeStart(index,stepSize),stepSize),
                index,stepSize) ;
    }

    @Override
    public List<Comment> findByUserId(String userId,int index,int stepSize) {
        return setComments(this.commentDAO.selectByUserId(userId,pageAdapter.indexBeStart(index, stepSize),stepSize),
                index,stepSize) ;
    }

    @Override
    public List<Comment> findByBlogId(String blogId,int index,int stepSize) {
        return setComments(this.commentDAO.selectByBlogId(blogId,pageAdapter.indexBeStart(index, stepSize),stepSize),
                index,stepSize);
    }

    private List<Comment> setComments(List<Comment> comments,int index,int stepSize) {
        for (int i = 0;i<=comments.size()-1;i++) {
            Comment comment = comments.get(i) ;
            comment.setOwner(this.userDAO.selectByBlogId(comment.getId())) ;
            comment.setBlog(this.blogDAO.selectByCommentId(comment.getId(),pageAdapter.indexBeStart(index, stepSize),
                    stepSize));
            comments.set(i,comment) ;
        }
        return comments ;
    }

    private Comment setComment(Comment comment) {
        comment.setOwner(this.userDAO.selectByBlogId(comment.getId())) ;
        comment.setBlog(this.blogDAO.selectByCommentId(comment.getId(),0,0));
        return comment ;
    }
}
