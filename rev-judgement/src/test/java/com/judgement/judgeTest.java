package com.judgement;

import com.rev.application.controllerApplication;
import com.rev.judgement.Param.AttendorParam;
import com.rev.judgement.Param.JudgeParam;
import com.rev.judgement.Req.ReqAttendorList;
import com.rev.judgement.bean.AttendorInfo;
import com.rev.judgement.bean.ReviewInfo;
import com.rev.judgement.dao.AttendorInfoMapper;
import com.rev.judgement.dao.ReviewInfoMapper;
import com.rev.judgement.dao.UserInfoMapper;
import com.rev.judgement.service.Imp.JudgeServiceImp;
import com.rev.judgement.service.JudgeService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = controllerApplication.class)
public class judgeTest {
    @Resource
    JudgeService judgeService;
    @Resource
    ReviewInfoMapper reviewInfoMapper;
    @Test
    public void getAttendorList(){
        System.out.print("*********************"+ JSONArray.toJSONString(judgeService.getAttendorList(1,1)));
    }
    @Test
    public void getWorksDetail()
    {
        System.out.print("*********************"+ JSONArray.toJSONString(judgeService.getWorksDetail(20)));
    }
    @Test
    public void addReview()
    {
        judgeService.addReview(1,1);
    }
    @Test
    public void modifyReview()
    {
        ReviewInfo reviewInfo=new ReviewInfo();
        reviewInfo.setJudgeid(1);
        reviewInfo.setAttendorid(1);
        reviewInfo.setAdvice("dkc");
        reviewInfo.setResult("211");
        reviewInfo.setReviewid(1);
        judgeService.modifyReview(reviewInfo);
    }
    @Test
    public void  showAllAttendor()
    {
        System.out.print("*********************"+ JSONArray.toJSONString(judgeService.showAllAttendor(1)));
    }
    @Test
    public void getReviewByJudgeId()
    {
        JudgeParam param=new JudgeParam();
        param.setJudgeId(1);
        System.out.print("*********************"+ JSONArray.toJSONString(judgeService.getReviewByJudgeId(param)));
    }
    @Test
    public void getReviewByAttendorId()
    {
        JudgeParam param=new JudgeParam();
        param.setAttendorId(1);
        System.out.print("*********************"+ JSONArray.toJSONString(judgeService.getReviewByAttendorId(param)));
    }
    @Test
    public void calculateResult()
    {
        JudgeParam param=new JudgeParam();
        param.setAttendorId(1);
        System.out.print("*********************"+ judgeService.calculateResult(param));
    }
    @Test
    public void modifyEndResult()
    {
        AttendorParam param=new AttendorParam();
        param.setAttendorId(1);
        param.setEndResult("200");
        System.out.print("*********************"+ judgeService.modifyEndResult(param));
    }
    @Test
    public void isReviewed()
    {
        JudgeParam param=new JudgeParam();
        param.setAttendorId(1);
        param.setJudgeId(2);
        System.out.println(judgeService.isReviewed(param));
    }
    @Test
    public void reviewmap()
    {

       System.out.println(reviewInfoMapper.isReviewed(1,2).isEmpty());

    }

}
