package com.rev.revuser.result;

import com.rev.revuser.bean.ActivityBean;

import java.io.Serializable;

/**
 * @author hxs
 * @desprition 用来干嘛的呢, 也就是随便写写的
 **/

public class ActivityBeanView extends ActivityBean implements Serializable{

    int count; //参赛人数

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
