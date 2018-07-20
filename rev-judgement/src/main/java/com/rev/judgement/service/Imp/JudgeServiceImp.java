package com.rev.judgement.service.Imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.rev.judgement.Param.AttendorParam;
import com.rev.judgement.Param.JudgeParam;
import com.rev.judgement.Req.ReqAttendorInfo;
import com.rev.judgement.Req.ReqAttendorList;
import com.rev.judgement.bean.ReviewInfo;
import com.rev.judgement.dao.AttendorInfoMapper;
import com.rev.judgement.dao.ReviewInfoMapper;
import com.rev.judgement.dao.UserInfoMapper;
import com.rev.judgement.dao.WorksInfoMapper;
import com.rev.judgement.bean.AttendorInfo;
import com.rev.judgement.bean.WorksInfo;
import com.rev.judgement.service.JudgeService;


import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
    public int modifyReview(ReviewInfo reviewInfo)
    {
        return reviewInfoMapper.modifyReview(reviewInfo);
    }
    public List<ReqAttendorInfo> showAllAttendor(int activityId) {
        List<ReqAttendorInfo> list=new ArrayList<ReqAttendorInfo>();
        for (AttendorInfo attendorInfo:attendorInfoMapper.getAttendorByActivityId(activityId))
        {
            ReqAttendorInfo reqAttendorInfo=new ReqAttendorInfo();
            reqAttendorInfo.setActivityid(activityId);
            reqAttendorInfo.setUserid(attendorInfo.getUserid());
            reqAttendorInfo.setVotenum(attendorInfo.getVotenum());
            reqAttendorInfo.setUsername(userInfoMapper.getUserByUserId(attendorInfo.getUserid()).getUsername());
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
        for (ReviewInfo reviewInfo:reviewInfoMapper.getReviewByJudgeId(param.getAttendorId()))
        {
            if(reviewInfo.getResult()==null)
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
}
