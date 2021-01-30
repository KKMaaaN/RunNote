package com.kould.dao;

import com.kould.vo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IUserDAO {
    @Insert("INSERT INTO User" +
            "   (id,name,gender,email,phoneNumber,passWord,nationality,introduction,createTime,avatar)" +
            "   VALUES" +
            "   (#{user.id},#{user.name},#{user.gender},#{user.email},#{user.phoneNumber},#{user.passWord}," +
            "       #{user.nationality},#{user.introduction},NOW(),#{user.avatar});")
    public int insert(@Param("user") User user) ;
    @Delete("DELETE " +
            "FROM User " +
            "WHERE id= #{userId};")
    public int delete(String userId) ;
    @Update("UPDATE User " +
            "SET name=#{user.name},gender=#{user.gender},email=#{user.email},phoneNumber=#{user.phoneNumber}," +
                "passWord=#{user.passWord},nationality=#{user.nationality},introduction=#{user.introduction}," +
                "createTime=NOW(),avatar=#{user.avatar} " +
            "WHERE id=#{user.id};")
    public int update(@Param("user") User user) ;
    @Select("SELECT id,name,gender,email,phoneNumber,nationality,introduction,createTime,avatar " +
            "FROM User " +
            "WHERE name = #{userName} " +
            "LIMIT #{start},#{stepSize};")
    public List<User> selectByUserName(@Param("userName") String userName,@Param("start") int start,
                                       @Param("stepSize") int stepSize) ;
    @Select("SELECT id,name,gender,email,phoneNumber,nationality,introduction,createTime,avatar " +
            "FROM User " +
            "WHERE id = #{userId};")
    public User selectByUserId(String userId) ;
    @Select("SELECT id,name,gender,email,phoneNumber,passWord,nationality,introduction,createTime,avatar " +
            "FROM User " +
            "WHERE phoneNumber = #{phoneNumber} AND passWord = #{passWord};")
    public User selectByUserIdOfLogin(@Param("phoneNumber") String phoneNumber,@Param("passWord") String passWord) ;
    @Select("SELECT id,name,gender,email,phoneNumber,nationality,introduction,createTime,avatar " +
            "FROM User " +
            "LIMIT #{start},#{stepSize};")
    public List<User> selectOfUserAll(@Param("start") int start,@Param("stepSize") int stepSize) ;

    @Select("SELECT User.id,User.name,User.gender,User.email,User.phoneNumber," +
                "User.nationality,User.introduction,User.createTime,User.avatar " +
            "FROM User " +
            "INNER JOIN BlogAndUser ON BlogAndUser.User_id=User.id " +
            "WHERE BlogAndUser.Blog_id = #{blogId};")
    public User selectByBlogId(String blogId) ;
    @Select("SELECT User.id,User.name,User.gender,User.email,User.phoneNumber,User.nationality," +
            "   User.introduction,User.createTime,User.avatar " +
            "FROM User " +
            "INNER JOIN CommentAndUser ON CommentAndUser.User_id=User.id " +
            "WHERE CommentAndUser.Comment_id = #{commentId};")
    public User selectByCommentId(String commentId) ;
    @Select("SELECT User.id,User.name,User.gender,User.email,User.phoneNumber,User.nationality," +
            "   User.introduction,User.createTime,User.avatar " +
            "FROM User " +
            "INNER JOIN CrowdAndUser ON CrowdAndUser.User_id=User.id " +
            "WHERE CrowdAndUser.Crowd_id = #{crowdId} " +
            "LIMIT #{start},#{stepSize};")
    public List<User> selectByCrowdId(@Param("crowdId") String crowdId,@Param("start") int start,
                                      @Param("stepSize") int stepSize) ;
}
