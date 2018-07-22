package com.rev.judgement.service.Imp;

import com.alibaba.dubbo.common.threadpool.support.limited.LimitedThreadPool;
import com.alibaba.dubbo.config.annotation.Service;
import com.rev.judgement.Param.AddJudgeParam;
import com.rev.judgement.Param.AttendorParam;
import com.rev.judgement.Param.JudgeParam;
import com.rev.judgement.Param.UserParam;
import com.rev.judgement.Req.*;
import com.rev.judgement.bean.*;
import com.rev.judgement.dao.*;
import com.rev.judgement.service.JudgeService;


import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Service
public class JudgeServiceImp implements JudgeService{

    @Resource
    AttendorInfoMapper attendorInfoMapper;
    @Resource
    WorksInfoMapper worksInfoMapper;
    @Resource
    ReviewInfoMapper reviewInfoMapper;
    @Resource
    UserInfoMapper userInfoMapper;
    @Resource
    JudgeInfoMapper judgeInfoMapper;
    @Resource
    GroupInfoMapper groupInfoMapper;
    @Override
    public  List<AttendorInfo> getAttendorList(int activityId, int groupId)
    {
        return attendorInfoMapper.getAttendorByGroupId(activityId, groupId);
    }
    public List<WorksInfo> getWorksDetail(int attendorId)
    {
        return worksInfoMapper.getWorksDetail(attendorId);
    }
    public String addReview(int attendorId,int judgeId)
    {
        ReviewInfo reviewInfo=new ReviewInfo();
        reviewInfo.setAttendorid(attendorId);
        reviewInfo.setJudgeid(judgeId);
        reviewInfoMapper.addReview(reviewInfo);
        return "ok";
    }
    public int modifyReview(JudgeParam param)
    {
        ReviewInfo reviewInfo=new ReviewInfo();
        reviewInfo.setReviewid(param.getReviewId());
//      reviewInfo.setJudgeid(param.getJudgeId());
        reviewInfo.setResult(param.getResult());
        reviewInfo.setAdvice(param.getAdvice());
//        reviewInfo.setAttendorid(param.getAttendorId());
        return reviewInfoMapper.modifyReview(reviewInfo);
    }
    public List<ReqAttendorInfo> showAllAttendor(int activityId) {
        List<ReqAttendorInfo> list=new ArrayList<ReqAttendorInfo>();
        for (AttendorInfo attendorInfo:attendorInfoMapper.getAttendorByActivityId(activityId))
        {
            ReqAttendorInfo reqAttendorInfo=new ReqAttendorInfo();
            reqAttendorInfo.setUserid(attendorInfo.getUserid());
            reqAttendorInfo.setStatus(attendorInfo.getStatus());
            reqAttendorInfo.setAttendorId(attendorInfo.getAttendorid());
            reqAttendorInfo.setVotenum(attendorInfo.getVotenum());
            if (worksInfoMapper.getWorksDetail(attendorInfo.getAttendorid()).isEmpty()) {
                reqAttendorInfo.setWorkname(null);
                reqAttendorInfo.setFilepath(null);
                reqAttendorInfo.setDescription(null);
            }
            else
            {reqAttendorInfo.setWorkname(worksInfoMapper.getWorksDetail(attendorInfo.getAttendorid()).get(0).getWorkname());
            reqAttendorInfo.setDescription(worksInfoMapper.getWorksDetail(attendorInfo.getAttendorid()).get(0).getDescription());
            reqAttendorInfo.setFilepath(worksInfoMapper.getWorksDetail(attendorInfo.getAttendorid()).get(0).getFilepath());}
            if (userInfoMapper.getUserByUserId(attendorInfo.getUserid())==null)
            {reqAttendorInfo.setUsername(null);}
            else{
                reqAttendorInfo.setUsername(userInfoMapper.getUserByUserId(attendorInfo.getUserid()).getUsername());}
            list.add(reqAttendorInfo);
        }
        return list;
    }
    public List<ReviewInfo> getReviewByJudgeId(JudgeParam param){
        return reviewInfoMapper.getReviewByJudgeId(param.getJudgeId());
    }
    public List<ReviewInfo> getReviewByAttendorId(JudgeParam param)
    {
        return reviewInfoMapper.getReviewByAttendorId(param.getAttendorId());
    }
    public String calculateResult(JudgeParam param)
    {
     //   List<ReviewInfo> list=new ArrayList<ReviewInfo>();
        int i=0;
        int result=0;
        for (ReviewInfo reviewInfo:reviewInfoMapper.getReviewByAttendorId(param.getAttendorId()))
        {
            if(reviewInfo.getResult()==null||reviewInfo.getResult().equals(""))
            { result=result+0;i--;}
            else
            {result=result+Integer.parseInt(reviewInfo.getResult());}
            i++;
        }
        if(i==0)
        {return "0";}
        DecimalFormat df = new DecimalFormat("00.00");//格式化小数
        String num = df.format((float)result/i);//返回的是String类型
        return num;
}
    public int modifyEndResult(AttendorParam param)
    {
        return attendorInfoMapper.modifyEndResultByAttendorId(param.getAttendorId(),param.getEndResult());
    }
    public Boolean isReviewed(JudgeParam param)
    {
        if(reviewInfoMapper.isReviewed(param.getAttendorId(),param.getJudgeId()).isEmpty())
        { return false;}
        else
        { return true;}
    }
    public List<ReviewInfo> getReview(JudgeParam param)
    {
        return reviewInfoMapper.getReview(param.getAttendorId(),param.getJudgeId());
    }
    public Boolean isResult(JudgeParam param)
    {
        if(reviewInfoMapper.isReviewed(param.getAttendorId(),param.getJudgeId()).isEmpty())
        { return false;
        }
        else
            if(reviewInfoMapper.isReviewed(param.getAttendorId(),param.getJudgeId()).get(0).getResult()==null)
            {
                return false;
            }
            else
            {
                return true;
            }
    }
    public String getAddress(AttendorParam param)
    {
        return "127.0.0.1"+Integer.toString(param.getActivityId());
    }
    public Boolean addVote(AttendorParam param)
    {
        attendorInfoMapper.addVote(param.getActivityId(),param.getAttendorId());
        return true;
    }
    public List<ReqUserInfo> getUserInfoByUserId1(UserParam param)
    {
        List<ReqUserInfo> list=new ArrayList<ReqUserInfo>();
        ReqUserInfo reqUserInfo=new ReqUserInfo();
        reqUserInfo.setActivityId(param.getActivityId());
        if(judgeInfoMapper.getJudgeByUserId(param.getActivityId(),param.getUserId())==null||judgeInfoMapper.getJudgeByUserId(param.getActivityId(),param.getUserId()).size()==0)
        {
            if(attendorInfoMapper.getAttendorByUserId(param.getActivityId(),param.getUserId())==null||attendorInfoMapper.getAttendorByUserId(param.getActivityId(),param.getUserId()).size()==0)
            {
                return list;
            }
            else
            {
                reqUserInfo.setAttendorId(attendorInfoMapper.getAttendorByUserId(param.getActivityId(),param.getUserId()).get(0).getAttendorid());
                list.add(reqUserInfo);
                return list;
            }
        }
        else
        {
            reqUserInfo.setJudgeId(judgeInfoMapper.getJudgeByUserId(param.getActivityId(),param.getUserId()).get(0).getJudgeid());
            list.add(reqUserInfo);
            return list;
        }

    }
    public List<ReqJudgeInfo> getJudgeByActivityId(UserParam param)
    {
        List<ReqJudgeInfo> list=new ArrayList<ReqJudgeInfo>();
        for (JudgeInfo judgeInfo:judgeInfoMapper.getJudgeByActivityId(param.getActivityId()))
        {
            ReqJudgeInfo reqJudgeInfo=new ReqJudgeInfo();
            reqJudgeInfo.setJudgeid(judgeInfo.getJudgeid());
            reqJudgeInfo.setGroupid(judgeInfo.getGroupid());
            reqJudgeInfo.setGroupname(groupInfoMapper.getGroupInfoByGroupId(judgeInfo.getGroupid()).get(0).getGroupname());
            reqJudgeInfo.setUsername(userInfoMapper.getUserByUserId(judgeInfo.getUserid()).getUsername());
            reqJudgeInfo.setUserpwd(userInfoMapper.getUserByUserId(judgeInfo.getUserid()).getUserpwd());
            list.add(reqJudgeInfo);
        }
        return list;
    }
    public Boolean addJudge(AddJudgeParam param)
    {
        JudgeInfo judgeInfo=new JudgeInfo();
        //添加user
        if (userInfoMapper.getUserByUserName(param.getUserName()).isEmpty())
        {
        UserInfo userInfo=new UserInfo();
        userInfo.setUsername(param.getUserName());
        userInfo.setUserpwd(param.getUserPwd());
        userInfoMapper.addUser(userInfo);
        }
        else
        {
            return false;
        }
        judgeInfo.setGroupid(groupInfoMapper.getGroupInfoByGroupName(param.getActivityId(),param.getGroupName()).get(0).getGroupid());
        judgeInfo.setActivityid(param.getActivityId());
        judgeInfo.setUserid(userInfoMapper.getUserByUserName(param.getUserName()).get(0).getUserid());
        judgeInfoMapper.addJudge(judgeInfo);
        return true;
    }
     public List<ReqAttendorEnd> showAttendorEndResult(AttendorParam param)
     {
         List<ReqAttendorEnd> list=new ArrayList<ReqAttendorEnd>();
         for (AttendorInfo attendorInfo:attendorInfoMapper.getAttendorByActivityId(param.getActivityId()))
         {
             ReqAttendorEnd reqAttendorEnd=new ReqAttendorEnd();
             reqAttendorEnd.setUserid(attendorInfo.getUserid());
             reqAttendorEnd.setStatus(attendorInfo.getStatus());
             reqAttendorEnd.setEndResult(attendorInfo.getEndresult());
             reqAttendorEnd.setAttendorId(attendorInfo.getAttendorid());
             reqAttendorEnd.setVotenum(attendorInfo.getVotenum());
             if (worksInfoMapper.getWorksDetail(attendorInfo.getAttendorid()).isEmpty()) {
                 reqAttendorEnd.setWorkname(null);
                 reqAttendorEnd.setFilepath(null);
                 reqAttendorEnd.setDescription(null);
             }
             else
             {reqAttendorEnd.setWorkname(worksInfoMapper.getWorksDetail(attendorInfo.getAttendorid()).get(0).getWorkname());
                 reqAttendorEnd.setDescription(worksInfoMapper.getWorksDetail(attendorInfo.getAttendorid()).get(0).getDescription());
                 reqAttendorEnd.setFilepath(worksInfoMapper.getWorksDetail(attendorInfo.getAttendorid()).get(0).getFilepath());}
             if (userInfoMapper.getUserByUserId(attendorInfo.getUserid())==null)
             {reqAttendorEnd.setUsername(null);}
             else{
                 reqAttendorEnd.setUsername(userInfoMapper.getUserByUserId(attendorInfo.getUserid()).getUsername());}
             list.add(reqAttendorEnd);
         }
         Collections.sort(list);
         return list;
     }
}
