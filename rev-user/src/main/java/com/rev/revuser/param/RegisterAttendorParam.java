package com.rev.revuser.param;

import com.rev.revuser.bean.AttendorBean;
import com.rev.revuser.bean.JudgeBean;

import java.io.Serializable;

/**
 * @author hxs
 * @desprition 用来干嘛的呢, 也就是随便写写的
 **/

public class RegisterAttendorParam implements Serializable {


    private Integer userId;
    private Integer activityId;
    private String phoneNum;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }
}
