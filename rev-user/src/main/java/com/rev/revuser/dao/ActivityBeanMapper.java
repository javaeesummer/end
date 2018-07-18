package com.rev.revuser.dao;

import com.rev.revuser.bean.ActivityBean;
import com.rev.revuser.param.ActivityPaginationParam;
import com.rev.revuser.param.PaginationParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hxs
 * @desprition 用来干嘛的呢, 也就是随便写写的
 **/

public interface ActivityBeanMapper {
    List<ActivityBean> selectall();
    List<ActivityBean> getActivityList(@Param("activityPaginationParam") ActivityPaginationParam activityPaginationParam);
    List<ActivityBean> getActivityList(@Param("paginationParam") PaginationParam paginationParam,@Param("hostId") Integer hostId);
    void insertActivity(ActivityBean activityBean);
}
