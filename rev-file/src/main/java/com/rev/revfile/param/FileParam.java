package com.rev.revfile.param;

import java.io.Serializable;
import java.util.Date;

public class FileParam implements Serializable {
//    //作品id
//    private Integer worksId;
   // 参赛者id
    private Integer attendorId;
    //参赛者作品提交时间
    private Date submitTime;
    //参赛者作品提交路径
    private String filePath;
    //参赛者提交作品名
    private String workName;
    //参赛者作品详情描述
    private String description;
    //文件大小
    private String filesize;
    //文件名
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getAttendorid(){
        return attendorId;
    }

    public void setAttendorid(Integer attendorid) {
        this.attendorId = attendorid;
    }

    public String getFileSize() {
        return filesize;
    }

    public void setFileSize(String fileSize) {
        this.filesize = fileSize;
    }

//    public Integer getWorksid() {
//        return worksId;
//    }
//
//    public void setWorksid(Integer worksid) {
//        this.worksId = worksid;
//    }

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

}
