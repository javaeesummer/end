package com.rev.revuser.dao;

import com.rev.revuser.bean.GroupBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hxs
 * @desprition 用来干嘛的呢, 也就是随便写写的
 **/

public interface GroupBeanMapper {
    void insertActivityGroup(GroupBean groupBean);
//    GroupBean selectByOption(GroupBean grouBean);
    Integer selectByActivityId(@Param("activityId") Integer activityId);
    List<GroupBean> selectByOption(@Param("groupBean") GroupBean groupBean);
}
