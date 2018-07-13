package com.rev.revuser.service.impl;

import com.rev.revuser.application.GaoxiControllerApplication;
import com.rev.revuser.param.LoginParam;
import com.rev.revuser.param.RegisterParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
/**
 * @author hxs
 * @desprition 用来干嘛的呢, 也就是随便写写的
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GaoxiControllerApplication.class)
public class UserServiceImplTest {
    @Resource
    UserServiceImpl userServiceimp;
    @Test
    public void login() {
        LoginParam LoginParam =new LoginParam();
        LoginParam.setUsername("a");
        LoginParam.setPassword("123");
        String result=userServiceimp.login(LoginParam);
        assertEquals("登录成功",result);
        LoginParam.setUsername("b");
        LoginParam.setPassword("123");
        result=userServiceimp.login(LoginParam);
        assertEquals("密码错误",result);
        LoginParam.setUsername("c");
        LoginParam.setPassword("123");
        result=userServiceimp.login(LoginParam);
        assertEquals("用户不存在",result);


    }

    @Test
    public void register() {
        RegisterParam registerParam=new RegisterParam();
        registerParam.setPassword("123");
        registerParam.setUsername("a");
        userM
    }

    @Test
    public void registerJudge() {
    }

    @Test
    public void usertoJudge() {
    }

    @Test
    public void registerAttendor() {
    }

    @Test
    public void userToAttendor() {
    }

    @Test
    public void getAllUser() {
    }

    @Test
    public void getAttendorByActivityId() {
    }

    @Test
    public void getUserById() {
    }

    @Test
    public void getAllAttendor() {
    }

    @Test
    public void toHoldActivity() {
    }
}