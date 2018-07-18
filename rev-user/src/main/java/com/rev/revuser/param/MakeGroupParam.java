package com.rev.revuser.param;

import java.io.Serializable;

/**
 * @author hxs
 * @desprition 用来干嘛的呢, 也就是随便写写的
 **/

public class MakeGroupParam implements Serializable{


    private int activityId;
    private int groupnum;
    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }
    public int getGroupnum() {
        return groupnum;
    }

    public void setGroupnum(int groupnum) {
        this.groupnum = groupnum;
    }


}
