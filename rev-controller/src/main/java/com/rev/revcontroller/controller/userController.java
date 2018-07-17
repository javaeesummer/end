package com.rev.revcontroller.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.rev.revuser.exception.CommonBizException;
import com.rev.revuser.exception.ExpCodeEnum;
import com.rev.revuser.param.LoginParam;
import com.rev.revuser.param.PaginationParam;
import com.rev.revuser.param.RegisterParam;
import com.rev.revuser.param.UserParam;
import com.rev.revuser.result.Result;
import com.rev.revuser.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public Result login(HttpServletRequest httpServletRequest,LoginParam loginParam){
        Result result=userService.login(loginParam);
        if(result.isSuccess()){
//            httpSession.setAttribute("username",username);
        }
        return result;
    }
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
    @RequestMapping(value ="/getAcitivity",method = RequestMethod.POST)
    public Result getOnePageActivity(HttpServletRequest httpServletRequest,PaginationParam paginationParam,Integer hostId){
        if(paginationParam.getPagenum()<1){
            CommonBizException commonBizException=new CommonBizException(ExpCodeEnum.PAGENUM_ERROR);
            return Result.newFailureResult(commonBizException);
        }
        paginationParam.setLimit1((paginationParam.getPagenum()-1)*paginationParam.getPagesize());
        paginationParam.setLimit2(paginationParam.getLimit1()+paginationParam.getPagesize());
        if(hostId==null){
            return Result.newSuccessResult(userService.getOnePageActivity(paginationParam));
        }else{
            return Result.newSuccessResult(userService.getOnePageActivityByHostId(paginationParam,hostId));
        }
    }

}
