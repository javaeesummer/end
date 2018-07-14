package com.rev.revuser.param;

import java.io.Serializable;

/**
 * @author hxs
 * @desprition 用来干嘛的呢, 也就是随便写写的
 **/

public class RegisterJudgeParam implements Serializable{
    RegisterParam registerParam;
    int activityid;

    public RegisterParam getRegisterParam() {
        return registerParam;
    }

    public void setRegisterParam(RegisterParam registerParam) {
        this.registerParam = registerParam;
    }

    public int getActivityid() {
        return activityid;
    }

    public void setActivityid(int activityid) {
        this.activityid = activityid;
    }


}
