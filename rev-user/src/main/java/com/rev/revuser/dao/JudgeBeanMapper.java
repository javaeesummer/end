package com.rev.revuser.dao;

import com.rev.revuser.bean.JudgeBean;

public interface JudgeBeanMapper {
    int deleteByPrimaryKey(Integer judgeid);

    int insert(JudgeBean record);

    int insertSelective(JudgeBean record);

    JudgeBean selectByPrimaryKey(Integer judgeid);

    int updateByPrimaryKeySelective(JudgeBean record);

    int updateByPrimaryKey(JudgeBean record);
}