//package com.rev.revfile.service.imp;
//
//import com.alibaba.dubbo.config.annotation.Service;
//import com.rev.revfile.param.ActivityParam;
//import com.rev.revfile.param.FileParam;
//import com.rev.revfile.result.FileResult;
//import com.rev.revfile.service.FileService;
//import com.rev.revfile.dao.WorksMapper;
//
//
//import javax.annotation.Resource;
//import java.util.List;
//@Service
//public class FileServiceImp implements FileService {
//    @Resource
//    WorksMapper worksmapper;
//    //参赛者上传作品
//    @Override
//    public void uploadFile(FileParam file) {
//        worksmapper.insertFile(file);
//    }
//    //删除作品
//    @Override
//    public void deleteFile(FileParam file) {
//    worksmapper.deleteWorksByAttendorid(file.getAttendorid());
//    }
//    //修改作品
//    @Override
//    public void moddifyFile(FileParam file) {
//         worksmapper.updateWorksByAttendorid(file);
//    }
//    @Override
//    public void moddifyNoFile(FileParam file){
//        worksmapper.updateWorksByAttendoridNofile(file);
//    }
//    //显示所有作品
//    @Override
//    public List<FileResult> getAllFile(ActivityParam activity) {
//        return worksmapper.getAllFile(activity.getAcctivityId());
//    }
//    //显示某个参赛者作品
//    @Override
//    public FileResult getFileByAttendorId(FileParam file) {
//        return worksmapper.getFileByAttendorId(file.getAttendorid());
//    }
//    //下载参赛者作品
//    @Override
//    public FileResult dowmloadFile(FileParam file) {
//        return null;
//    }
//}
