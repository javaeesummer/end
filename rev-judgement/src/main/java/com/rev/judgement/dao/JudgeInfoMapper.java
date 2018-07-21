package com.rev.judgement.dao;

import com.rev.judgement.Param.UserParam;
import com.rev.judgement.bean.JudgeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JudgeInfoMapper {
    List<JudgeInfo> getJudgeByUserId(@Param("activityId")int activityId,@Param("userId") int userId);
    int addJudge(JudgeInfo judgeInfo);
    List<JudgeInfo> getJudgeByActivityId(@Param("activityId")int activityId);
}