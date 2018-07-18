package com.rev.revcontroller.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.rev.revuser.bean.ActivityBean;
import com.rev.revuser.dao.ActivityBeanMapper;
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
    public Result login(HttpServletRequest httpServletRequest,@RequestBody LoginParam loginParam){
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
    public Result register(HttpServletRequest httpServletRequest,@RequestBody RegisterParam registerParam){
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
    public Result registerAttendor(HttpServletRequest httpServletRequest,@RequestBody RegisterAttendorParam registerAttendorParam){
//        Result result=new Result();
//        if(registerParam.getUsername()==null || registerParam.getPassword()==null || registerParam.getUsertype()==null){
//            result.setSuccess(false);
//            result.setErrorCode(ExpCodeEnum.SOMETHING_NULL.getCode());
//            result.setMessage(ExpCodeEnum.SOMETHING_NULL.getMessage());
//            return result;
//        }

        return userService.registerAttendor(registerAttendorParam);
    }
    @ResponseBody
    @RequestMapping(value ="/getActivity",method = RequestMethod.POST)
    public Result getOnePageActivity(HttpServletRequest httpServletRequest,@RequestBody ActivityPaginationParam activityPaginationParam){
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
    @ResponseBody
    @RequestMapping(value ="/holdAcitivity",method = RequestMethod.POST)
    public Result holdActivity(HttpServletRequest httpServletRequest, ActivityBean activityBean){
        return userService.toHoldActivity(activityBean);
    }
}
