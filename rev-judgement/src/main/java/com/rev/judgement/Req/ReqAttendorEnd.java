package com.rev.judgement.Req;

import java.io.Serializable;
import java.text.DecimalFormat;

public class ReqAttendorEnd implements Serializable,Comparable<ReqAttendorEnd>{
    private String username;
    private Integer userid;

    private Integer attendorId;
    private Integer votenum;
    private String status;
    private String endResult;

    private String workname;
    private String filepath;
    private String description;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getAttendorId() {
        return attendorId;
    }

    public void setAttendorId(Integer attendorId) {
        this.attendorId = attendorId;
    }

    public Integer getVotenum() {
        return votenum;
    }

    public void setVotenum(Integer votenum) {
        this.votenum = votenum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEndResult() {
        return endResult;
    }

    public void setEndResult(String endResult) {
        this.endResult = endResult;
    }

    public String getWorkname() {
        return workname;
    }

    public void setWorkname(String workname) {
        this.workname = workname;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(ReqAttendorEnd o) {
        double a=Double.parseDouble(o.endResult)-Double.parseDouble(this.endResult);
        if(a>0)
        {
            return 1;
        }
        else if (a==0)
        {
            return 0;
        }
        else
        {
            return -1;
        }
        }
}
