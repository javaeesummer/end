package com.rev.judgement.dao;

import com.rev.judgement.bean.ActivityInfo;

public interface ActivityInfoMapper {
    int deleteByPrimaryKey(Integer activityid);

    int insert(ActivityInfo record);

    int insertSelective(ActivityInfo record);

    ActivityInfo selectByPrimaryKey(Integer activityid);

    int updateByPrimaryKeySelective(ActivityInfo record);

    int updateByPrimaryKey(ActivityInfo record);
}