package com.rev.revuser.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.rev.revuser.bean.SponsorBean;
//import com.rev.revuser.dao.UserMapper;
import com.rev.revuser.bean.UserBean;
import com.rev.revuser.dao.UserBeanMapper;
import com.rev.revuser.param.*;
import com.rev.revuser.result.AttendorView;
import com.rev.revuser.result.UserView;
import com.rev.revuser.service.UserService;


import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserBeanMapper UserBeanMapper;

    @Override
    public String login(LoginParam LoginParam) {
        UserBean UserBean = UserBeanMapper.selectByUsername(LoginParam.getUsername());

        if(null== UserBean){
            return "用户不存在";
        }else{
            if(!UserBean.getUserpwd().equals(LoginParam.getPassword())){
                return "密码错误";
            }
            else{
                return "登录成功";
            }
        }
    }

    @Override
    public SponsorBean toHoldActivity(UserView userView) {
        return null;
    }

    @Override
    public String register(RegisterParam registerParam) {
        UserBean userBean=UserBeanMapper.selectByUsername(registerParam.getUsername());
        if(null==userBean){
            return "用户名已存在";
        }else{
            UserBean userBean1=new UserBean();
            userBean1.setUsername(registerParam.getUsername());
            userBean1.setUserpwd(registerParam.getPassword());
            UserBeanMapper.insertSelective(userBean1);
            return "注册成功";
        }
//        return null;
    }

    @Override
    public String registerJudge(RegisterJudgeParam RegisterJudgeParam) {
        return null;
    }

    @Override
    public String usertoJudge(RegisterJudgeParam RegisterJudgeParam) {
        return null;
    }

    @Override
    public List<UserView> getAllUser() {
        List<UserView> ttt= UserBeanMapper.getAllUser();
        return ttt;
    }

    @Override
    public List<UserView> getAllAttendor(int activityid) {
        return null;
    }

    @Override
    public AttendorView getAttendorByActivityId(int activityid) {
        return null;
    }

    @Override
    public UserView getUserById(int userid) {
        return null;
    }

    @Override
    public SponsorBean toHoldActivity(UserParam UserParam) {
        return null;
    }

    @Override
    public String registerAttendor(RegisterAttendorParam RegisterAttendorParam) {
        return null;
    }

    @Override
    public String userToAttendor(RegisterAttendorParam RegisterAttendorParam) {
        return null;
    }


}
