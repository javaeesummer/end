package com.rev.judgement.service;

import com.rev.judgement.Param.AttendorParam;
import com.rev.judgement.Param.JudgeParam;
import com.rev.judgement.Req.ReqAttendorInfo;
import com.rev.judgement.bean.AttendorInfo;
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
     * @description 看到的参赛者的列表，包括票数,成绩
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


}
