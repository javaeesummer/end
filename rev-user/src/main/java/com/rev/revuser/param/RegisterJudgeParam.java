package com.rev.revuser.param;

import java.io.Serializable;

/**
 * @author hxs
 * @desprition 用来干嘛的呢, 也就是随便写写的
 **/

public class RegisterJudgeParam extends RegisterParam implements Serializable{
//    private RegisterParam registerParam;
    private int activityid;
    private String groupName;
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


    public int getActivityid() {
        return activityid;
    }

    public void setActivityid(int activityid) {
        this.activityid = activityid;
    }


}
