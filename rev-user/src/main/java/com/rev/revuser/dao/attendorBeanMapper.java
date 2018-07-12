package com.rev.revuser.dao;

import com.rev.revuser.bean.attendorBean;

public interface attendorBeanMapper {
    int deleteByPrimaryKey(Integer attendorid);

    int insert(attendorBean record);

    int insertSelective(attendorBean record);

    attendorBean selectByPrimaryKey(Integer attendorid);

    int updateByPrimaryKeySelective(attendorBean record);

    int updateByPrimaryKey(attendorBean record);
}