package com.rev.judgement.Param;

import com.rev.judgement.bean.ReviewInfo;

import java.io.Serializable;

public class JudgeParam implements Serializable {
    int judgeId;
    int activityId;
    int attendorId;
    int groupId;
    String result;
    String advice;
    int reviewId;

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

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(int judgeId) {
        this.judgeId = judgeId;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getAttendorId() {
        return attendorId;
    }

    public void setAttendorId(int attendorId) {
        this.attendorId = attendorId;
    }

}
