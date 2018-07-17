package com.rev.judgement.dao;

import com.rev.judgement.bean.JudgeInfo;

public interface JudgeInfoMapper {
    int deleteByPrimaryKey(Integer judgeid);

    int insert(JudgeInfo record);

    int insertSelective(JudgeInfo record);

    JudgeInfo selectByPrimaryKey(Integer judgeid);

    int updateByPrimaryKeySelective(JudgeInfo record);

    int updateByPrimaryKey(JudgeInfo record);
}