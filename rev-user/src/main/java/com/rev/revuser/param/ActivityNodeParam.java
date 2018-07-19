package com.rev.revuser.param;

/**
 * @author hxs
 * @desprition 用来干嘛的呢, 也就是随便写写的
 **/

public class ActivityNodeParam {
    int activityId;
    int priority;
    String description;//不是必要得
    String startTime; // 可能不是必要得
    String endTime;//　可能不是必要得

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
