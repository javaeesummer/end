package com.rev.revuser.bean;

import java.io.Serializable;

public class JudgeBean implements Serializable ,Cloneable{
    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    private UserBean userBean;
    private Integer judgeid;

    private Integer activityid;

    private Integer judgegroupid;

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
        return judgegroupid;
    }

    public void setJugegroupid(Integer jugegroupid) {
        this.judgegroupid = jugegroupid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    @Override
    public Object clone() {
        JudgeBean judgeBean = null;
        try{
            judgeBean = (JudgeBean) super.clone();
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return judgeBean;
//        return null;
    }
}