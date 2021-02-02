package com.kould.Controller;

import com.kould.Bean.Message;
import com.kould.service.ICrowdService;
import com.kould.vo.Blog;
import com.kould.vo.Comment;
import com.kould.vo.Crowd;
import com.kould.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {
    @Autowired
    private ICrowdService crowdService ;

    @PostMapping("/addGroup")
    public Message<String> addGroup(Crowd crowd, User user) {
        this.crowdService.add(crowd, user.getId()) ;
        return new Message<>("插入成功","0001") ;
    }

    @PostMapping("/removeGroup")
    public Message<String> removeGroup(Crowd crowd) {
        this.crowdService.remove(crowd.getId()) ;
        return new Message<>("刪除成功","0002") ;
    }

    @PostMapping("editGroup")
    public Message<String> editGroup(Crowd crowd) {
        this.crowdService.edit(crowd) ;
        return new Message<>("修改成功","0003") ;
    }

    @PostMapping("/getGroupByGroupId")
    public Message<Crowd> findByGroupId(Crowd crowd, int index, int stepSize) {
        return new Message<>(this.crowdService.findByCrowdId(crowd.getId(), index, stepSize),"0005") ;
    }

    @PostMapping("/getGroupByGroupName")
    public Message<List<Crowd>> findByGroupName(Crowd crowd, int index, int stepSize) {
        return new Message<>(this.crowdService.findByCrowdName(crowd.getCrowdName(), index, stepSize),"0004") ;
    }

    @PostMapping("/getAllGroup")
    public Message<List<Crowd>> findAllGroup(int index, int stepSize) {
        return new Message<>(this.crowdService.allCrowdList(index, stepSize),"0005") ;
    }

    @PostMapping("/joinTheGroup")
    public Message<String> joinTheGroup(Crowd crowd, User user) {
        this.crowdService.addUserOfCrowd(crowd.getId(), user.getId()) ;
        return new Message<>("加入組成功","0001") ;
    }

    @PostMapping("quitTheGroup")
    public Message<String> quitTheGroup(Crowd crowd, User user) {
        this.crowdService.removeUserOfCrowd(crowd.getId(),user.getId()) ;
        return new Message<>("退出組成功","0002") ;
    }

    @PostMapping("getGroupByUserId")
    public Message<List<Crowd>> getGroupByUserId(User user, int index, int stepSize) {
        return new Message<>(this.crowdService.findByUserId(user.getId(), index, stepSize),"004") ;
    }
}
