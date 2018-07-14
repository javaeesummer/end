package com.rev.judgement.dao;

import com.rev.judgement.entity.judge;

public interface judgeMapper {
    int deleteByPrimaryKey(Integer judgeid);

    int insert(judge record);

    int insertSelective(judge record);

    judge selectByPrimaryKey(Integer judgeid);

    int updateByPrimaryKeySelective(judge record);

    int updateByPrimaryKey(judge record);
}