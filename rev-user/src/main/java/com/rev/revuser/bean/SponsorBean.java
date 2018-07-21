package com.rev.revuser.bean;

import java.io.Serializable;

public class SponsorBean extends UserBean{

    private Integer hostid; //主键

    private Integer companyid;

    private Integer activityId;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private static final long serialVersionUID = 1L;

    public Integer getHostid() {
        return hostid;
    }

    public void setHostid(Integer hostid) {
        this.hostid = hostid;
    }



    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }
    @Override
    public Object clone() {
        SponsorBean judgeBean = null;
        judgeBean = (SponsorBean) super.clone();
        return judgeBean;
//        return null;
    }
}