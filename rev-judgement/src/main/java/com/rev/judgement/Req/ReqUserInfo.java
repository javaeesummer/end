package com.rev.judgement.Req;

import java.io.Serializable;

public class ReqUserInfo implements Serializable{
    private Integer attendorId;
    private Integer judgeId;
    private Integer activityId;

    public Integer getAttendorId() {
        return attendorId;
    }

    public void setAttendorId(Integer attendorId) {
        this.attendorId = attendorId;
    }

    public Integer getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(Integer judgeId) {
        this.judgeId = judgeId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }
}
