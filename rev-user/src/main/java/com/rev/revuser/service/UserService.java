package com.rev.revuser.service;

import com.rev.revuser.bean.*;
import com.rev.revuser.param.*;
import com.rev.revuser.result.*;

import java.util.List;

public interface UserService {

    /**

     *@描述 登录注册模块
     注册各类用户
     *@创建人  hxs

     *@修改人和其它信息

     */
    Result login(LoginParam loginParam);
    /**

     *@描述 用户成为一个活动主办者(插入一张新表)

     *@参数

     *@返回值

     *@创建人  hxs

     *@修改人和其它信息

     */
    Result register(RegisterParam registerParam);
    /**

     *@描述 注册一个裁判用户 因为裁判用户是一个特殊的用户,所以包含了注册用户的信息,如果这个用户已经注册过了,那么就调用usertoJudge

     *@参数  registerParam+activityid

     *@返回值  提示信息

     *@创建人  hxs

     *@修改人和其它信息

     */
    Result registerJudge(RegisterJudgeParam registerJudgeParam);

    Result registerAttendor(RegisterAttendorParam registerAttendorParam);


    /**

     *@描述 活动模块　包括开办活动，各类查询,设置等

     *@创建人  hxs

     *@修改人和其它信息

     */

    /**

     *@描述 开办一个活动

     *@参数

     *@返回值

     *@创建人  hxs

     *@修改人和其它信息

     */
    ActivityBean toHoldActivity(HoldActivityParam holdActivityParam);
    Result addActivityNode(ActivityNodeBean activityNodeBean);
    /**

     *@描述 基础注册方法,除了主板放,注册得时候这样就行了,其他得都要在这个
     * 基础上在调用一个注册方法

     *@参数

     *@返回值

     *@创建人  hxs

     *@修改人和其它信息

     */


    List<UserView> getAllUser();

    /**

     *@描述 得到一个活动得所有参赛者
     *
     *@参数  活动id

     *@返回值

     *@创建人  hxs

     *@修改人和其它信息

     */

    /**

     *@描述 得到一个活动一个组得用户
     *
     *@参数  活动id

     *@返回值

     *@创建人  hxs

     *@修改人和其它信息

     */
    Result groupAttendor(Integer activityId);
    AttendorBean getAttendorById(Integer attendorId);
    List<AttendorView> getAttendorView(GetAttendorViewParam param);
    List<JudgeView> getJudgeById(Integer judgeId);
    SponsorBean getSponsorById(Integer sponsorId);

    List<AttendorView> getAllAttendor(GroupParam groupParam);
    List<AttendorView> getGroupAttendorById(GroupParam groupParam);
    List<AttendorView> getGroupAttendorByName(GroupParam groupParam);

    Integer getCountofAttendor(Integer activityId);
    /**

     *@描述 得到一个活动（一个组）（id或组，名）得所有裁判
     *
     *@参数  活动id

     *@返回值

     *@创建人  hxs

     *@修改人和其它信息

     */

    List<JudgeView> getAllJudge(GroupParam grouParam);
    List<JudgeView> getGroupJudgeById(GroupParam groupParam);
    List<JudgeView> getGroupJudgeByName(GroupParam groupParam);

    /**

     *@描述 得到一个活动得所有裁判组号

     *@参数

     *@返回值

     *@创建人  hxs

     *@修改人和其它信息

     */
    List<GroupParam> getGroupId(GroupParam groupParam);

    /**

     *@描述 创建一个活动得分组（分组是参赛者和评委共享的）

     *@参数

     *@返回值

     *@创建人  hxs

     *@修改人和其它信息

     */
    Boolean setGroupId(List<GroupParam> groupParamList);
    Boolean setGroup(GroupBean groupBean);
    UserView getUserById(int userid);

   /* SponsorBean toHoldActivity(UserParam userParam);*/

    List<ActivityNodeBean> getActivityNode(Integer activityId);
    int getActivityCount(Integer hostId);
    ActivityBean getActivityId(int activityId);
    OnePageActivityView getOnePageActivity(ActivityPaginationParam activityPaginationParam);
    List<ActivityBean> getOnePageActivityByHostId(ActivityPaginationParam activityPaginationParam);

    List<String> getGroupName(Integer activityId);

    /**

     *@描述 activity模块

     *@参数

     *@返回值

     *@创建人  hxs

     *@修改人和其它信息

     */
    void toNextStep(ActivityBean activityBean);

//    Result delAttendor(Integer);
//    Result delSponsor(Integer judgeId);
//    Result delJudge(Integer judgeId);
}
