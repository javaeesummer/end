package com.rev.revuser.dao;

import com.rev.revuser.bean.AttendorBean;
import com.rev.revuser.bean.UserBean;
import com.rev.revuser.param.GetAttendorViewParam;
import com.rev.revuser.result.AttendorView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttendorBeanMapper {
    int deleteByPrimaryKey(Integer attendorid);

    int insert(AttendorBean record);

    int insertSelective(AttendorBean record);
    List<AttendorView> selectAttendorView(@Param("attendorViewParam") GetAttendorViewParam attendorViewParam);
    AttendorBean selectAttendorByUserId(int userid);
    List<UserBean> selectUserByActivityId(int activityId);
    AttendorBean selectByPrimaryKey(@Param("attendorid") Integer attendorid);
    Integer getCountOfAttendor(Integer activityId);
    int updateByPrimaryKeySelective(AttendorBean record);

    int updateByPrimaryKey(AttendorBean record);

    AttendorBean selectByOption(@Param("attendorBean") AttendorBean attendorBean);
}