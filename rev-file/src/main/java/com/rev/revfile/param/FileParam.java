package com.rev.revfile.param;

import java.io.Serializable;
import java.util.Date;

public class FileParam implements Serializable {
//    //作品id
//    private Integer worksid;
    //参赛者id
    private Integer attendorid;
    //参赛者作品提交时间
    private Date submittime;
    //参赛者作品提交路径
    private String filepath;
    //参赛者提交作品名
    private String workname;
    //参赛者作品详情描述
    private String description;

//    public Integer getWorksid() {
//        return worksid;
//    }
//
//    public void setWorksid(Integer worksid) {
//        this.worksid = worksid;
//    }


    public Date getSubmittime() {
        return submittime;
    }

    public void setSubmittime(Date submittime) {
        this.submittime = submittime;
    }

    public Integer getAttendorid() {
        return attendorid;
    }

    public void setAttendorid(Integer attendorid) {
        this.attendorid = attendorid;
    }


    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getWorkname() {
        return workname;
    }

    public void setWorkname(String workname) {
        this.workname = workname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
