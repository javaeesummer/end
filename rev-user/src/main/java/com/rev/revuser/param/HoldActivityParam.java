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
   int userId;
   String activityName;
   String description;
   String startTime; //date传送有点问题
   String endTime;
   int totalCount;//总共选了几个节点
   String vote;
   String upload;
   String judge;
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
