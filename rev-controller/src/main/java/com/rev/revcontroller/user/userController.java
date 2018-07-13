package com.rev.revcontroller.user;



import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;

import com.rev.revuser.param.UserParam;
import com.rev.revuser.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@RestController
public class userController {
    @Reference
    UserService UserService;

    @ResponseBody
    @RequestMapping(value = "/deletePaper",method = RequestMethod.POST)
    public String deletePaper(HttpServletResponse response, HttpServletRequest request, UserParam param){
        return JSONObject.toJSONString(UserService.getAllUser());
    }
}
