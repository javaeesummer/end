package com.rev.judgement.bean;

import java.io.Serializable;

public class JudgeInfo implements Serializable {
    private Integer judgeid;

    private Integer activityid;

    private Integer groupid;

    private Integer userid;

    private static final long serialVersionUID = 1L;

    public Integer getJudgeid() {
        return judgeid;
    }

    public void setJudgeid(Integer judgeid) {
        this.judgeid = judgeid;
    }

    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}