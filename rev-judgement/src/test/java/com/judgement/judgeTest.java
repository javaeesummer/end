package com.judgement;

import com.rev.application.controllerApplication;
import com.rev.judgement.Param.AddJudgeParam;
import com.rev.judgement.Param.AttendorParam;
import com.rev.judgement.Param.JudgeParam;
import com.rev.judgement.Param.UserParam;
import com.rev.judgement.Req.ReqAttendorEnd;
import com.rev.judgement.Req.ReqAttendorList;
import com.rev.judgement.Req.ReqUserInfo;
import com.rev.judgement.Req.ReqWorkAndReview;
import com.rev.judgement.bean.AttendorInfo;
import com.rev.judgement.bean.ReviewInfo;
import com.rev.judgement.bean.UserInfo;
import com.rev.judgement.dao.*;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = controllerApplication.class)
public class judgeTest {
    @Resource
    JudgeService judgeService;
    @Resource
    ReviewInfoMapper reviewInfoMapper;
    @Resource
    JudgeInfoMapper judgeInfoMapper;
    @Resource
    AttendorInfoMapper attendorInfoMapper;
    @Resource
    UserInfoMapper userInfoMapper;
    @Resource
    GroupInfoMapper groupInfoMapper;
    @Resource
    WorksInfoMapper worksInfoMapper;
    @Test
    public void getAttendorList(){
        System.out.print("*********************"+ JSONArray.toJSONString(judgeService.getAttendorList(1,1)));
    }
    @Test
    public void getWorksDetail()
    {
        System.out.print("*********************"+ JSONArray.toJSONString(judgeService.getWorksDetail(22)));
        System.out.println(judgeService.getWorksDetail(1).get(0).getWorkname());
        for (AttendorInfo attendorInfo:judgeService.getAttendorList(1,1))
        {
            ReqAttendorList reqAttendorList=new ReqAttendorList();
            reqAttendorList.setAttendorid(attendorInfo.getAttendorid());

            String workname=null;
            workname=judgeService.getWorksDetail(attendorInfo.getAttendorid()).get(0).getWorkname();
            reqAttendorList.setWorkname(workname);
            JudgeParam param1=new JudgeParam();
            param1.setAttendorId(attendorInfo.getAttendorid());
            param1.setJudgeId(1);
            reqAttendorList.setIfjudged(judgeService.isReviewed(param1));
            System.out.println(reqAttendorList.getAttendorid()+reqAttendorList.getWorkname());
            System.out.println(reqAttendorList.getIfjudged());
        }
    }
    @Test
    public void addReview()
    {
        judgeService.addReview(1,1);
    }
    @Test
    public void modifyReview()
    {
        JudgeParam param=new JudgeParam();
        param.setReviewId(67);
        param.setAdvice("123");

        ReviewInfo reviewInfo=new ReviewInfo();
        reviewInfo.setReviewid(param.getReviewId());
//        reviewInfo.setJudgeid(param.getJudgeId());
        reviewInfo.setResult(param.getResult());
        reviewInfo.setAdvice(param.getAdvice());
//        reviewInfo.setAttendorid(param.getAttendorId());
        reviewInfoMapper.modifyReview(reviewInfo);
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
        int i=0;
        int result=0;
        for (ReviewInfo reviewInfo:reviewInfoMapper.getReviewByAttendorId(16))
        {
            System.out.println("*****"+reviewInfo.getResult());
            if(reviewInfo.getResult()==null||reviewInfo.getResult().equals(""))
            {
                result=result+0;
                i--;
            }
            else
            {
                result=result+Integer.parseInt(reviewInfo.getResult());
                System.out.println("result="+result);
            }
            i++;
        }
        if(i==0)
        {
            return ;
        }
        DecimalFormat df = new DecimalFormat("00.00");//格式化小数
        String num = df.format((float)result/i);//返回的是String类型
        System.out.print("*********************"+num);
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
       System.out.println(reviewInfoMapper.isReviewed(1,1).isEmpty());
        ReqWorkAndReview reqWorkAndReview=new ReqWorkAndReview();
        JudgeParam param=new JudgeParam();
        param.setJudgeId(1);
        param.setAttendorId(1);
        param.setActivityId(1);
        System.out.println(judgeService.isReviewed(param));
        if(judgeService.isReviewed(param)){
            reqWorkAndReview.setAttendorid(param.getAttendorId());
            reqWorkAndReview.setAdvice(judgeService.getReviewByAttendorId(param).get(0).getAdvice());
            reqWorkAndReview.setResult(judgeService.getReviewByAttendorId(param).get(0).getResult());
            reqWorkAndReview.setReviewid(judgeService.getReviewByAttendorId(param).get(0).getReviewid());
            reqWorkAndReview.setWorkname(judgeService.getWorksDetail(param.getAttendorId()).get(0).getWorkname());
            reqWorkAndReview.setDescription(judgeService.getWorksDetail(param.getAttendorId()).get(0).getDescription());
            reqWorkAndReview.setFilepath(judgeService.getWorksDetail(param.getAttendorId()).get(0).getFilepath());
        }
//        else //先创建Review记录
//        {
//            judgeService.addReview(param.getAttendorId(),param.getJudgeId());
//            reqWorkAndReview.setAttendorid(param.getAttendorId());
//            reqWorkAndReview.setAdvice(judgeService.getReviewByAttendorId(param).get(0).getAdvice());
//            reqWorkAndReview.setResult(judgeService.getReviewByAttendorId(param).get(0).getResult());
//            reqWorkAndReview.setReviewid(judgeService.getReviewByAttendorId(param).get(0).getReviewid());
//            reqWorkAndReview.setWorkname(judgeService.getWorksDetail(param.getAttendorId()).get(0).getWorkname());
//            reqWorkAndReview.setDescription(judgeService.getWorksDetail(param.getAttendorId()).get(0).getDescription());
//            reqWorkAndReview.setFilepath(judgeService.getWorksDetail(param.getAttendorId()).get(0).getFilepath());
//        }
        System.out.println(reqWorkAndReview.getWorkname());
        System.out.println(reqWorkAndReview.getAdvice());
        System.out.println(reqWorkAndReview.getAttendorid());
        System.out.println(reqWorkAndReview.getFilepath());
        System.out.println(reqWorkAndReview.getDescription());
        System.out.println(reqWorkAndReview.getResult());
        System.out.println(reqWorkAndReview.getReviewid());
    }
    @Test
    public void addVote()
    {
        AttendorParam param=new AttendorParam();
        param.setActivityId(1);
        param.setAttendorId(1);
        judgeService.addVote(param);
    }
    @Test
    public void getUserInfo()
    {
        UserParam param=new UserParam();
        param.setActivityId(1);
        param.setUserId(182);
        List<ReqUserInfo> list=new ArrayList<ReqUserInfo>();
        ReqUserInfo reqUserInfo=new ReqUserInfo();
        reqUserInfo.setActivityId(param.getActivityId());
        if(judgeInfoMapper.getJudgeByUserId(param.getActivityId(),param.getUserId()).isEmpty())
        {
            if(attendorInfoMapper.getAttendorByUserId(param.getActivityId(),param.getUserId()).isEmpty())
            {
                ;
            }
            else
            {
                reqUserInfo.setAttendorId(attendorInfoMapper.getAttendorByUserId(param.getActivityId(),param.getUserId()).get(0).getAttendorid());
            }
        }
        else
        {
            reqUserInfo.setJudgeId(judgeInfoMapper.getJudgeByUserId(param.getActivityId(),param.getUserId()).get(0).getJudgeid());
        }
        list.add(reqUserInfo);
        System.out.println(JSONArray.toJSONString(list));
    }
    @Test
    public void addJudge()
    {
        AddJudgeParam param=new AddJudgeParam();
//        UserInfo userInfo=new UserInfo();
//        userInfo.setUsername("3345");
//        userInfo.setUserpwd("345");
//        userInfoMapper.addUser(userInfo);
        System.out.println("\n");
    //    System.out.println(JSONArray.toJSONString(userInfoMapper.getUserByUserName("234")));
        param.setUserName("112134335");
       param.setUserPwd("1234");

        param.setGroupName("1");
        param.setActivityId(1247);
  //      System.out.println(JSONArray.toJSONString(groupInfoMapper.getGroupInfoByGroupName(param.getActivityId(),param.getGroupName())));
        System.out.println(judgeService.addJudge(param));
    }
    @Test
    public void getJudgeByActivityId()
    {
 //       System.out.println(JSONArray.toJSONString(judgeInfoMapper.getJudgeByActivityId(1)));
       UserParam param =new UserParam();
       param.setActivityId(1);
        System.out.println(JSONArray.toJSONString(judgeService.getJudgeByActivityId(param)));
    }
    @Test
    public void showAttendorEndResult()
    {
        AttendorParam param=new AttendorParam();
        param.setActivityId(1);
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
            {
                reqAttendorEnd.setWorkname(worksInfoMapper.getWorksDetail(attendorInfo.getAttendorid()).get(0).getWorkname());
                reqAttendorEnd.setDescription(worksInfoMapper.getWorksDetail(attendorInfo.getAttendorid()).get(0).getDescription());
                reqAttendorEnd.setFilepath(worksInfoMapper.getWorksDetail(attendorInfo.getAttendorid()).get(0).getFilepath());
            }
            if (userInfoMapper.getUserByUserId(attendorInfo.getUserid())==null)
            {reqAttendorEnd.setUsername(null);}
            else{
            reqAttendorEnd.setUsername(userInfoMapper.getUserByUserId(attendorInfo.getUserid()).getUsername());}
            list.add(reqAttendorEnd);
        }
        Collections.sort(list);
        for (ReqAttendorEnd reqAttendorEnd:list)
        {
            System.out.println(reqAttendorEnd.getUsername()+reqAttendorEnd.getEndResult()+"\n");
        }
    }


}
