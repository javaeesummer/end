package com.rev.judgement.bean;

import java.io.Serializable;
import java.util.Date;

public class ActivityInfo implements Serializable {
    private Integer activityid;

    private Integer hostid;

    private String activityname;

    private String description;

    private Date starttime;

    private Date endtime;

    private Integer conutstatus;

    private Integer totalcount;

    private static final long serialVersionUID = 1L;

    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    public Integer getHostid() {
        return hostid;
    }

    public void setHostid(Integer hostid) {
        this.hostid = hostid;
    }

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname == null ? null : activityname.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getConutstatus() {
        return conutstatus;
    }

    public void setConutstatus(Integer conutstatus) {
        this.conutstatus = conutstatus;
    }

    public Integer getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(Integer totalcount) {
        this.totalcount = totalcount;
    }
}