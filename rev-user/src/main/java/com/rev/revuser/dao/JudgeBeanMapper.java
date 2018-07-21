package com.rev.revuser.dao;

import com.rev.revuser.bean.AttendorBean;
import com.rev.revuser.bean.JudgeBean;
import com.rev.revuser.result.JudgeView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JudgeBeanMapper {
    int deleteByPrimaryKey(Integer judgeid);

    int insert(JudgeBean record);

    int insertSelective(JudgeBean record);

    JudgeBean selectJudgeByUserId(int userid);

    List<JudgeView> selectByPrimaryKey(@Param("judgeid") Integer judgeid);
    int updateByPrimaryKeySelective(JudgeBean record);

    int updateByPrimaryKey(JudgeBean record);
}