package com.rev.revuser.dao;

import com.rev.revuser.bean.ActivityNodeBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hxs
 * @desprition 用来干嘛的呢, 也就是随便写写的
 **/

public interface ActivityNodeBeanMapper {
    void insertActivityNode(ActivityNodeBean activityNodeBean);
    List<ActivityNodeBean> selectActivityNode(@Param("activityId") Integer activityId);
}
