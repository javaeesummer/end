package com.rev.revuser.param;

import com.rev.revuser.bean.ActivityBean;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Date;

/**
 * @author hxs
 * @desprition 用来干嘛的呢, 也就是随便写写的
 **/

public class HoldActivityParam implements Serializable {
   /**
    *　这里为什么传得是useid呢，　因为主办者表中有一个字段是activityId,所以主板者表是针对一次活动的．
    * 那么就是这样处理的　一个企业用户（普通用户表关联一张含有企业id的表，后期也可以用来价格验证）创建一个活动得时候，将活动id
    * 传过去就可以了　//注意companyuser表要和用户表关联
    */
   int userId;
   String activityName;
   String description;
   String startTime; //date传送有点问题，先作为sTIRNG 接受再转化为date吧@hxs　知道得请告诉我
   String endTime;
   int totalCount;//总共选了几个节点

   String endSubmit;
   String upload;
   String uploadT1;
   String vote;
   String voteT1;
   String judge;
   String judgeT1;
   public String getEndSubmit() {
      return endSubmit;
   }

   public void setEndSubmit(String endSubmit) {
      this.endSubmit = endSubmit;
   }

   public String getUploadT1() {
      return uploadT1;
   }

   public void setUploadT1(String uploadT1) {
      this.uploadT1 = uploadT1;
   }

   public String getVoteT1() {
      return voteT1;
   }

   public void setVoteT1(String voteT1) {
      this.voteT1 = voteT1;
   }

   public String getJudgeT1() {
      return judgeT1;
   }

   public void setJudgeT1(String judgeT1) {
      this.judgeT1 = judgeT1;
   }



   public String getVote() {
      return vote;
   }

   public void setVote(String vote) {
      this.vote = vote;
   }

   public String getUpload() {
      return upload;
   }

   public void setUpload(String upload) {
      this.upload = upload;
   }

   public String getJudge() {
      return judge;
   }

   public void setJudge(String judge) {
      this.judge = judge;
   }


   public int getUserId() {
      return userId;
   }

   public void setUserId(int userId) {
      this.userId = userId;
   }

   public String getActivityName() {
      return activityName;
   }

   public void setActivityName(String activityName) {
      this.activityName = activityName;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getStartTime() {
      return startTime;
   }

   public void setStartTime(String startTime) {
      this.startTime = startTime;
   }

   public String getEndTime() {
      return endTime;
   }

   public void setEndTime(String endTime) {
      this.endTime = endTime;
   }


   public int getTotalCount() {
      return totalCount;
   }

   public void setTotalCount(int totalCount) {
      this.totalCount = totalCount;
   }
}
