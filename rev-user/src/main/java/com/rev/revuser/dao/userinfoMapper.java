package com.rev.revuser.dao;

import com.rev.revuser.entity.userinfo;

public interface userinfoMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(userinfo record);

    int insertSelective(userinfo record);

    userinfo selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(userinfo record);

    int updateByPrimaryKey(userinfo record);
}