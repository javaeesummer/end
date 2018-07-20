package com.rev.revuser.param;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author hxs
 * @desprition 用来干嘛的呢, 也就是随便写写的
 **/

public class HostIdParam implements Serializable{
    public Integer getHostId() {
        return hostId;
    }

    public void setHostId(Integer hostId) {
        this.hostId = hostId;
    }

    @NotNull(message = "hostId不能为空")
    Integer hostId;
}
