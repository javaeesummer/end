package com.rev.revuser.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.rev.revuser.bean.*;
import com.rev.revuser.dao.ActivityBeanMapper;
import com.rev.revuser.dao.AttendorBeanMapper;
import com.rev.revuser.dao.JudgeBeanMapper;
import com.rev.revuser.dao.UserBeanMapper;
import com.rev.revuser.exception.CommonBizException;
import com.rev.revuser.exception.ExpCodeEnum;
import com.rev.revuser.param.*;
import com.rev.revuser.result.AttendorView;
import com.rev.revuser.result.JudgeView;
import com.rev.revuser.result.Result;
import com.rev.revuser.result.UserView;
import com.rev.revuser.service.UserService;
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
    @Resource
    ActivityBeanMapper ActivityBeanMapper;
//　　todo 事务事务 何苦事物
    @Override
    public Result login(LoginParam loginParam) {
        UserBean UserBean = UserBeanMapper.selectByUsername(loginParam.getUsername());
        Result result=new Result();
        if(null== UserBean){
            result.setSuccess(false);
            result.setErrorCode(ExpCodeEnum.USERNAME_NULL.getCode());
            result.setMessage(ExpCodeEnum.USERNAME_NULL.getMessage());
            return result;
        }else{
            if(!UserBean.getUserpwd().equals(loginParam.getPassword())){
                result.setSuccess(false);
                result.setErrorCode(ExpCodeEnum.PASSWORD_WRONG.getCode());
                result.setMessage(ExpCodeEnum.PASSWORD_WRONG.getMessage());
                return result;
            }
            else{
                result.setSuccess(true);
                result.setMessage("登录成功");
                return result;
            }
        }
//        return null;
//
    }
    private String checkLegalRegister(RegisterParam registerParam){
        UserBean userBean=UserBeanMapper.selectByUsername(registerParam.getUsername());
        if(null!=userBean) {
            return "用户名已存在";
        }else{
            return "可以注册";
        }
    }
//    @Override
//    public SponsorBean toHoldActivity(UserView userView) {
//        return null;
//    }

    @Override
//    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public Result register(RegisterParam registerParam) {
//        return null;
        UserBean userBean=UserBeanMapper.selectByUsername(registerParam.getUsername());
        Result result=new Result();
        if(null!=userBean){
            CommonBizException commonBizException=new CommonBizException(ExpCodeEnum.USEREXIST);
            return Result.newFailureResult(commonBizException);
        }else{
            UserBean userBean1=new UserBean();

            //还有一些权限设置没做过　，比如普通参赛者不能注册裁判
            userBean1.setUsername(registerParam.getUsername());
            userBean1.setUserpwd(registerParam.getPassword());
            //哪位好心人知道怎么返回刚插入的主键的,请通知我,谢谢 @黄枭帅
            UserBeanMapper.insertSelective(userBean1);
            return Result.newSuccessResult();
        }
    }

    @Override
    public Result registerJudge(RegisterJudgeParam registerJudgeParam) {
        UserBean userBean=UserBeanMapper.selectByUsername(registerJudgeParam.getRegisterParam().getUsername());
        if(null!=userBean){
            CommonBizException commonBizException=new CommonBizException(ExpCodeEnum.USEREXIST);
            return Result.newFailureResult(commonBizException);
        }else{
            //todo 引入事务 zuilezuilezuile
            String username=registerJudgeParam.getRegisterParam().getUsername();
            this.register(registerJudgeParam.getRegisterParam());
            UserBean userBean2=UserBeanMapper.selectByUsername(username);
            JudgeBean judgeBean=new JudgeBean();
            judgeBean.setActivityid(registerJudgeParam.getActivityid());
            judgeBean.setJugegroupid(0);
            judgeBean.setUserid(userBean2.getUserid());
            JudgeBeanMapper.insertSelective(judgeBean);
            return Result.newSuccessResult();
        }
    }


    @Override
    public List<UserView> getAllUser() {
        List<UserView> ttt= UserBeanMapper.getAllUser();
        return ttt;
    }

    @Override
    public List<AttendorView> getAllAttendor(GroupParam groupParam) {
        List<UserBean> userBeanList= AttendorBeanMapper.selectUserByActivityId(groupParam.getActivityid());
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
    public List<ActivityBean> getAllActivity() {
        return null;
    }

    @Override
    public List<ActivityBean> getActivityByHostId() {
        return null;
    }

    @Override
    public List<ActivityBean> getOnePageActivity(PaginationParam paginationParam) {
//        return ActivityBeanMapper.getActivityList(paginationParam);
        System.out.println("aaa%%%%%%%");
          return ActivityBeanMapper.selectall();
    }

    @Override
    public List<ActivityBean> getOnePageActivityByHostId(PaginationParam paginationParam, int hostId) {
        return ActivityBeanMapper.getActivityList(paginationParam, hostId);
    }

    @Override
    public void toNextStep(ActivityBean activityBean) {

    }


    @Override
    public SponsorBean toHoldActivity(HoldActivityParam holdActivityParam) {

        return null;
    }

    @Override
    public SponsorBean addSponsor(SponsorBean sponsorBean) {
        return null;
    }

    @Override
    public Result registerAttendor(RegisterAttendorParam registerAttendorParam) {

        String string=this.checkLegalRegister(registerAttendorParam.getRegisterParam());
    if(!string.equals("可以注册")){
        CommonBizException commonBizException=new CommonBizException(ExpCodeEnum.REGISTER_ERROR);
        return Result.newFailureResult(commonBizException);
    }
    //本来可以在这一步就获取到Userid的 呜胡
        this.register(registerAttendorParam.getRegisterParam());
        AttendorBean attendorBean;
        attendorBean=(AttendorBean)registerAttendorParam.getAttendor().clone();
        UserBean userBean=UserBeanMapper.selectByUsername(registerAttendorParam.getRegisterParam().getUsername());
        attendorBean.setUserid(userBean.getUserid());
        AttendorBeanMapper.insert(attendorBean);
        return null;
    }


    public com.rev.revuser.dao.UserBeanMapper getUserBeanMapper() {
        return UserBeanMapper;
    }

    public void setUserBeanMapper(com.rev.revuser.dao.UserBeanMapper userBeanMapper) {
        UserBeanMapper = userBeanMapper;
    }

    public com.rev.revuser.dao.JudgeBeanMapper getJudgeBeanMapper() {
        return JudgeBeanMapper;
    }

    public void setJudgeBeanMapper(com.rev.revuser.dao.JudgeBeanMapper judgeBeanMapper) {
        JudgeBeanMapper = judgeBeanMapper;
    }

    public com.rev.revuser.dao.AttendorBeanMapper getAttendorBeanMapper() {
        return AttendorBeanMapper;
    }

    public void setAttendorBeanMapper(com.rev.revuser.dao.AttendorBeanMapper attendorBeanMapper) {
        AttendorBeanMapper = attendorBeanMapper;
    }

    public com.rev.revuser.dao.ActivityBeanMapper getActivityBeanMapper() {
        return ActivityBeanMapper;
    }

    public void setActivityBeanMapper(com.rev.revuser.dao.ActivityBeanMapper activityBeanMapper) {
        ActivityBeanMapper = activityBeanMapper;
    }
}
