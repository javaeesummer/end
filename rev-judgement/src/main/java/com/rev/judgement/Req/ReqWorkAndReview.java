package com.rev.judgement.Req;

import java.io.Serializable;

public class ReqWorkAndReview implements Serializable {
    private Integer attendorid;
    private Integer reviewid;
    private String result;
    private String advice;
    private String workname;
    private String description;
    private String filepath;

    public Integer getAttendorid() {
        return attendorid;
    }

    public void setAttendorid(Integer attendorid) {
        this.attendorid = attendorid;
    }

    public Integer getReviewid() {
        return reviewid;
    }

    public void setReviewid(Integer reviewid) {
        this.reviewid = reviewid;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
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

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}
