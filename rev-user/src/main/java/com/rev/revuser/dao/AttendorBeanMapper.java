package com.rev.revuser.dao;

import com.rev.revuser.bean.AttendorBean;
import com.rev.revuser.bean.UserBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttendorBeanMapper {
    int deleteByPrimaryKey(Integer attendorid);

    int insert(AttendorBean record);

    int insertSelective(AttendorBean record);

    AttendorBean selectAttendorByUserId(int userid);
    List<UserBean> selectUserByActivityId(int activityId);
    AttendorBean selectByPrimaryKey(@Param("attendorid") Integer attendorid);

    int updateByPrimaryKeySelective(AttendorBean record);

    int updateByPrimaryKey(AttendorBean record);

    AttendorBean selectByOption(@Param("attendorBean") AttendorBean attendorBean);
}