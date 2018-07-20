package com.rev.judgement.dao;

import com.rev.judgement.bean.AttendorInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttendorInfoMapper {
 List<AttendorInfo> getAttendorByGroupId(@Param("activityId") int activityId, @Param("groupId") int groupId);
 List<AttendorInfo> getAttendorByActivityId(@Param("activityId") int activityId);
 int modifyEndResultByAttendorId(@Param("attendorId")int attendorId,@Param("endResult") String endResult);
 int addVote(@Param("activityId")int activityId,@Param("attendorId")int attendorId);
}