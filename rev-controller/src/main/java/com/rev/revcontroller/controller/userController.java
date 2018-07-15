package com.rev.revcontroller.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.rev.revuser.exception.ExpCodeEnum;
import com.rev.revuser.param.LoginParam;
import com.rev.revuser.param.RegisterParam;
import com.rev.revuser.param.UserParam;
import com.rev.revuser.result.Result;
import com.rev.revuser.service.UserService;

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
    @Reference
    UserService UserService;
    @ResponseBody
    @RequestMapping(value = "/deletePaper",method = RequestMethod.GET)
    public String deletePaper(HttpServletResponse response, HttpServletRequest request, UserParam param){
        return JSONObject.toJSONString(UserService.getAllUser());
    }
    @ResponseBody
    @RequestMapping(value ="/login", method = RequestMethod.POST)
    public Result login(HttpServletRequest httpServletRequest,LoginParam loginParam){
//        HttpSession httpSession=httpServletRequest.getSession();
//        String username=(String)httpSession.getAttribute("username");
//        String password=(String)httpSession.getAttribute("password");
//        LoginParam loginParam=new LoginParam();
//        loginParam.setPassword(password);
//        loginParam.setUsername(username);
        Result result=UserService.login(loginParam);
        if(result.isSuccess()){
//            httpSession.setAttribute("username",username);
        }
        return result;
    }
    @ResponseBody
    @RequestMapping(value ="/register")
    public Result register(HttpServletRequest httpServletRequest){
        HttpSession httpSession=httpServletRequest.getSession();
        String username=(String)httpSession.getAttribute("username");
        String password=(String)httpSession.getAttribute("password");
        String usertype=(String)httpSession.getAttribute("usertype");
        Result result=new Result();
        if(username==null || password==null || usertype==null){
            result.setSuccess(false);
            result.setErrorCode(ExpCodeEnum.SOMETHING_NULL.getCode());
            result.setMessage(ExpCodeEnum.SOMETHING_NULL.getMessage());
            return result;
        }
        return null;
        ////        RegisterParam loginParam=new LoginParam();
////        loginParam.setPassword(password);
////        loginParam.setUsername(username);
////        Result result=UserService.login(loginParam);
////        if(result.isSuccess()){
////            httpSession.setAttribute("username",username);
////        }
//        return result;
    }

}
