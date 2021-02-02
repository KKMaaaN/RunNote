package com.kould.dao;

import com.kould.vo.Crowd;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ICrowdDAO {

    @Insert("INSERT INTO Crowd" +
            "   (id,crowdName,createTime,avatar)" +
            "   VALUES" +
            "   (#{crowd.id},#{crowd.crowdName},NOW(),#{crowd.avatar});")
    public int insert(@Param("crowd") Crowd crowd);
    @Delete("DELETE " +
            "FROM Crowd " +
            "WHERE id=#{crowId};")
    public int delete(String crowdId) ;
    @Update("UPDATE Crowd " +
            "SET crowdName=#{crowd.crowdName},createTime=NOW(),avatar=#{crowd.avatar} " +
            "WHERE id=#{crowd.id};")
    public int update(@Param("crowd") Crowd crowd) ;
    @Select("SELECT id,crowdName,createTime,avatar " +
            "FROM Crowd " +
            "WHERE crowdName=#{crowdName}" +
            "LIMIT #{start},#{stepSize};")
    public List<Crowd> selectByCrowdName(@Param("crowdName") String crowdName,@Param("start") int start,
                                         @Param("stepSize") int stepSize) ;
    @Select("SELECT id,crowdName,createTime,avatar " +
            "FROM Crowd " +
            "WHERE id = #{crowdId};")
    public Crowd selectByCrowdId(String crowdId) ;
    @Select("SELECT id,crowdName,createTime,avatar " +
            "FROM Crowd " +
            "LIMIT #{start},#{stepSize};")
    public List<Crowd> selectOfCrowdAll(@Param("start") int start,@Param("stepSize") int stepSize) ;
    @Insert("INSERT INTO CrowdAndUser " +
            "   (Crowd_id,User_id) " +
            "   VALUES " +
            "   (#{crowdId},#{userId});")
    public int insertUserDependence(@Param("crowdId") String crowdId,@Param("userId") String userId) ;
    @Delete("DELETE FROM CrowdAndUser WHERE Crowd_id=#{crowdId} AND User_id=#{userId};")
    public int deleteUserDependence(@Param("crowdId") String crowdId,@Param("userId") String userId) ;
    @Delete("DELETE FROM CrowdAndUser WHERE Crowd_id=#{crowdId} ;")
    public int deleteAllUserOfOneCrowdDependence(@Param("crowdId") String crowdId) ;
    @Select("SELECT Crowd.id,Crowd.crowdName,Crowd.createTime,Crowd.avatar " +
            "FROM Crowd " +
            "INNER JOIN CrowdAndUser ON CrowdAndUser.Crowd_id=Crowd.id " +
            "WHERE CrowdAndUser.User_id = #{userId} " +
            "LIMIT #{start},#{stepSize};")
    public List<Crowd> selectByUserId(@Param("userId") String userId,@Param("start") int start,
                                      @Param("stepSize") int stepSize) ;
}
