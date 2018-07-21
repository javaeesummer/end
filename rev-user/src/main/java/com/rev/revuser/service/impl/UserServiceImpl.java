package com.rev.revuser.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.rev.revuser.bean.*;
import com.rev.revuser.dao.*;
import com.rev.revuser.exception.CommonBizException;
import com.rev.revuser.exception.ExpCodeEnum;
import com.rev.revuser.param.*;
import com.rev.revuser.result.*;
import com.rev.revuser.service.UserService;
import org.springframework.beans.BeanUtils;

import javax.annotation.RegEx;
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
    @Resource
    GroupBeanMapper GroupBeanMapper;
    @Resource
    CompanyUserBeanMapper CompanyUserBeanMapper;
    @Resource
    SponsorBeanMapper sponsorBeanMapper;
    @Resource
    ActivityNodeBeanMapper activityNodeBeanMapper;
//　　todo 事务事务 何苦事物
    @Override
    public Result login(LoginParam loginParam) {
        UserBean userBean = UserBeanMapper.selectByUsername(loginParam.getUsername());
        Result result=new Result();
        if(null== userBean){
            result.setSuccess(false);
            result.setErrorCode(ExpCodeEnum.USERNAME_NULL.getCode());
            result.setMessage(ExpCodeEnum.USERNAME_NULL.getMessage());
            return result;
        }else{
            if(!userBean.getUserpwd().equals(loginParam.getPassword())){
                result.setSuccess(false);
                result.setErrorCode(ExpCodeEnum.PASSWORD_WRONG.getCode());
                result.setMessage(ExpCodeEnum.PASSWORD_WRONG.getMessage());
                return result;
            }
            else{
                result.setSuccess(true);
                result.setMessage("登录成功");
                SponsorBean sponsorBean=sponsorBeanMapper.selectSponsorByUserId(userBean.getUserid());
                if(sponsorBean!=null) {
                    result.setData(sponsorBean);
                }else {
                    result.setData(userBean);
                }
                return result;
            }
        }
//        return null;
//
    }
    @Override
    public ActivityBean toHoldActivity(HoldActivityParam holdActivityParam) {
        SponsorBean sponsorBean=new SponsorBean();
        CompanyUserBean selectOption=new CompanyUserBean();
        //验证哟用户是否是企业用户
        selectOption.setUserId(holdActivityParam.getUserId());
        CompanyUserBean companyUserBean=CompanyUserBeanMapper.selectByOption(selectOption);
        if(companyUserBean==null){
//            CommonBizException commonBizException=new CommonBizException(ExpCodeEnum.SEARCH_NULL);
            return  null;
        }
        sponsorBean.setCompanyid(companyUserBean.getCompanyId());
        sponsorBean.setUserid(companyUserBean.getUserId());
        //这里还在创建　所以没有activityid　但是由于mapper中写死了插入的数据，
        //所以这里要写一个没用的数据　要是有时间再回来该吧（虽然打概率是不会回来了　，　再会，代码君！:)
        sponsorBean.setActivityId(0);
        sponsorBeanMapper.insert(sponsorBean);
        ActivityBean activityBean=new ActivityBean();
        activityBean.setActivityName(holdActivityParam.getActivityName());
        activityBean.setDescription(holdActivityParam.getDescription());
        activityBean.setConutStatus(0);
        activityBean.setTotalCount(holdActivityParam.getTotalCount());
        activityBean.setStartTime(holdActivityParam.getStartTime());
        activityBean.setEndTime(holdActivityParam.getEndTime());
        activityBean.setHostId(sponsorBean.getHostid());
        activityBean.setActivityName(holdActivityParam.getActivityName());
        ActivityBeanMapper.insertActivity(activityBean);
        sponsorBean.setActivityId(activityBean.getActivityId());
        sponsorBeanMapper.updateByPrimaryKey(sponsorBean);
        return activityBean;
    }

    @Override
    public Result addActivityNode(ActivityNodeBean activityNodeBean) {
        activityNodeBeanMapper.insertActivityNode(activityNodeBean);
        return null;
    }

    @Override
//    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public Result register(RegisterParam registerParam) {
        if(registerParam.getUsername()==null || registerParam.getPassword()==null){
            Result result=new Result();
            result.setSuccess(false);
            result.setErrorCode(ExpCodeEnum.SOMETHING_NULL.getCode());
            result.setMessage(ExpCodeEnum.SOMETHING_NULL.getMessage());
            return result;
        }
        UserBean userBean=UserBeanMapper.selectByUsername(registerParam.getUsername());
        if(null!=userBean){
            CommonBizException commonBizException=new CommonBizException(ExpCodeEnum.USEREXIST);
            return Result.newFailureResult(commonBizException);
        }else{
            UserBean userBean1=new UserBean();
            userBean1.setUsername(registerParam.getUsername());
            userBean1.setUserpwd(registerParam.getPassword());
            userBean1.setUserType(registerParam.getUsertype());
            UserBeanMapper.insertSelective(userBean1);
            return Result.newSuccessResult();
        }
    }

    @Override
    public Result registerJudge(RegisterJudgeParam registerJudgeParam) {
        UserBean userBean=UserBeanMapper.selectByUsername(registerJudgeParam.getUsername());
        if(null==userBean){
            CommonBizException commonBizException=new CommonBizException(ExpCodeEnum.USEREXIST);
            return Result.newFailureResult(commonBizException);
        }else{
            //todo 引入事务 zuilezuilezuile
            String username=registerJudgeParam.getUsername();
            RegisterParam registerParam=new RegisterParam();
            BeanUtils.copyProperties(registerJudgeParam,registerParam);
            this.register(registerParam);
            UserBean userBean2=UserBeanMapper.selectByUsername(username);
            JudgeBean judgeBean=new JudgeBean();
            judgeBean.setActivityid(registerJudgeParam.getActivityid());
//            GroupBeanMapper.selectByActivityId(registerJudgeParam.getActivityid());
            GroupBean groupBean=new GroupBean();
            groupBean.setGroupName(registerJudgeParam.getGroupName());
            groupBean.setActivityId(registerJudgeParam.getActivityid());
            List<GroupBean> groupBeanList = GroupBeanMapper.selectByOption(groupBean);
            if(groupBeanList==null){
                return Result.newFailureResult("没有关联的组");
            }
            judgeBean.setJugegroupid(groupBeanList.get(0).getGroupId());
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
    public Result groupAttendor(Integer activityId) {
        int count=GroupBeanMapper.selectByActivityId(activityId);
        if(count==0){
            return  Result.newFailureResult("count=0");
        }
        List<AttendorBean> attendorBeanList=AttendorBeanMapper.selectAttendorByActivityId(activityId);
        int block=attendorBeanList.size()/count;
        block=block+1;
        for(int i=0;i<count;i++){
            for(int j=i*block;j<block*(i+1) && j<attendorBeanList.size();j++){
                attendorBeanList.get(j).setAttendorgroupid(i);
            }
        }
        for(int i=0;i<attendorBeanList.size();i++){
            AttendorBeanMapper.updateByPrimaryKeySelective(attendorBeanList.get(i));
        }
        return Result.newSuccessResult();
    }

    @Override
    public AttendorBean getAttendorById(Integer attendorId) {
        return  AttendorBeanMapper.selectByPrimaryKey(attendorId);

    }

    @Override
    public List<AttendorView> getAttendorView(GetAttendorViewParam param) {
        return AttendorBeanMapper.selectAttendorView(param);
    }

    @Override
    public List<JudgeView> getJudgeById(Integer judgeId) {
        return JudgeBeanMapper.selectByPrimaryKey(judgeId);

    }

    @Override
    public SponsorBean getSponsorById(Integer sponsorId) {
        return sponsorBeanMapper.selectByPrimaryKey(sponsorId);

    }

    @Override
    public List<AttendorView> getAllAttendor(GroupParam groupParam) {
        List<UserBean> userBeanList= AttendorBeanMapper.selectUserByActivityId(groupParam.getActivityid());
        List<AttendorView>  attendorViewList=new ArrayList<>();
        for(int i=0;i<userBeanList.size();i++){
            AttendorBean attendorBean=AttendorBeanMapper.selectAttendorByUserId(userBeanList.get(i).getUserid());
            attendorBean.setUsername(userBeanList.get(i).getUsername());
            attendorBean.setUserpwd(userBeanList.get(i).getUserpwd());
            AttendorView attendorView=new AttendorView();
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
    public Integer getCountofAttendor(Integer activityId) {
        return AttendorBeanMapper.getCountOfAttendor(activityId);
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
    public Boolean setGroup(GroupBean groupBean) {
        GroupBeanMapper.insertActivityGroup(groupBean);
        return true;
    }


    @Override
    public UserView getUserById(int userid) {
        return null;
    }

    @Override
    public List<ActivityNodeBean> getActivityNode(Integer activityId) {
        return activityNodeBeanMapper.selectActivityNode(activityId);
    }

    @Override
    public int getActivityCount(Integer hostId) {
        return ActivityBeanMapper.selectCount(hostId);

    }

    @Override
    public ActivityBean getActivityId(int activityId) {
        return ActivityBeanMapper.selectByid(activityId);

    }
/*

    @Override
    public SponsorBean toHoldActivity(UserParam userParam) {
        return null;
    }
*/

    @Override
    public OnePageActivityView getOnePageActivity(ActivityPaginationParam activityPaginationParam) {
        List<ActivityBean> activityBeanList= ActivityBeanMapper.getActivityList(activityPaginationParam);
        OnePageActivityView onePageActivityView=new OnePageActivityView();
        List<ActivityBeanView> activityBeanViewList=new ArrayList<>();
//        BeanUtils.copyProperties();
        for(int i=0;i<activityBeanList.size();i++){

            ActivityBeanView activityBeanView=new ActivityBeanView();
//            BeanUtils.copyProperties(0);
            BeanUtils.copyProperties(activityBeanList.get(i),activityBeanView);
//            activityBeanView=(ActivityBeanView)activityBeanList.get(i);
            activityBeanViewList.add(activityBeanView);
        }
        onePageActivityView.setActivityBeanViewList(activityBeanViewList);
        for(int i=0;i<onePageActivityView.getActivityBeanViewList().size();i++){
            int count=getCountofAttendor(onePageActivityView.getActivityBeanViewList().get(i).getActivityId());
            onePageActivityView.getActivityBeanViewList().get(i).setCount(count);
        }
   //     int count=ActivityBeanMapper.getActivityListCount(activityPaginationParam);
     //   onePageActivityView.setCount(count);
        return  onePageActivityView;
    }

    @Override
    public List<ActivityBean> getOnePageActivityByHostId(ActivityPaginationParam activityPaginationParam) {
        return ActivityBeanMapper.getActivityList(activityPaginationParam, activityPaginationParam.getHostId());
//        return null;
    }

    @Override
    public List<String> getGroupName(Integer activityId) {
        return GroupBeanMapper.getGroupName(activityId);
    }

    @Override
    public void toNextStep(ActivityBean activityBean) {
            ActivityBeanMapper.updateActivity(activityBean);
    }






    @Override
    public Result registerAttendor(RegisterAttendorParam registerAttendorParam) {

        if(null==ActivityBeanMapper.selectByid(registerAttendorParam.getActivityId())){
            CommonBizException commonBizException=new CommonBizException(ExpCodeEnum.ACTIVITY_NOEXIST);
            return Result.newFailureResult(commonBizException);
        }
        if(null==UserBeanMapper.selectByPrimaryKey(registerAttendorParam.getUserId())){
            CommonBizException commonBizException=new CommonBizException(ExpCodeEnum.USERID_NULL);
            return Result.newFailureResult(commonBizException);
        }
        AttendorBean attendorBean_tmp=new AttendorBean();
        attendorBean_tmp.setActivityid(registerAttendorParam.getActivityId());
        attendorBean_tmp.setUserid(registerAttendorParam.getUserId());
        if(AttendorBeanMapper.selectByOption(attendorBean_tmp)!=null){
            CommonBizException commonBizException=new CommonBizException(ExpCodeEnum.ACTIVITY_HASREGISTER);
            return Result.newFailureResult(commonBizException);
        }
        AttendorBean attendorBean=new AttendorBean();
        attendorBean.setUserid(registerAttendorParam.getUserId());
        attendorBean.setActivityid(registerAttendorParam.getActivityId());
        attendorBean.setPhonenum(registerAttendorParam.getPhoneNum());
//        attendorBean.setAttendorgroupid(0);　似乎为null更为合适
        AttendorBeanMapper.insertSelective(attendorBean);
        return Result.newSuccessResult();
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
