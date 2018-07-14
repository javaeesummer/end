package com.rev.revfile.service;
import java.util.List;
import com.rev.revfile.param.*;
import com.rev.revfile.result.FileResult;

public interface FileService {
    //参赛者上传作品
     void uploadFile(FileParam file);
    //参赛者删除作品
    void deleteFile(FileParam file);
    //参赛者修改作品
    void moddifyFile(FileParam file);
    //显示当前活动所有提交者作品
    List<FileResult> getAllFile(ActivityParam activity);
    //显示某个提交者作品
    FileResult getFileByAttendorId(FileParam file);
    //下载单个作品
    FileResult dowmloadFile(FileParam file);
}
