package com.kould.service;

import com.kould.vo.Crowd;

import java.util.List;

public interface ICrowdService {
    public int add(Crowd crowd,String userId) ;
    public int remove(String crowdId,String userId) ;
    public int edit(Crowd crowd) ;
    public Crowd findByCrowdId(String commentId,int index,int stepSize) ;
    public List<Crowd> findByCrowdName(String commentName,int index,int stepSize) ;
    public List<Crowd> allCrowdList(int index,int stepSize) ;

    public List<Crowd> findByUserId(String userId,int index,int stepSize) ;
}
