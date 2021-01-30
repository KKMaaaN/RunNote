package com.kould.service.impl;

import com.kould.adapter.IPageAdapter;
import com.kould.dao.IBlogDAO;
import com.kould.dao.ICommentDAO;
import com.kould.dao.IUserDAO;
import com.kould.service.IBlogService;
import com.kould.vo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IPageAdapter pageAdapter ;

    @Autowired
    private IBlogDAO blogDAO ;

    @Autowired
    private ICommentDAO commentDAO ;

    @Autowired
    private IUserDAO userDAO ;

    @Override
    public int add(Blog blog,String userId) {
        this.blogDAO.insert(blog) ;
        this.blogDAO.insertUserDependence(blog.getId(),userId) ;
        return 1 ;
    }

    @Override
    public int remove(String blogId) {
        this.blogDAO.deleteUserDependence(blogId) ;
        this.blogDAO.delete(blogId) ;
        return 1 ;
    }

    @Override
    public int edit(Blog blog) {
        return this.blogDAO.update(blog);
    }

    @Override
    public List<Blog> findByBlogTitle(String blogTitle,int index,int stepSize) {
        return setBlogs(this.blogDAO.selectByBlogTitle(blogTitle,pageAdapter.indexBeStart(index,stepSize), stepSize),
                index,stepSize);
    }

    @Override
    public Blog findByBlogId(String blogId,int index,int stepSize) {
        return setBlog(this.blogDAO.selectByBlogId(blogId),index,stepSize) ;
    }

    @Override
    public List<Blog> allBlogList(int index,int stepSize) {
        return setBlogs(this.blogDAO.selectOfBlogAll(pageAdapter.indexBeStart(index,stepSize),stepSize),
                index,stepSize);
    }

    @Override
    public List<Blog> findByUserId(String userId,int index,int stepSize) {
         return setBlogs(this.blogDAO.selectByUserId(userId,pageAdapter.indexBeStart(index,stepSize), stepSize),
                 index,stepSize) ;
    }

    @Override
    public Blog findByCommentId(String commentId,int index,int stepSize) {
        return setBlog(this.blogDAO.selectByCommentId(commentId,pageAdapter.indexBeStart(index,stepSize), stepSize),
                index,stepSize) ;
    }

    private List<Blog> setBlogs(List<Blog> blogs,int index,int stepSize) {
        for (int i = 0;i<=blogs.size()-1;i++) {
            Blog blog = blogs.get(i) ;
            blog.setOwner(this.userDAO.selectByBlogId(blog.getId())) ;
            blog.setComments(this.commentDAO.selectByBlogId(blog.getId(),pageAdapter.indexBeStart(index, stepSize),
                    stepSize)) ;
            blogs.set(i,blog) ;
        }
        return blogs ;
    }

    private Blog setBlog(Blog blog,int index,int stepSize) {
        blog.setOwner(this.userDAO.selectByBlogId(blog.getId()));
        blog.setComments(this.commentDAO.selectByBlogId(blog.getId(),pageAdapter.indexBeStart(index, stepSize),
                stepSize));
        return blog ;
    }
}
