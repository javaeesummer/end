package com.rev.judgement.service;

import com.rev.judgement.Param.AddJudgeParam;
import com.rev.judgement.Param.AttendorParam;
import com.rev.judgement.Param.JudgeParam;
import com.rev.judgement.Param.UserParam;
import com.rev.judgement.Req.ReqAttendorInfo;
import com.rev.judgement.Req.ReqJudgeInfo;
import com.rev.judgement.Req.ReqUserInfo;
import com.rev.judgement.bean.AttendorInfo;
import com.rev.judgement.bean.JudgeInfo;
import com.rev.judgement.bean.ReviewInfo;
import com.rev.judgement.bean.WorksInfo;

import java.util.List;

public interface JudgeService{
    /**
    * @description 评委显示的同一分组的参赛者记录表
     * @method  getAttendorList
     * @param activityId,groupId
    * @param groupId
      * @return java.util.List<com.rev.judgement.bean.AttendorInfo>
      * @date: 2018/7/13 22:39
      * @author:DKC
    **/

    List<AttendorInfo> getAttendorList(int activityId,int groupId);
    /**
     * @description 评委点击进入了一个参赛者记录显示他的参赛信息
     * @method  getWorksDetail
     * @param attendorId
     * @return com.rev.judgement.Req.ReqAttendorInfo
     * @date: 2018/7/13 22:39
     * @author:DKC
     **/
    List<WorksInfo> getWorksDetail(int attendorId);
    /**
     * @description 新建一条评论记录
     * @method  addReview
     * @param attendorId
     * @param judgeId
     * @return
     * @date: 2018/7/14 10:51
     * @author:DKC
     **/
    String addReview(int attendorId,int judgeId);
    /**
     * @description 评委对某个参赛者评论
     * @method
     * @param
     * @return
     * @date: 2018/7/14 12:44
     * @author:DKC
     **/
    int modifyReview(ReviewInfo reviewInfo);
    /**
     * @description 看到的参赛者的列表，包括票数
     * @method  showAllAttendor
     * @param
     * @return
     * @date: 2018/7/15 10:52
     * @author:DKC
     **/
    List<ReqAttendorInfo> showAllAttendor(int activityId);
    /**
     * @description 评委查看自己所有的评审记录
     * @method  
     * @param
     * @return 
     * @date: 2018/7/15 11:17
     * @author:DKC
     **/
    List<ReviewInfo> getReviewByJudgeId(JudgeParam param);
      /**
       * @description 显示某个参赛者的来自不同评审员的评论
       * @method
       * @param
       * @return
       * @date: 2018/7/16 22:56
       * @author:DKC
       **/
    List<ReviewInfo> getReviewByAttendorId(JudgeParam param);
      /**
       * @description 计算某参赛者的成绩返回String
       * @method
       * @param param
       * @return
       * @date: 2018/7/16 23:04
       * @author:DKC
       **/
    String calculateResult(JudgeParam param);
      /**
       * @description 更新attendor表中最终成绩
       * @method
       * @param param
       * @return
       * @date: 2018/7/16 23:17
       * @author:DKC
       **/
    int modifyEndResult(AttendorParam param);
    /**
     * @description  判断评委是否评了某参赛者
     * @method
     * @param
     * @return
     * @date: 2018/7/19 10:47
     * @author:DKC
     **/
    Boolean isReviewed(JudgeParam param);
    /**
     * @description 裁判去查其中一条评论记录
     * @method
     * @param null
     * @return
     * @date: 2018/7/20 9:29
     * @author:DKC
     **/
    List<ReviewInfo> getReview(JudgeParam param);
    /**
     * @description 判断该裁判是否给该参赛者打过分数
     * @method
     * @param null
     * @return
     * @date: 2018/7/20 10:22
     * @author:DKC
     **/
    Boolean isResult(JudgeParam param);
    /**
     * @description 参赛者获取推荐链接
     * @method
     * @param null
     * @return
     * @date: 2018/7/20 10:57
     * @author:DKC
     **/
    String getAddress(AttendorParam param);
    /**
     * @description 给参赛者投上一票
     * @method
     * @param null
     * @return
     * @date: 2018/7/20 10:58
     * @author:DKC
     **/
    Boolean addVote(AttendorParam param);
    /**
     * @description 根据userId获取attendorId或者judgeId
     * @method
     * @param
     * @return
     * @date: 2018/7/20 14:20
     * @author:DKC
     **/
    List<ReqUserInfo> getUserInfoByUserId1(UserParam param);
    /**
     * @description 后台显示所有评委的列表
     * @method
     * @param
     * @return
     * @date: 2018/7/21 11:36
     * @author:DKC
     **/
    List<ReqJudgeInfo> getJudgeByActivityId(UserParam param);
    /**
     * @description 后台直接添加评委
     * @method
     * @param
     * @return
     * @date: 2018/7/21 10:00
     * @author:DKC
     **/
    Boolean addJudge(AddJudgeParam param);

   // List<ReqAttendorList> getReqAttendorList(int activityId,int groupId);
}
