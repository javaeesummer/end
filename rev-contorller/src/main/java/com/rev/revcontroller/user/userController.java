package com.rev.revcontroller.user;


import com.alibaba.dubbo.config.annotation.Reference;
import com.rev.revcontroller.util.Result;
import com.rev.revuser.param.UserParam;
import com.rev.revuser.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class userController {
    @Reference
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/deletePaper",method = RequestMethod.POST)
    public Result<List> deletePaper(HttpServletResponse response, HttpServletRequest request, UserParam param){
        return Result.success(userService.getAllUser());
    }
}
