package com.rev.revfile.dao;

import com.rev.revfile.param.ActivityParam;
import com.rev.revfile.param.FileParam;
import com.rev.revfile.result.FileResult;

import java.util.List;

public interface WorksMapper {

    //修改作品信息
    void updateWorksByAttendorid(FileParam fileParam);
    //修改作品信息不上传作品
    void updateWorksByAttendoridNofile(FileParam fileParam);
    //删除作品
    void deleteWorksByAttendorid(Integer attendorid);
    //显示某个参赛者作品
    FileResult getFileByAttendorId (Integer attendorid);
    //显示当前活动的所有作品
    List<FileResult> getAllFile(Integer activityid);

    void insertFile(FileParam param);

}