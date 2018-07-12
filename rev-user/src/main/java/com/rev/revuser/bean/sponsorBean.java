package com.rev.revuser.bean;

import java.io.Serializable;

public class sponsorBean implements Serializable {
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
}