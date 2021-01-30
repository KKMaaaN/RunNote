package com.kould.dao;

import com.kould.vo.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ICommentDAO {
    @Insert("INSERT INTO Comment" +
            "   (id,content,createTime)" +
            "   VALUES" +
            "   (#{comment.id}, #{comment.content}, NOW());")
    public int insert(@Param("comment") Comment comment);
    @Delete("DELETE " +
            "FROM Comment " +
            "WHERE id=#{commentId};")
    public int delete(String commentId) ;
    @Update("UPDATE Comment " +
            "SET content=#{comment.content},createTime=NOW() " +
            "WHERE id=#{comment.id};")
    public int update(@Param("comment") Comment comment) ;
    @Select("SELECT id,content,createTime " +
            "FROM Comment " +
            "WHERE id = #{commentId};")
    public Comment selectByCommentId(String commentId) ;
    @Select("SELECT id,content,createTime " +
            "FROM Comment " +
            "LIMIT #{start},#{stepSize};")
    public List<Comment> selectOfCommentAll(@Param("start") int start,@Param("stepSize") int stepSize) ;
    @Insert("INSERT INTO CommentAndUser " +
            "   (Comment_id,User_id) " +
            "   VALUES " +
            "   (#{commentId},#{userId});")
    public int insertUserDependence(@Param("commentId") String commentId,@Param("userId") String userId) ;
    @Insert("INSERT INTO BlogAndComment " +
            "   (Comment_id,Blog_id) " +
            "   VALUES " +
            "   (#{commentId},#{blogId});")
    public int insertBlogDependence(@Param("commentId") String commentId,@Param("blogId") String blogId) ;
    @Delete("DELETE FROM CommentAndUser WHERE Comment_id=#{commentId} ;")
    public int deleteUserDependence(@Param("commentId") String commentId) ;
    @Delete("DELETE FROM BlogAndComment WHERE Comment_id=#{commentId} ;")
    public int deleteBlogDependence(@Param("commentId") String commentId) ;
    @Select("SELECT Comment.id,Comment.content,Comment.createTime " +
            "FROM Comment " +
            "INNER JOIN CommentAndUser ON CommentAndUser.Comment_id=Comment.id " +
            "WHERE CommentAndUser.User_id = #{userId} " +
            "LIMIT #{start},#{stepSize};")
    public List<Comment> selectByUserId(@Param("userId") String userId,@Param("start") int start,
                                        @Param("stepSize") int stepSize) ;
    @Select("SELECT Comment.id,Comment.content,Comment.createTime " +
            "FROM Comment " +
            "INNER JOIN BlogAndComment ON BlogAndComment.Comment_id=Comment.id " +
            "WHERE BlogAndComment.Blog_id = #{blogId} " +
            "LIMIT #{start},#{stepSize};")
    public List<Comment> selectByBlogId(@Param("blogId") String blogId,@Param("start") int start,
                                        @Param("stepSize") int stepSize) ;
}
