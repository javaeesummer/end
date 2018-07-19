package com.rev.judgement.Param;

import java.io.Serializable;

public class AttendorParam implements Serializable {
    int attendorId;
    String endResult;

    public int getAttendorId() {
        return attendorId;
    }

    public void setAttendorId(int attendorId) {
        this.attendorId = attendorId;
    }

    public String getEndResult() {
        return endResult;
    }

    public void setEndResult(String endResult) {
        this.endResult = endResult;
    }
}
