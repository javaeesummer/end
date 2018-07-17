package com.rev.revuser.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.rev.revuser.bean.AttendorBean;
import com.rev.revuser.bean.JudgeBean;
import com.rev.revuser.bean.SponsorBean;
//import com.rev.revuser.dao.UserMapper;
import com.rev.revuser.bean.UserBean;
import com.rev.revuser.dao.AttendorBeanMapper;
import com.rev.revuser.dao.JudgeBeanMapper;
import com.rev.revuser.dao.UserBeanMapper;
import com.rev.revuser.param.*;
import com.rev.revuser.result.AttendorView;
import com.rev.revuser.result.JudgeView;
import com.rev.revuser.result.UserView;
import com.rev.revuser.service.UserService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
//import org.apache.catalina.User;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserBeanMapper UserBeanMapper;
    @Resource
    JudgeBeanMapper JudgeBeanMapper;
    @Resource
    AttendorBeanMapper AttendorBeanMapper;
//todo 事务事务 何苦事物
    @Override
//    @Transactional
    public String login(LoginParam loginParam) {
//        return null;
        UserBean UserBean = UserBeanMapper.selectByUsername(loginParam.getUsername());

        if(null== UserBean){
            return "用户不存在";
        }else{
            if(!UserBean.getUserpwd().equals(loginParam.getPassword())){
                return "密码错误";
            }
            else{
                return "登录成功";
            }
        }
    }
    private String checkLegalRegister(RegisterParam registerParam){
        UserBean userBean=UserBeanMapper.selectByUsername(registerParam.getUsername());
        if(null!=userBean) {
            return "用户名已存在";
        }else{
            return "可以注册";
        }
    }
    @Override
    public SponsorBean toHoldActivity(UserView userView) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
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
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public String registerJudge(RegisterJudgeParam registerJudgeParam) {
        UserBean userBean=UserBeanMapper.selectByUsername(registerJudgeParam.getRegisterParam().getUsername());
        if(null!=userBean){
//            this.usertoJudge(registerJudgeParam);
            return "用户名已经被占用";
        }else{
            //todo 引入事物
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
    public List<UserView> getAllUser() {
        List<UserView> ttt= UserBeanMapper.getAllUser();
        return ttt;
    }

    @Override
    public List<AttendorView> getAllAttendor(GroupParam groupParam) {
        List<UserBean> userBeanList=AttendorBeanMapper.selectUserByActivityId(groupParam.getActivityid());
        List<AttendorView>  attendorViewList=new ArrayList<>();
        for(int i=0;i<userBeanList.size();i++){
            AttendorBean attendorBean=AttendorBeanMapper.selectAttendorByUserId(userBeanList.get(i).getUserid());
            attendorBean.setUserBean(userBeanList.get(i));
            AttendorView attendorView=new AttendorView();
            attendorView.setAttendorBean(attendorBean);
            attendorViewList.add(attendorView);
        }
        return attendorViewList;
    }

    @Override
    public List<AttendorView> getGroupAttendorById(GroupParam groupParam) {
        return null;
    }

    @Override
    public List<AttendorView> getGroupAttendorByName(GroupParam groupParam) {
        return null;
    }

    @Override
    public List<JudgeView> getAllJudge(GroupParam grouParam) {
        return null;
    }

    @Override
    public List<JudgeView> getGroupJudgeById(GroupParam groupParam) {
        return null;
    }

    @Override
    public List<JudgeView> getGroupJudgeByName(GroupParam groupParam) {
        return null;
    }

    @Override
    public List<GroupParam> getGroupId(GroupParam groupParam) {
        return null;
    }

    @Override
    public Boolean setGroupId(List<GroupParam> groupParamList) {
        return null;
    }


    @Override
    public UserView getUserById(int userid) {
        return null;
    }

    @Override
    public SponsorBean toHoldActivity(UserParam userParam) {
        return null;
    }

    @Override
    public String registerAttendor(RegisterAttendorParam registerAttendorParam) {
    String string=this.checkLegalRegister(registerAttendorParam.getRegisterParam());
    if(!string.equals("可以注册")){
            return string;
    }
    //本来可以在这一步就获取到Userid的 呜胡
        this.register(registerAttendorParam.getRegisterParam());
        AttendorBean attendorBean;
        attendorBean=(AttendorBean)registerAttendorParam.getAttendor().clone();
        UserBean userBean=UserBeanMapper.selectByUsername(registerAttendorParam.getRegisterParam().getUsername());
        attendorBean.setUserid(userBean.getUserid());
        AttendorBeanMapper.insert(attendorBean);
        return "注册参赛者成功";
    }

    public String userToAttendor(RegisterAttendorParam registerAttendorParam) {
        return null;
    }


}
