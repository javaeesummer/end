package com.judgement;

import com.rev.application.controllerApplication;
import com.rev.judgement.Param.JudgeParam;
import com.rev.judgement.bean.ReviewInfo;
import com.rev.judgement.dao.AttendorInfoMapper;
import com.rev.judgement.dao.UserInfoMapper;
import com.rev.judgement.service.Imp.JudgeServiceImp;
import net.minidev.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = controllerApplication.class)
public class judgeTest {
    @Resource
    JudgeServiceImp judgeServiceImp;
    @Resource
    UserInfoMapper userInfoMapper;
    @Resource
    AttendorInfoMapper attendorInfoMapper;
    @Test
public void testgetAttendorList(){
        System.out.print("*********************"+ JSONArray.toJSONString(judgeServiceImp.getAttendorList(1,3)));
    }
    @Test
    public void testaddReview()
    {
        judgeServiceImp.addReview(1,1);
    }
    @Test
    public void testmodifyReview()
    {
        ReviewInfo reviewInfo=new ReviewInfo();
        reviewInfo.setJudgeid(1);
        reviewInfo.setAttendorid(1);
        reviewInfo.setAdvice("dkc");
        reviewInfo.setResult("22");
        reviewInfo.setReviewid(1);
        judgeServiceImp.modifyReview(reviewInfo);
    }
    @Test
    public void  testshowAllAttendor()
    {
        JudgeParam judgeParam=new JudgeParam();
        judgeParam.setJudgeId(1);
        System.out.print("*********************"+ JSONArray.toJSONString(judgeServiceImp.getReviewByJudgeId(judgeParam)));
    }
}
