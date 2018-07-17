package com.rev.judgement.service.Imp;

import com.rev.judgement.Param.AttendorParam;
import com.rev.judgement.Param.JudgeParam;
import com.rev.judgement.Req.ReqAttendorInfo;
import com.rev.judgement.bean.ReviewInfo;
import com.rev.judgement.dao.AttendorInfoMapper;
import com.rev.judgement.dao.ReviewInfoMapper;
import com.rev.judgement.dao.UserInfoMapper;
import com.rev.judgement.dao.WorksInfoMapper;
import com.rev.judgement.bean.AttendorInfo;
import com.rev.judgement.bean.WorksInfo;
import com.rev.judgement.service.JudgeService;
import org.springframework.stereotype.Service;

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
            result=result+Integer.parseInt(reviewInfo.getResult());
            i++;
        }
        DecimalFormat df = new DecimalFormat("00.00");//格式化小数
    String num = df.format((float)result/i);//返回的是String类型
        return num;
}
    public int modifyEndResult(AttendorParam param)
    {
        return attendorInfoMapper.modifyEndResultByAttendorId(param.getAttendorId(),param.getEndResult());
    }

}
