package com.rev.revcontroller.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.rev.revuser.bean.ActivityBean;
import com.rev.revuser.bean.GroupBean;
import com.rev.revuser.dao.ActivityBeanMapper;
import com.rev.revuser.dao.UserBeanMapper;
import com.rev.revuser.exception.CommonBizException;
import com.rev.revuser.exception.ExpCodeEnum;
import com.rev.revuser.param.*;
import com.rev.revuser.result.Result;
import com.rev.revuser.service.UserService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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

     *@参数  用户名　密码 用户类型

     字段：username ,password,usertype
     *url /register
     */
    @ResponseBody
    @RequestMapping(value ="/register")
    public Result register(HttpServletRequest httpServletRequest,RegisterParam registerParam){
        Result result=new Result();
        if(registerParam.getUsername()==null || registerParam.getPassword()==null || registerParam.getUsertype()==null){
            result.setSuccess(false);
            result.setErrorCode(ExpCodeEnum.SOMETHING_NULL.getCode());
            result.setMessage(ExpCodeEnum.SOMETHING_NULL.getMessage());
            return result;
        }
        return userService.register(registerParam);
    }
    @ResponseBody
    @RequestMapping(value ="/registerAttendor")
    public Result registerAttendor(HttpServletRequest httpServletRequest,RegisterAttendorParam registerAttendorParam){
        return userService.registerAttendor(registerAttendorParam);
    }
    @ResponseBody
    @RequestMapping(value ="/getActivity",method = RequestMethod.POST)
    public Result getOnePageActivity(HttpServletRequest httpServletRequest,ActivityPaginationParam activityPaginationParam){
        if(activityPaginationParam.getPagenum()<1){
            CommonBizException commonBizException=new CommonBizException(ExpCodeEnum.PAGENUM_ERROR);
            return Result.newFailureResult(commonBizException);
        }
        activityPaginationParam.setLimit1((activityPaginationParam.getPagenum()-1)*activityPaginationParam.getPagesize());
        activityPaginationParam.setLimit2(activityPaginationParam.getLimit1()+activityPaginationParam.getPagesize());
//        if(activityPaginationParam.getHostId()==0){
            return Result.newSuccessResult(userService.getOnePageActivity(activityPaginationParam));
//        }else{
//            return Result.newSuccessResult(userService.getOnePageActivityByHostId(activityPaginationParam));
//        }
    }
    /**

     *@描述 注册一个活动　除了活动表　也将为企业用户注册一张sponsor表　

     *@参数

     *@返回值

     *@创建人  hxs

     *@修改人和其它信息

     */
    @ResponseBody
    @RequestMapping(value ="/holdAcitivity",method = RequestMethod.POST)
    public Result holdActivity(HttpServletRequest httpServletRequest,HoldActivityParam holdActivityParam){
        return userService.toHoldActivity(holdActivityParam);
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
    public Result MakeActivityGroup(HttpServletRequest httpServletRequest, MakeGroupParam param){
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
    public Result NextNode(HttpServletRequest httpServletRequest){

        return null;
    }
}
