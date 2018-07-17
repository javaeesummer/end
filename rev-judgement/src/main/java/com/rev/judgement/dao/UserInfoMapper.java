package com.rev.judgement.dao;

import com.rev.judgement.bean.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper {
   UserInfo getUserByUserId(@Param("userId")int userId);
}