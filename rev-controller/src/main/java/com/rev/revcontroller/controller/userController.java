package com.rev.revcontroller.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.rev.revuser.bean.ActivityBean;
import com.rev.revuser.bean.ActivityNodeBean;
import com.rev.revuser.bean.GroupBean;
import com.rev.revuser.bean.JudgeBean;
import com.rev.revuser.dao.ActivityBeanMapper;
import com.rev.revuser.dao.UserBeanMapper;
import com.rev.revuser.exception.CommonBizException;
import com.rev.revuser.exception.ExpCodeEnum;
import com.rev.revuser.param.*;
import com.rev.revuser.result.JudgeView;
import com.rev.revuser.result.Result;
import com.rev.revuser.service.UserService;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@CrossOrigin
@RestController
@Component("userService")
@RequestMapping("/user")
public class userController {

    @Reference(timeout=100000)
    UserService userService;
    @ResponseBody
    @RequestMapping(value = "/deletePaper",method = RequestMethod.GET)
    public String deletePaper(HttpServletResponse response, HttpServletRequest request, UserParam param){
        return JSONObject.toJSONString(userService.getAllUser());
    }
    @ResponseBody
    @RequestMapping(value ="/login", method = RequestMethod.POST)
    public Result login(HttpServletRequest httpServletRequest,LoginParam loginParam){
        Result result=userService.login(loginParam);
        if(result.isSuccess()){
//            httpSession.setAttribute("username",username);
        }
        return result;
    }
    /**

     *@描述 注册帐号（基本帐号）

     *@参数  用户名　密码

     字段：username ,password,usertype
     *url /register
     */
    @ResponseBody
    @RequestMapping(value ="/register")
    public Result register(HttpServletRequest httpServletRequest,RegisterParam registerParam){

        return userService.register(registerParam);
    }
    @ResponseBody
    @RequestMapping(value ="/registerAttendor")
    public Result registerAttendor(HttpServletRequest httpServletRequest,RegisterAttendorParam registerAttendorParam){
        return userService.registerAttendor(registerAttendorParam);
    }
    /**
     *@描述 按照分页请求活动信息
     *@参数  可以根据主办方/或全部得请求
     *@返回  一个list,list另外包含了一个字段是活动得数量,List里面有一个count是参加活动得人数
     */
    @ResponseBody
    @RequestMapping(value ="/getActivity",method = RequestMethod.POST)
    public Result getOnePageActivity(HttpServletRequest httpServletRequest,ActivityPaginationParam activityPaginationParam){
        if(activityPaginationParam.getPagenum()<1){
            CommonBizException commonBizException=new CommonBizException(ExpCodeEnum.PAGENUM_ERROR);
            return Result.newFailureResult(commonBizException);
        }
        activityPaginationParam.setLimit1((activityPaginationParam.getPagenum()-1)*activityPaginationParam.getPagesize());
        activityPaginationParam.setLimit2(activityPaginationParam.getLimit1()+activityPaginationParam.getPagesize());
        return Result.newSuccessResult(userService.getOnePageActivity(activityPaginationParam));
    }
    /**

     *@描述 具体得请求一条Activity的数据
     */
    @ResponseBody
    @RequestMapping(value ="/getActivityById",method = RequestMethod.POST)
    public Result getActivityById(HttpServletRequest httpServletRequest,@Valid ActivityIdParam param,BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return Result.newFailureResult(bindingResult.getFieldError().getDefaultMessage());
        }
        ActivityBean activityBean=userService.getActivityId(param.getActivityId());
        return  Result.newSuccessResult(activityBean);
    }
    /**

     *@描述   获取一个活动的子节点

     *@参数

     */
    @ResponseBody
    @RequestMapping(value ="/getActivityNode",method = RequestMethod.POST)
    public Result getActivityNode(HttpServletRequest httpServletRequest, @Valid ActivityIdParam param,BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return Result.newFailureResult(bindingResult.getFieldError().getDefaultMessage());
        }
        return Result.newSuccessResult(userService.getActivityNode(param.getActivityId()));
    }

    /**

     *@描述 获取活动的数量（所有或按照hostId）

     *@参数
     */
    @ResponseBody
    @RequestMapping(value ="/getActivityCount",method = RequestMethod.POST)
    public Result getActivityCount(HttpServletRequest httpServletRequest,@Valid HostIdParam param,BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return Result.newFailureResult(bindingResult.getFieldError().getDefaultMessage());
        }
        return  Result.newSuccessResult(userService.getActivityCount(param.getHostId()));
    }
    /**
     *@描述 注册一个活动　除了活动表　也将为企业用户注册一张sponsor表　
     * 最渣函数　竟恐怖如斯!
     *@参数
     */
    @ResponseBody
    @RequestMapping(value ="/holdActivity",method = RequestMethod.POST)
    public Result holdActivity(HoldActivityParam param){
        ActivityBean activityBean=userService.toHoldActivity(param);
        if(activityBean==null){
            CommonBizException commonBizException=new CommonBizException(ExpCodeEnum.SEARCH_NULL);
            return Result.newFailureResult(commonBizException);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1=null; //　当前节点的开始时间
        Date date2=null; //  当前节点的结束时间　下一个节点的开始时间
        try {
            date1 = sdf.parse(param.getStartTime());
            date2 = sdf.parse(param.getEndSubmit());
        }catch (Exception e){
            e.printStackTrace();
        }
        ActivityNodeBean activityNodeBean1=new ActivityNodeBean();
        activityNodeBean1.setActivityId(activityBean.getActivityId());
        activityNodeBean1.setPriority(1);
        activityNodeBean1.setStartTime(date1);
        activityNodeBean1.setEndTime(date2);
        userService.addActivityNode(activityNodeBean1);
        if(param.getUpload().equals("是")){
            ActivityNodeBean activityNodeBean=new ActivityNodeBean();
            activityNodeBean.setActivityId(activityBean.getActivityId());
            activityNodeBean.setPriority(2);
            activityNodeBean.setStartTime(date2);
            try{
                date2= sdf.parse(param.getUploadT1());
            }catch(Exception e){
                e.printStackTrace();
            }
            activityNodeBean.setEndTime(date2);
            userService.addActivityNode(activityNodeBean);
        }
        if(param.getVote().equals("是")){
            ActivityNodeBean activityNodeBean=new ActivityNodeBean();
            activityNodeBean.setActivityId(activityBean.getActivityId());
            activityNodeBean.setPriority(3);
            activityNodeBean.setStartTime(date2);
            try{
                date2= sdf.parse(param.getVoteT1());
            }catch(Exception e){
                e.printStackTrace();
            }
            activityNodeBean.setEndTime(date2);
            userService.addActivityNode(activityNodeBean);
        }
        if(param.getJudge().equals("是")){
            ActivityNodeBean activityNodeBean=new ActivityNodeBean();
            activityNodeBean.setActivityId(activityBean.getActivityId());
            activityNodeBean.setPriority(4);

            activityNodeBean.setStartTime(date2);
            try{
                date2= sdf.parse(param.getJudgeT1());
            }catch(Exception e){
                e.printStackTrace();
            }
            activityNodeBean.setEndTime(date2);
            userService.addActivityNode(activityNodeBean);
        }
        ActivityNodeBean activityNodeBean2=new ActivityNodeBean();
        activityNodeBean2.setActivityId(activityBean.getActivityId());
        activityNodeBean2.setPriority(5);

        activityNodeBean2.setStartTime(date2);
        try{
            date2= sdf.parse(param.getEndTime());
        }catch(Exception e){
            e.printStackTrace();
        }
        activityNodeBean2.setEndTime(date2);
        userService.addActivityNode(activityNodeBean2);
        return Result.newSuccessResult();
    }

    /**

     *@描述 初始化，批量创建组，组名默认是1，2，3，4．．．
     *@参数
     *@返回值
     *@创建人  hxs
     *@修改人和其它信息

     */
    @ResponseBody
    @RequestMapping(value ="/MakeActivityGroup",method = RequestMethod.POST)
    public Result MakeActivityGroup(MakeGroupParam param){
        //因为分组表里没有每组多少人这个字段....
        for(int i=0;i<param.getGroupnum();i++){
            GroupBean groupBean=new GroupBean();
            groupBean.setActivityId(param.getActivityId());
            groupBean.setGroupName(""+(i+1));
            userService.setGroup(groupBean);
        }
        return Result.newSuccessResult();
    }

    @ResponseBody
    @RequestMapping(value ="/nextNode",method = RequestMethod.POST)
    public Result NextNode(@Valid ActivityIdParam param,BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return Result.newFailureResult(bindingResult.getFieldError().getDefaultMessage());
        }
        ActivityBean  activityBean=userService.getActivityId(param.getActivityId());
        List<ActivityNodeBean> activityNodeBeanList=userService.getActivityNode(param.getActivityId());
        int flag=1;
        for(int i=0;i<activityNodeBeanList.size();i++){
            flag=1;
            if(activityNodeBeanList.get(i).getPriority()>activityBean.getConutStatus()){
                activityBean.setConutStatus(activityNodeBeanList.get(i).getPriority());
                flag=0;
                break;
            }
        }
        if(flag==1){
            return Result.newFailureResult("已经到了最后一个阶段！");
        }
        userService.toNextStep(activityBean);
        return Result.newSuccessResult("进入下一阶段成功");
    }

    /**
     *@描述 现在要改造成可以根据activityid和attendorid查询
     *@参数
     *@返回值
     */
    @ResponseBody
    @RequestMapping(value ="/getAttendor",method = RequestMethod.POST)
    public Result getAttendor(HttpServletRequest httpServletRequest,Integer attendorId){
        return Result.newSuccessResult(userService.getAttendorById(attendorId));
    }
    /**
     *@描述 可以根据activityId或attendorId取得attendorView
     *@参数
     *@返回值
     */
    @ResponseBody
    @RequestMapping(value ="/getAttendorView",method = RequestMethod.POST)
    public Result getAttendor(GetAttendorViewParam param){
        return Result.newSuccessResult(userService.getAttendorView(param));
    }
    @ResponseBody
    @RequestMapping(value ="/getJudge",method = RequestMethod.POST)
    public Result getJudge(HttpServletRequest httpServletRequest,Integer judgeId){
        List<JudgeView> judgeViewList=userService.getJudgeById(judgeId);
        return Result.newSuccessResult(judgeViewList);
    }
    /**
     *@描述 应该不用别的吧
     *@参数
     *@返回值
     */
    @ResponseBody
    @RequestMapping(value ="/getHost",method = RequestMethod.POST)
    public Result getHost(HttpServletRequest httpServletRequest,Integer hostId){
        return Result.newSuccessResult(userService.getSponsorById(hostId));
    }
}
