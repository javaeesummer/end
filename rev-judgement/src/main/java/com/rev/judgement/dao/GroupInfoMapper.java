package com.rev.judgement.dao;

import com.rev.judgement.bean.GroupInfo;

public interface GroupInfoMapper {
    int deleteByPrimaryKey(Integer groupid);

    int insert(GroupInfo record);

    int insertSelective(GroupInfo record);

    GroupInfo selectByPrimaryKey(Integer groupid);

    int updateByPrimaryKeySelective(GroupInfo record);

    int updateByPrimaryKey(GroupInfo record);
}