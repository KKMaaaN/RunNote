package com.kould.service.impl;

import com.kould.adapter.IPageAdapter;
import com.kould.dao.ICrowdDAO;
import com.kould.dao.IUserDAO;
import com.kould.service.ICrowdService;
import com.kould.vo.Crowd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrowdServiceImpl implements ICrowdService {
    @Autowired
    private IPageAdapter pageAdapter ;

    @Autowired
    private ICrowdDAO crowdDAO ;

    @Autowired
    private IUserDAO userDAO ;


    @Override
    public int add(Crowd crowd, String userId) {
        this.crowdDAO.insert(crowd) ;
        this.crowdDAO.insertUserDependence(crowd.getId(),userId) ;
        return 1;
    }

    @Override
    public int remove(String crowdId, String userId) {
        this.crowdDAO.deleteUserDependence(crowdId, userId) ;
        this.crowdDAO.delete(crowdId) ;
        return 1;
    }

    @Override
    public int edit(Crowd crowd) {
        return this.crowdDAO.update(crowd);
    }

    @Override
    public Crowd findByCrowdId(String commentId,int index,int stepSize) {
        return setCrowd(this.crowdDAO.selectByCrowdId(commentId), index, stepSize);
    }

    @Override
    public List<Crowd> findByCrowdName(String commentName,int index,int stepSize) {
        return setCrows(this.crowdDAO.selectByCrowdName(commentName,pageAdapter.indexBeStart(index, stepSize),stepSize),
                index, stepSize);
    }

    @Override
    public List<Crowd> allCrowdList(int index,int stepSize) {
        return setCrows(this.crowdDAO.selectOfCrowdAll(pageAdapter.indexBeStart(index, stepSize),stepSize),
                index, stepSize);
    }

    @Override
    public List<Crowd> findByUserId(String userId, int index, int stepSize) {
        return setCrows(this.crowdDAO.selectByUserId(userId,pageAdapter.indexBeStart(index, stepSize),stepSize),
                index, stepSize);
    }

    private List<Crowd> setCrows(List<Crowd> groups,int index,int stepSize) {
        for (int i = 0;i<=groups.size()-1;i++) {
            Crowd crowd = groups.get(i) ;
            crowd.setUsers(this.userDAO.selectByCrowdId(crowd.getId(),pageAdapter.indexBeStart(index, stepSize),
                    stepSize));
            groups.set(i,crowd) ;
        }
        return groups ;
    }

    private Crowd setCrowd(Crowd crowd,int index,int stepSize) {
        crowd.setUsers(this.userDAO.selectByCrowdId(crowd.getId(),pageAdapter.indexBeStart(index, stepSize),
                stepSize));
        return crowd ;
    }
}
