package com.rev.revuser.result;

import java.io.Serializable;
import java.util.List;

/**
 * @author hxs
 * @desprition 用来干嘛的呢, 也就是随便写写的
 **/

public class OnePageActivityView implements Serializable{
    List<ActivityBeanView> activityBeanViewList;
    int count;//活动数量
    public List<ActivityBeanView> getActivityBeanViewList() {
        return activityBeanViewList;
    }

    public void setActivityBeanViewList(List<ActivityBeanView> activityBeanViewList) {
        this.activityBeanViewList = activityBeanViewList;
    }



    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
