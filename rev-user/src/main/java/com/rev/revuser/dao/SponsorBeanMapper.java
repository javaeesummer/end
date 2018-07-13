package com.rev.revuser.dao;

import com.rev.revuser.bean.SponsorBean;

public interface SponsorBeanMapper {
    int deleteByPrimaryKey(Integer hostid);

    int insert(SponsorBean record);

    int insertSelective(SponsorBean record);

    SponsorBean selectByPrimaryKey(Integer hostid);

    int updateByPrimaryKeySelective(SponsorBean record);

    int updateByPrimaryKey(SponsorBean record);
}