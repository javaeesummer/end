package com.rev.revuser.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.rev.revuser.bean.JudgeBean;
import com.rev.revuser.bean.SponsorBean;
//import com.rev.revuser.dao.UserMapper;
import com.rev.revuser.bean.UserBean;
import com.rev.revuser.dao.JudgeBeanMapper;
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
    @Resource
    JudgeBeanMapper JudgeBeanMapper;

    @Override
    public String login(LoginParam LoginParam) {
//        return null;
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
//        return null;
        UserBean userBean=UserBeanMapper.selectByUsername(registerParam.getUsername());
        if(null!=userBean){
            return "用户名已存在";
        }else{
            UserBean userBean1=new UserBean();
            userBean1.setUsername(registerParam.getUsername());
            userBean1.setUserpwd(registerParam.getPassword());
            //哪位好心人知道怎么返回刚插入的主键的,请通知我,谢谢 @黄枭帅
            UserBeanMapper.insertSelective(userBean1);
            return "注册成功";
        }
    }

    @Override
    public String registerJudge(RegisterJudgeParam registerJudgeParam) {
        UserBean userBean=UserBeanMapper.selectByUsername(registerJudgeParam.getRegisterParam().getUsername());
        if(null!=userBean){
            this.usertoJudge(registerJudgeParam);
            return "评委注册成功";
        }else{
            UserBean userBean1=new UserBean();
            userBean1.setUsername(registerJudgeParam.getRegisterParam().getUsername());
            userBean1.setUserpwd(registerJudgeParam.getRegisterParam().getPassword());
            UserBeanMapper.insertSelective(userBean1);
            UserBean userBean2=UserBeanMapper.selectByUsername(userBean1.getUsername());
            JudgeBean judgeBean=new JudgeBean();
            judgeBean.setActivityid(registerJudgeParam.getActivityid());
            judgeBean.setJugegroupid(0);
            judgeBean.setUserid(userBean2.getUserid());
            JudgeBeanMapper.insertSelective(judgeBean);
            return "评委注册成功";
        }
    }

    @Override
    public String usertoJudge(RegisterJudgeParam registerJudgeParam) {
        UserBean userBean=UserBeanMapper.selectByUsername(registerJudgeParam.getRegisterParam().getUsername());
        JudgeBean judgeBean=new JudgeBean();
        judgeBean.setUserid(userBean.getUserid());
        judgeBean.setJugegroupid(0);
        judgeBean.setActivityid(registerJudgeParam.getActivityid());
        JudgeBeanMapper.insertSelective(judgeBean);
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
