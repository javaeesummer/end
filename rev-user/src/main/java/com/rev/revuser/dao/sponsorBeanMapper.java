package com.rev.revuser.dao;

import com.rev.revuser.bean.sponsorBean;

public interface sponsorBeanMapper {
    int deleteByPrimaryKey(Integer hostid);

    int insert(sponsorBean record);

    int insertSelective(sponsorBean record);

    sponsorBean selectByPrimaryKey(Integer hostid);

    int updateByPrimaryKeySelective(sponsorBean record);

    int updateByPrimaryKey(sponsorBean record);
}