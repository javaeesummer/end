package com.rev.revuser.service.impl;

import com.rev.revuser.application.GaoxiControllerApplication;
import com.rev.revuser.bean.AttendorBean;
import com.rev.revuser.dao.AttendorBeanMapper;
import com.rev.revuser.param.LoginParam;
import com.rev.revuser.param.RegisterAttendorParam;
import com.rev.revuser.param.RegisterJudgeParam;
import com.rev.revuser.param.RegisterParam;
import com.rev.revuser.result.AttendorView;
import com.rev.revuser.result.Result;
import com.rev.revuser.result.UserView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

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
//        LoginParam LoginParam =new LoginParam();
//        LoginParam.setUsername("a");
//        LoginParam.setPassword("123");
//        String result=userServiceimp.login(LoginParam);
//        assertEquals("登录成功",result);
//        LoginParam.setUsername("b");
//        LoginParam.setPassword("123");
//        result=userServiceimp.login(LoginParam);
//        assertEquals("密码错误",result);
//        LoginParam.setUsername("c");
//        LoginParam.setPassword("123");
//        result=userServiceimp.login(LoginParam);
//        assertEquals("用户不存在",result);


    }

    @Test
    public void register() {
        RegisterParam registerParam=new RegisterParam();
        registerParam.setPassword("123");
        registerParam.setUsername("abbb");
        registerParam.setUsertype("2");
        Result result=userServiceimp.register(registerParam);
        assertEquals("用户名已存在",result);

        result=userServiceimp.register(registerParam);
        assertEquals("注册成功",result);
    }

    @Test
    public void registerJudge() {
//        RegisterJudgeParam registerJudgeParam=new RegisterJudgeParam();
//        RegisterParam registerParam=new RegisterParam();
//        registerParam.setPassword("ggggggg");
//        registerParam.setUsername("agggfffsssggggggg");
//        registerJudgeParam.setRegisterParam(registerParam);
//        registerJudgeParam.setActivityid(123);
//        String result=userServiceimp.registerJudge(registerJudgeParam);
//        assertEquals("评委注册成功",result);


    }

    @Test
    public void usertoJudge() {

//        RegisterJudgeParam registerJudgeParam=new RegisterJudgeParam();
//        RegisterParam registerParam=new RegisterParam();
//        registerParam.setUsername("cssssssggsgllggsllffffs");
//        registerParam.setPassword("111");
//
//        registerJudgeParam.setRegisterParam(registerParam);
//        registerJudgeParam.setActivityid(122333);
//        String result=userServiceimp.registerJudge(registerJudgeParam);
//        assertEquals("评委注册成功",result);
    }

        //可以用这个测试方法测试事物是否生效
    @Test
    public void registerAttendor() {
//        RegisterAttendorParam registerAttendorParam=new RegisterAttendorParam();
//        RegisterParam registerParam=new RegisterParam();
//        registerParam.setPassword("123");
//        registerParam.setUsername("sfygyffyyyffsa");
////        registerAttendorParam.setActivityid(1234444);
//        registerAttendorParam.setRegisterParam(registerParam);
//        AttendorBean attendorBean=new AttendorBean();
//        attendorBean.setActivityid(0);
//        attendorBean.setPhonenum("123");
//        attendorBean.setAttendorgroupid(0);
//        registerAttendorParam.setAttendor(attendorBean);
//        String result=userServiceimp.registerAttendor(registerAttendorParam);
//        assertEquals("注册参赛者成功",result);
    }



    @Test
    public void getAllUser() {
    }

    @Test
    public void getAttendorByActivityId() {
//        List<AttendorView> attendorViewList=userServiceimp.getAllAttendor(1);
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