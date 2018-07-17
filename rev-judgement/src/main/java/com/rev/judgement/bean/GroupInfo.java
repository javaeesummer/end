package com.rev.judgement.bean;

import java.io.Serializable;

public class GroupInfo implements Serializable {
    private Integer groupid;

    private Integer activityid;

    private String groupname;

    private static final long serialVersionUID = 1L;

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname == null ? null : groupname.trim();
    }
}