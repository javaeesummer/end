package com.rev.revuser.service;

import com.rev.revuser.bean.SponsorBean;
import com.rev.revuser.param.*;
import com.rev.revuser.result.AttendorView;
import com.rev.revuser.result.UserView;

import java.util.List;

public interface UserService {

    String login(LoginParam LoginParam);
    /**

     *@描述 用户成为一个活动主板这(插入一张新表)

     *@参数

     *@返回值

     *@创建人  hxs

     *@修改人和其它信息

     */
    SponsorBean toHoldActivity(UserView userView);
    String register(RegisterParam registerParam);
    /**

     *@描述 注册一个裁判用户 因为裁判用户是一个特殊的用户,所以包含了注册用户的信息,如果这个用户已经注册过了,那么就调用usertoJudge

     *@参数  registerParam+activityid

     *@返回值  提示信息

     *@创建人  hxs

     *@修改人和其它信息

     */
    String registerJudge(RegisterJudgeParam RegisterJudgeParam);
    /**

     *@描述 常与registerJudge配合使用

     *@参数

     *@返回值

     *@创建人  hxs

     *@修改人和其它信息

     */
    String usertoJudge(RegisterJudgeParam RegisterJudgeParam);
    List<UserView> getAllUser();
    List<UserView> getAllAttendor(int activityid);

     AttendorView getAttendorByActivityId(int activityid);

     UserView getUserById(int userid);


     SponsorBean toHoldActivity(UserParam UserParam);

    String registerAttendor(RegisterAttendorParam RegisterAttendorParam);


    String userToAttendor(RegisterAttendorParam RegisterAttendorParam);

}
