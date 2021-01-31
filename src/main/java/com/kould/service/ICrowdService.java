package com.kould.service;

import com.kould.vo.Crowd;

import java.util.List;

public interface ICrowdService {
    int add(Crowd crowd,String userId) ;
    int remove(String crowdId,String userId) ;
    int edit(Crowd crowd) ;
    Crowd findByCrowdId(String commentId,int index,int stepSize) ;
    List<Crowd> findByCrowdName(String commentName,int index,int stepSize) ;
    List<Crowd> allCrowdList(int index,int stepSize) ;

    List<Crowd> findByUserId(String userId,int index,int stepSize) ;
}
