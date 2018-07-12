package com.rev.revuser.bean;

import java.io.Serializable;

public class judgeBean implements Serializable {
    private Integer judgeid;

    private Integer activityid;

    private Integer jugegroupid;

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

    public Integer getJugegroupid() {
        return jugegroupid;
    }

    public void setJugegroupid(Integer jugegroupid) {
        this.jugegroupid = jugegroupid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}