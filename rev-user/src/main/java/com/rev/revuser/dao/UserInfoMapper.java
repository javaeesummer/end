package com.rev.revuser.dao;

import com.rev.revuser.entity.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}