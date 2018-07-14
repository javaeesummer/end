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

    private Integer hostid;

    private Integer uerid;

    private Integer companyid;

    private static final long serialVersionUID = 1L;

    public Integer getHostid() {
        return hostid;
    }

    public void setHostid(Integer hostid) {
        this.hostid = hostid;
    }

    public Integer getUerid() {
        return uerid;
    }

    public void setUerid(Integer uerid) {
        this.uerid = uerid;
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