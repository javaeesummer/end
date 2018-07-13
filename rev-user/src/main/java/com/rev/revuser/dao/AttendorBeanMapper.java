package com.rev.revuser.dao;

import com.rev.revuser.bean.AttendorBean;

public interface AttendorBeanMapper {
    int deleteByPrimaryKey(Integer attendorid);

    int insert(AttendorBean record);

    int insertSelective(AttendorBean record);

    AttendorBean selectByPrimaryKey(Integer attendorid);

    int updateByPrimaryKeySelective(AttendorBean record);

    int updateByPrimaryKey(AttendorBean record);
}