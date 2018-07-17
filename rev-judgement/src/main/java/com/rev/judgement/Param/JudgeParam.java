package com.rev.judgement.Param;

import com.rev.judgement.bean.ReviewInfo;

public class JudgeParam {
    int judgeId;
    int activityId;
    int attendorId;
    int groupId;
    ReviewInfo reviewInfo;

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

    public ReviewInfo getReviewInfo() {
        return reviewInfo;
    }

    public void setReviewInfo(ReviewInfo reviewInfo) {
        this.reviewInfo = reviewInfo;
    }
}
