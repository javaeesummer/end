package com.rev.revuser.param;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author hxs
 * @desprition 用来干嘛的呢, 也就是随便写写的
 **/

public class ActivityIdParam implements Serializable{
    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    @NotNull(message = "activityId不能为空")
    Integer activityId;
}
