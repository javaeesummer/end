package com.rev.revuser.param;

import com.rev.revuser.bean.AttendorBean;
import com.rev.revuser.bean.JudgeBean;

import java.io.Serializable;

/**
 * @author hxs
 * @desprition 用来干嘛的呢, 也就是随便写写的
 **/

public class RegisterAttendorParam implements Serializable {
    /**

     *@描述 因为我们注册的一个用户分为两部分,基础部分和特殊部分,所以两个类即可

     *@创建人  hxs

     *@修改人和其它信息

     */
    RegisterParam registerParam;
    AttendorBean attendor;

    public RegisterParam getRegisterParam() {
        return registerParam;
    }

    public void setRegisterParam(RegisterParam registerParam) {
        this.registerParam = registerParam;
    }

    public AttendorBean getAttendor() {
        return attendor;
    }

    public void setAttendor(AttendorBean attendor) {
        this.attendor = attendor;
    }
}
