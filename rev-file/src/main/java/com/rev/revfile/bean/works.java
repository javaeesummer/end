package com.rev.revfile.bean;

import java.io.Serializable;
import java.util.Date;

public class works implements Serializable {
    private Integer worksId;

    private Integer attendorId;

    private Date submitTime;

    private String filePath;

    private String workName;

    private String description;

    private String fileSize;

    private static final long serialVersionUID = 1L;

    public Integer getWorksid() {
        return worksId;
    }

    public void setWorksid(Integer worksid) {
        this.worksId = worksId;
    }

    public Integer getAttendorid() {
        return attendorId;
    }

    public void setAttendorid(Integer attendorid) {
        this.attendorId = attendorid;
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
        this.filePath = filepath == null ? null : filepath.trim();
    }

    public String getWorkname() {
        return workName;
    }

    public void setWorkname(String workname) {
        this.workName = workname == null ? null : workname.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String size) {
        this.fileSize = fileSize;
    }
}