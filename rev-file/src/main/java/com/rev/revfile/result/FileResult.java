package com.rev.revfile.result;

import java.io.Serializable;
import java.util.Date;

public class FileResult implements Serializable{
    //参赛者编号id
    private Integer attendorId;
    //作品id
     private Integer worksId;
    //作品名
    private String workName;
    //作品详情
    private String description;
    //作品提交时间
    private Date submitTime;
    //作品下载路径
    private String filePath;
    //作品大小
    private String fileSize;
    public Integer getAttendorid() {
        return attendorId;
    }

    public void setAttendorid(Integer attendorid) {
        this.attendorId = attendorid;
    }

    public Integer getWorksid() {
        return worksId;
    }

    public void setWorksid(Integer worksid) {
        this.worksId = worksid;
    }

    public String getWorkname() {
        return workName;
    }

    public void setWorkname(String workname) {
        this.workName = workname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getSubmittime() {
        return submitTime;
    }

    public void setSubmittime(Date submittime) {
        this.submitTime = submittime;
    }

    public String getFilepath() {
        return filePath;
    }

    public void setFilepath(String filepath) {
        this.filePath = filepath;
    }
    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }
}


