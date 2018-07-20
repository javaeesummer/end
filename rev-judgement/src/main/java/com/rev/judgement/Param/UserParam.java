package com.rev.judgement.Param;

import java.io.Serializable;

public class UserParam implements Serializable{
    int userId;
    int activityId;

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
