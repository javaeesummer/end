package com.rev.judgement.bean;

import java.io.Serializable;

public class AttendorInfo implements Serializable {
    private Integer attendorid;

    private Integer activityid;

    private String phonenum;

    private Integer votenum;

    private String endresult;

    private String status;

    private Integer groupid;

    private Integer userid;

    private static final long serialVersionUID = 1L;

    public Integer getAttendorid() {
        return attendorid;
    }

    public void setAttendorid(Integer attendorid) {
        this.attendorid = attendorid;
    }

    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum == null ? null : phonenum.trim();
    }

    public Integer getVotenum() {
        return votenum;
    }

    public void setVotenum(Integer votenum) {
        this.votenum = votenum;
    }

    public String getEndresult() {
        return endresult;
    }

    public void setEndresult(String endresult) {
        this.endresult = endresult == null ? null : endresult.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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