package com.rev.revuser.dao;

import com.rev.revuser.bean.AttendorBean;
import com.rev.revuser.bean.JudgeBean;

import java.util.List;

public interface JudgeBeanMapper {
    int deleteByPrimaryKey(Integer judgeid);

    int insert(JudgeBean record);

    int insertSelective(JudgeBean record);

    JudgeBean selectJudgeByUserId(int userid);

    JudgeBean selectByPrimaryKey(Integer judgeid);

    int updateByPrimaryKeySelective(JudgeBean record);

    int updateByPrimaryKey(JudgeBean record);
}