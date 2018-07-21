package com.rev.judgement.dao;

import com.rev.judgement.bean.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

public interface UserInfoMapper {
   UserInfo getUserByUserId(@Param("userId")int userId);
   int addUser(UserInfo userInfo);
   List<UserInfo> getUserByUserName(@Param("userName")String userName);
}