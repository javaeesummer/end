package com.rev.revuser.dao;

import com.rev.revuser.bean.AttendorBean;
import com.rev.revuser.bean.SponsorBean;

import java.util.List;

public interface SponsorBeanMapper {
    int deleteByPrimaryKey(Integer hostid);

    SponsorBean selectSponsorByUserId(int userid);

    int insert(SponsorBean record);

    int insertSelective(SponsorBean record);

    SponsorBean selectByPrimaryKey(Integer hostid);

    int updateByPrimaryKeySelective(SponsorBean record);

    int updateByPrimaryKey(SponsorBean record);
}