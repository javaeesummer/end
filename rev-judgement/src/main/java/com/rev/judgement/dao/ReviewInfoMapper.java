package com.rev.judgement.dao;

import com.rev.judgement.bean.ReviewInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReviewInfoMapper {
    List<ReviewInfo> getReviewByJudgeId(@Param("judgeId") int judgeId);
    List<ReviewInfo> getReviewByAttendorId(@Param("attendorId") int attendorId);
    int addReview(ReviewInfo reviewInfo);
    int modifyReview(ReviewInfo reviewInfo);
}