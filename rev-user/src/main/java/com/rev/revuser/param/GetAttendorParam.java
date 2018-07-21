package com.rev.revuser.param;

import java.io.Serializable;

/**
 * @author hxs
 * @desprition 用来干嘛的呢, 也就是随便写写的
 **/

public class GetAttendorParam implements Serializable{
    int activityId;
    int attendorId;
    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getAttendorId() {
        return attendorId;
    }

    public void setAttendorId(int attendorId) {
        this.attendorId = attendorId;
    }

}

