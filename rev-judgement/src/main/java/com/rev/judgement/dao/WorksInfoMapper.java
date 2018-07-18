package com.rev.judgement.dao;

import com.rev.judgement.bean.WorksInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorksInfoMapper {
    List<WorksInfo> getWorksDetail(@Param("attendorId") int attendorId);

}