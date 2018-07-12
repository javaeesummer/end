package com.rev.revuser.dao;

import com.rev.revuser.bean.userBean;

public interface userBeanMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(userBean record);

    int insertSelective(userBean record);

    userBean selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(userBean record);

    int updateByPrimaryKey(userBean record);
}