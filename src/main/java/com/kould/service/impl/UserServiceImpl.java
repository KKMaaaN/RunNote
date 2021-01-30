package com.kould.service.impl;

import com.kould.adapter.IPageAdapter;
import com.kould.dao.IBlogDAO;
import com.kould.dao.ICommentDAO;
import com.kould.dao.ICrowdDAO;
import com.kould.dao.IUserDAO;
import com.kould.service.IUserService;
import com.kould.vo.Blog;
import com.kould.vo.Comment;
import com.kould.vo.Crowd;
import com.kould.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IPageAdapter pageAdapter ;

    @Autowired
    private IUserDAO userDAO ;

    @Autowired
    private IBlogDAO blogDAO ;

    @Autowired
    private ICommentDAO commentDAO ;

    @Autowired
    private ICrowdDAO crowdDAO ;

    @Override
    public int add(User user) {
        return this.userDAO.insert(user);
    }

    @Override
    public int remove(String userId) {
        List<Blog> blogs = this.blogDAO.selectByUserId(userId,0,-1) ;
        List<Comment> comments = this.commentDAO.selectByUserId(userId,0,-1) ;
        List<Crowd> groups = this.crowdDAO.selectByUserId(userId,0,-1) ;
        for (Blog blog : blogs) {
            this.blogDAO.deleteUserDependence(blog.getId()) ;
            this.blogDAO.insertUserDependence(blog.getId(),"") ;
        }
        for (Comment comment : comments) {
            this.commentDAO.deleteUserDependence(comment.getId()) ;
            this.commentDAO.insertUserDependence(comment.getId(),"") ;
        }
        for (Crowd group : groups) {
            this.crowdDAO.deleteUserDependence(group.getId(),userId) ;
        }
        return this.userDAO.delete(userId);
    }

    @Override
    public int edit(User user) {
        return this.userDAO.update(user);
    }

    @Override
    public List<User> findByUserName(String userName, int index, int stepSize) {
        return this.userDAO.selectByUserName(userName,pageAdapter.indexBeStart(index, stepSize),stepSize);
    }

    @Override
    public User findByUserId(String userId, int index, int stepSize) {
        return setUser(this.userDAO.selectByUserId(userId),index,stepSize);
    }

    @Override
    public User loginCheck(String phoneNumber,String passWord) {
        return this.userDAO.selectByUserIdOfLogin(phoneNumber,passWord);
    }

    @Override
    public List<User> allUserList(int index, int stepSize) {
        return this.userDAO.selectOfUserAll(index, stepSize);
    }

    @Override
    public User findByBlogId(String blogId, int index, int stepSize) {
        return setUser(this.userDAO.selectByBlogId(blogId),index,stepSize);
    }

    @Override
    public User findByCommentId(String commentId, int index, int stepSize) {
        return setUser(this.userDAO.selectByCommentId(commentId),index,stepSize);
    }

    @Override
    public List<User> findByCrowdId(String crowdId,int index,int stepSize) {
        return setUsers(this.userDAO.selectByCrowdId(crowdId,pageAdapter.indexBeStart(index, stepSize), stepSize),
                index,stepSize);
    }

    private List<User> setUsers(List<User> users,int index,int stepSize) {
        for (int i = 0;i<=users.size()-1;i++) {
            User user = users.get(i) ;
            user.setBlogs(this.blogDAO.selectByUserId(user.getId(),pageAdapter.indexBeStart(index, stepSize),
                    stepSize)) ;
            user.setComments(this.commentDAO.selectByUserId(user.getId(),pageAdapter.indexBeStart(index, stepSize),
                    stepSize)) ;
            user.setGroups(this.crowdDAO.selectByUserId(user.getId(),pageAdapter.indexBeStart(index, stepSize),
                    stepSize)) ;
            users.set(i,user) ;
        }
        return users ;
    }

    private User setUser(User user,int index,int stepSize) {
        user.setBlogs(this.blogDAO.selectByUserId(user.getId(),pageAdapter.indexBeStart(index, stepSize),
                stepSize)) ;
        user.setComments(this.commentDAO.selectByUserId(user.getId(),pageAdapter.indexBeStart(index, stepSize),
                stepSize)) ;
        user.setGroups(this.crowdDAO.selectByUserId(user.getId(),pageAdapter.indexBeStart(index, stepSize),
                stepSize)) ;
        return user ;
    }
}
