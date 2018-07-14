package com.rev.revuser.dao;

import com.rev.revuser.bean.UserBean;
import com.rev.revuser.result.UserView;

import java.util.List;

public interface UserBeanMapper {

    List<UserView> getAllUser();
    int deleteByPrimaryKey(Integer userid);

    int insert(UserBean record);

    int insertSelective(UserBean record);

    UserBean selectByPrimaryKey(Integer userid);

    UserBean selectByUsername(String username);

    int updateByPrimaryKeySelective(UserBean record);

    int updateByPrimaryKey(UserBean record);
}