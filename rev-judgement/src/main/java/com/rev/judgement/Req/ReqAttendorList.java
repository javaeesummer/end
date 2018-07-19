package com.rev.judgement.Req;

import java.io.Serializable;

public class ReqAttendorList implements Serializable {
    private Integer attendorid;
//    private Integer activityid;
//    private Integer groupid;
//
//    private Integer reviewid;
//    private String result;
//    private String advice;
//    private Integer judgeid;
    private boolean ifjudged;

//    private Integer worksid;
    private String workname;
//    private String description;
//    private String filepath;


    public Integer getAttendorid() {
        return attendorid;
    }

    public void setAttendorid(Integer attendorid) {
        this.attendorid = attendorid;
    }

    public boolean isIfjudged() {
        return ifjudged;
    }

    public void setIfjudged(boolean ifjudged) {
        this.ifjudged = ifjudged;
    }

    public String getWorkname() {
        return workname;
    }

    public void setWorkname(String workname) {
        this.workname = workname;
    }
}
