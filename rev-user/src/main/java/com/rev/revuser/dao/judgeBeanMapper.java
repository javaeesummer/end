package com.rev.revuser.dao;

import com.rev.revuser.bean.judgeBean;

public interface judgeBeanMapper {
    int deleteByPrimaryKey(Integer judgeid);

    int insert(judgeBean record);

    int insertSelective(judgeBean record);

    judgeBean selectByPrimaryKey(Integer judgeid);

    int updateByPrimaryKeySelective(judgeBean record);

    int updateByPrimaryKey(judgeBean record);
}