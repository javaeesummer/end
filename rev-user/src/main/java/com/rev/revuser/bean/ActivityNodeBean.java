package com.rev.revuser.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hxs
 * @desprition 用来干嘛的呢, 也就是随便写写的
 **/

public class ActivityNodeBean implements Serializable {
    int activityPointsId;
    int activityId;
    int priority;
    String description;
    Date startTime;
    Date endTime;

    public int getActivityPointsId() {
        return activityPointsId;
    }

    public void setActivityPointsId(int activityPointsId) {
        this.activityPointsId = activityPointsId;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
