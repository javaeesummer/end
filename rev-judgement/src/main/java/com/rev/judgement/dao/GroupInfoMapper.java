package com.rev.judgement.dao;

import com.rev.judgement.bean.GroupInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupInfoMapper {
    List<GroupInfo> getGroupInfoByGroupName(@Param("activityId")int activityId,@Param("groupName")String groupName);
    List<GroupInfo> getGroupInfoByGroupId(@Param("groupId")int groupId);
}