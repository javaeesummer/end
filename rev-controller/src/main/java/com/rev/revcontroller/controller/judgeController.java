package com.rev.revcontroller.controller;

import com.alibaba.dubbo.config.annotation.Reference;

import com.rev.judgement.Param.AttendorParam;
import com.rev.judgement.Param.JudgeParam;
import com.rev.judgement.Param.UserParam;
import com.rev.judgement.Req.*;
import com.rev.judgement.bean.AttendorInfo;
import com.rev.judgement.bean.JudgeInfo;
import com.rev.judgement.bean.ReviewInfo;
import com.rev.judgement.bean.WorksInfo;
import com.rev.judgement.service.JudgeService;

import com.rev.revuser.result.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.junit.Test;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@Component("judgeService")
@RequestMapping("/judge")
public class judgeController {
    @Reference(timeout=100000)
    JudgeService judgeService;

    @ResponseBody
    @RequestMapping(value = "/getAttendorList",method = RequestMethod.POST)
    /**
     * @description 获取所有和裁判同组的参赛者列表/改进版
     * @method  getAttendorList
     * @param response
     * @param request
     * @param param
     * @return com.rev.revuser.result.Result<java.util.List<com.rev.judgement.bean.AttendorInfo>>
     * @date: 2018/7/17 9:53
     * @author:DKC
     **/
    public Result<List<ReqAttendorList>> getAttendorList(HttpServletResponse response, HttpServletRequest request, JudgeParam param)
    {
        Result<List<ReqAttendorList>> result=new Result<List<ReqAttendorList>>();
        List<ReqAttendorList> list=new ArrayList<ReqAttendorList>();
        for (AttendorInfo attendorInfo:judgeService.getAttendorList(param.getActivityId(),param.getGroupId()))
        {
            ReqAttendorList reqAttendorList=new ReqAttendorList();
            reqAttendorList.setAttendorid(attendorInfo.getAttendorid());
            String workname=null;
            if (judgeService.getWorksDetail(attendorInfo.getAttendorid()).isEmpty())
            {workname=null;}
            else
            {workname=judgeService.getWorksDetail(attendorInfo.getAttendorid()).get(0).getWorkname();}
            reqAttendorList.setWorkname(workname);
            JudgeParam param1=new JudgeParam();
            param1.setAttendorId(attendorInfo.getAttendorid());
            param1.setJudgeId(param.getJudgeId());
            reqAttendorList.setIfjudged(judgeService.isResult(param1));
            list.add(reqAttendorList);
        }
        result.setData(list);
        result.setSuccess(true);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/showAllAttendor",method = RequestMethod.POST)
    /**
     * @description 显示所有参赛者信息
     * @method  showAllAttendor
     * @param response
 * @param request
 * @param param
     * @return com.rev.revuser.result.Result<java.util.List<com.rev.judgement.Req.ReqAttendorInfo>>
     * @date: 2018/7/17 10:04
     * @author:DKC
     **/
    public Result<List<ReqAttendorInfo>> showAllAttendor(HttpServletResponse response, HttpServletRequest request, @RequestBody AttendorParam param)
    {
        Result<List<ReqAttendorInfo>> result=new Result<List<ReqAttendorInfo>>();
        result.setData(judgeService.showAllAttendor(param.getActivityId()));
        result.setSuccess(true);
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/getWorksDetail",method = RequestMethod.POST)
    /**
     * @description 查看作品信息
     * @method  getWorksDetail
     * @param response
     * @param request
     * @param param
     * @return com.rev.revuser.result.Result<com.rev.judgement.bean.WorksInfo>
     * @date: 2018/7/17 10:14
     * @author:DKC
     **/
    public Result<List<WorksInfo>> getWorksDetail(HttpServletResponse response, HttpServletRequest request, @RequestBody JudgeParam param)
    {
        Result<List<WorksInfo>> result=new Result<List<WorksInfo>>();
        result.setData(judgeService.getWorksDetail(param.getAttendorId()));
        result.setSuccess(true);
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/addReview",method = RequestMethod.POST)
    /**
     * @description 新建一条评论记录。目前用不到
     * @method  addReview
     * @param response
     * @param request
     * @param param
     * @return com.rev.revuser.result.Result
     * @date: 2018/7/17 10:18
     * @author:DKC
     **/
    public Result addReview(HttpServletResponse response, HttpServletRequest request, JudgeParam param)
    {
        Result result=new Result();
        judgeService.addReview(param.getAttendorId(),param.getJudgeId());
        result.setSuccess(true);
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/modifyReview",method = RequestMethod.POST)
    /** 评论员修改评论、结果。之后需要修改attendor的endResult
     * @description
     * @method  modifyReview
     * @param response
     * @param request
     * @param param
     * @return com.rev.revuser.result.Result
     * @date: 2018/7/17 11:09
     * @author:DKC
     **/
    public Result modifyReview(HttpServletResponse response, HttpServletRequest request, @RequestBody JudgeParam param)
    {
        Result result=new Result();
        judgeService.modifyReview(param.getReviewInfo());
        String endResult=judgeService.calculateResult(param);
        if(endResult==null)
        {
            result.setSuccess(false);
            result.setMessage("结果为空");
            return result;
        }
        AttendorParam param2=new AttendorParam();
        param2.setEndResult(endResult);
        judgeService.modifyEndResult(param2);
        result.setSuccess(true);
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/getReviewByJudgeId",method = RequestMethod.POST)
    /**
     * @description 根据评审id查询其评论的信息
     * @method  getReviewByJudgeId
     * @param response
     * @param request
     * @param param
     * @return com.rev.revuser.result.Result<java.util.List<com.rev.judgement.bean.ReviewInfo>>
     * @date: 2018/7/17 23:20
     * @author:DKC
     **/
    public Result<List<ReviewInfo>> getReviewByJudgeId(HttpServletResponse response, HttpServletRequest request, @RequestBody JudgeParam param)
    {
        Result<List<ReviewInfo>> result=new Result<List<ReviewInfo>>();
        result.setData(judgeService.getReviewByJudgeId(param));
        result.setSuccess(true);
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/getReviewByAttendorId",method = RequestMethod.POST)
    /**
     * @description 根据参赛者id查询其评论信息
     * @method  getReviewByAttendorId
     * @param response
     * @param request
     * @param param
     * @return com.rev.revuser.result.Result<java.util.List<com.rev.judgement.bean.ReviewInfo>>
     * @date: 2018/7/17 23:22
     * @author:DKC
     **/
    public  Result<List<ReviewInfo>> getReviewByAttendorId (HttpServletResponse response, HttpServletRequest request, @RequestBody JudgeParam param)
    {
        Result<List<ReviewInfo>> result=new Result<List<ReviewInfo>>();
        result.setData(judgeService.getReviewByAttendorId(param));
        result.setSuccess(true);
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/openReview",method = RequestMethod.POST)
    /**
     * @description  评委打开一条需要评论或者修改记录
     * @method  openReview
     * @param param
     * @return com.rev.revuser.result.Result<java.util.List<com.rev.judgement.Req.ReqWorkAndReview>>
     * @date: 2018/7/19 14:46
     * @author:DKC
     **/
    public Result<ReqWorkAndReview> openReview(HttpServletResponse response, HttpServletRequest request,@RequestBody JudgeParam param)
    {
        Result<ReqWorkAndReview> result=new Result<ReqWorkAndReview>();
        ReqWorkAndReview reqWorkAndReview=new ReqWorkAndReview();
        if(judgeService.isReviewed(param)) {
            reqWorkAndReview.setAttendorid(param.getAttendorId());
            reqWorkAndReview.setAdvice(judgeService.getReview(param).get(0).getAdvice());
            reqWorkAndReview.setResult(judgeService.getReview(param).get(0).getResult());
            reqWorkAndReview.setReviewid(judgeService.getReview(param).get(0).getReviewid());
            reqWorkAndReview.setWorkname(judgeService.getWorksDetail(param.getAttendorId()).get(0).getWorkname());
            reqWorkAndReview.setDescription(judgeService.getWorksDetail(param.getAttendorId()).get(0).getDescription());
            reqWorkAndReview.setFilepath(judgeService.getWorksDetail(param.getAttendorId()).get(0).getFilepath());
        }
        else //先创建Review记录
        {
            judgeService.addReview(param.getAttendorId(),param.getJudgeId());
            reqWorkAndReview.setAttendorid(param.getAttendorId());
            reqWorkAndReview.setAdvice(judgeService.getReview(param).get(0).getAdvice());
            reqWorkAndReview.setResult(judgeService.getReview(param).get(0).getResult());
            reqWorkAndReview.setReviewid(judgeService.getReview(param).get(0).getReviewid());
            reqWorkAndReview.setWorkname(judgeService.getWorksDetail(param.getAttendorId()).get(0).getWorkname());
            reqWorkAndReview.setDescription(judgeService.getWorksDetail(param.getAttendorId()).get(0).getDescription());
            reqWorkAndReview.setFilepath(judgeService.getWorksDetail(param.getAttendorId()).get(0).getFilepath());
        }
        result.setData(reqWorkAndReview);
        result.setSuccess(true);
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/getAddress",method = RequestMethod.POST)
    /**
     * @description   参赛者获取推荐链接
     * @method  openReview
     * @param response
     * @param request
     * @param param
     * @return com.rev.revuser.result.Result<java.lang.String>
     * @date: 2018/7/20 10:55
     * @author:DKC
     **/
    public  Result<String> getAddress(HttpServletResponse response, HttpServletRequest request,@RequestBody AttendorParam param)
    {
        Result<String> result=new Result<String>();
        result.setSuccess(true);
        result.setData(judgeService.getAddress(param));
        return result;
    }
     @ResponseBody
    @RequestMapping(value = "/addVote",method = RequestMethod.POST)
    /**
     * @description 游客给参赛者投一票
     * @method  addVote
     * @param response
     * @param request
     * @param param
     * @return com.rev.revuser.result.Result
     * @date: 2018/7/20 10:56
     * @author:DKC
     **/
    public Result addVote(HttpServletResponse response, HttpServletRequest request,@RequestBody AttendorParam param)
    {
        Result result=new Result();
        result.setData(judgeService.addVote(param));
        result.setSuccess(true);
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    /**
     * @description  用userId判断是参赛者还是评审
     * @method  getUserInfo
     * @param response
     * @param request
     * @param param
     * @return com.rev.revuser.result.Result<java.util.List<com.rev.judgement.Req.ReqUserInfo>>
     * @date: 2018/7/21 8:46
     * @author:DKC
     **/
    public Result<List<ReqUserInfo>> getUserInfo(HttpServletResponse response, HttpServletRequest request, @RequestBody UserParam param)
    {
        Result<List<ReqUserInfo>> result=new Result<List<ReqUserInfo>>();
        result.setSuccess(true);
        result.setData(judgeService.getUserInfoByUserId1(param));
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/getJudgeListByActivityId",method = RequestMethod.POST)
    /**
     * @description 后台根据activityId查询judge列表
     * @method  getJudgeListByActivityId
     * @param response
     * @param request
     * @param param
     * @return com.rev.revuser.result.Result<java.util.List<com.rev.judgement.Req.ReqJudgeInfo>>
     * @date: 2018/7/21 13:28
     * @author:DKC
     **/
    public Result<List<ReqJudgeInfo>> getJudgeListByActivityId(HttpServletResponse response, HttpServletRequest request, @RequestBody UserParam param)
    {
        Result<List<ReqJudgeInfo>> result=new Result<List<ReqJudgeInfo>>();
        result.setData(judgeService.getJudgeByActivityId(param));
        result.setSuccess(true);
        return result;
    }



}
