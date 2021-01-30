package com.kould.dao;

import com.kould.vo.Blog;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IBlogDAO {
    @Insert("INSERT INTO Blog " +
            "   (id,title,introduction,content,createTime,image)" +
            "   VALUES" +
            "   (#{blog.id}, #{blog.title},#{blog.introduction},#{blog.content}, NOW(),#{blog.image});")
    public int insert(@Param("blog") Blog blog);
    @Delete("DELETE " +
            "FROM Blog " +
            "WHERE id=#{blogId};")
    public int delete(String blogId) ;
    @Update("UPDATE Blog " +
            "SET title=#{blog.title},introduction=#{blog.introduction},content=#{blog.content}," +
                "createTime=now(),image=#{blog.image} " +
            "WHERE id=#{blog.id};")
    public int update(@Param("blog") Blog blog) ;
    @Select("SELECT id,title,introduction,content,createTime,image " +
            "FROM Blog " +
            "WHERE title = #{blogTitle} " +
            "LIMIT #{start},#{stepSize};")
    public List<Blog> selectByBlogTitle(@Param("blogTitle") String blogTitle,@Param("start") int start,
                                        @Param("stepSize") int stepSize) ;
    @Select("SELECT id,title,introduction,content,createTime,image " +
            "FROM Blog " +
            "WHERE id = #{blogId};")
    public Blog selectByBlogId(String blogId) ;
    @Select("SELECT id,title,introduction,content,createTime,image " +
            "FROM Blog " +
            "LIMIT #{start},#{stepSize};")
    public List<Blog> selectOfBlogAll(@Param("start") int start,@Param("stepSize") int stepSize) ;
    @Insert("INSERT INTO BlogAndUser " +
            "   (Blog_id,User_id) " +
            "   VALUES " +
            "   (#{blogId},#{userId});")
    public int insertUserDependence(@Param("blogId") String blogId,@Param("userId") String userId) ;
    @Delete("DELETE FROM BlogAndUser WHERE Blog_id=#{blogId} ;")
    public int deleteUserDependence(@Param("blogId") String blogId) ;
    @Select("SELECT Blog.id,Blog.title,Blog.introduction,Blog.content,Blog.createTime,Blog.Image " +
            "FROM Blog " +
            "INNER JOIN BlogAndUser ON BlogAndUser.Blog_id=Blog.id " +
            "WHERE BlogAndUser.User_id = #{userId} " +
            "LIMIT #{start},#{stepSize};")
    public List<Blog> selectByUserId(@Param("userId") String userId,@Param("start") int start,
                                     @Param("stepSize") int stepSize) ;
    @Select("SELECT Blog.id,Blog.title,Blog.introduction,Blog.content,Blog.createTime,Blog.Image " +
            "FROM Blog " +
            "INNER JOIN BlogAndComment ON BlogAndComment.Blog_id=Blog.id " +
            "WHERE BlogAndComment.Comment_id = #{commentId} " +
            "LIMIT #{start},#{stepSize};")
    public Blog selectByCommentId(@Param("commentId") String commentId,@Param("start") int start,
                                  @Param("stepSize") int stepSize) ;
}
