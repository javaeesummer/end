package com.rev.revuser.bean;

import java.io.Serializable;

public class SponsorBean implements Serializable ,Cloneable{
    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    private UserBean userBean;

    private Integer hostid; //主键

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    private Integer userid;

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
        try{
            judgeBean = (SponsorBean) super.clone();
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return judgeBean;
//        return null;
    }
}