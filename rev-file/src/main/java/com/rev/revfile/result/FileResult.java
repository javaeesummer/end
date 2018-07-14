package com.rev.revfile.result;

import java.io.Serializable;
import java.util.Date;

public class FileResult implements Serializable{
//    //参赛者编号id
//    private Integer attendorid;
    //作品名
    private String workname;
    //作品详情
    private String description;
    //作品提交时间
    private Date submittime;
    //作品下载路径
    private String filepath;

//    public Integer getAttendorid() {
//        return attendorid;
//    }
//
//    public void setAttendorid(Integer attendorid) {
//        this.attendorid = attendorid;
//    }

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

    public Date getSubmittime() {
        return submittime;
    }

    public void setSubmittime(Date submittime) {
        this.submittime = submittime;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}
