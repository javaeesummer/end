package com.rev.revcontroller.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.rev.revcontroller.file.uploadManage.UploadFileParam;
import com.rev.revfile.param.ActivityParam;
import com.rev.revfile.param.FileParam;
import com.rev.revfile.result.FileResult;
import com.rev.revfile.service.FileService;
import com.rev.revuser.result.Result;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@Component("fileService")
public class FileController {
    @Reference
    FileService fileService;
    //删除作品
    @ResponseBody
    @RequestMapping(value = "/deleteFile",method = RequestMethod.POST)
    public Result deleteFile(HttpServletResponse response, HttpServletRequest request, FileParam fileParam){
        fileService.deleteFile(fileParam);
        Result result=new Result().newSuccessResult("删除成功");
//        result.setSuccess(true);
        return result;
    }
    //修改作品信息
    @ResponseBody
    @RequestMapping(value = "/moddifyFile",method = RequestMethod.POST)
    public Result<FileParam> moddifyFile(HttpServletResponse response, HttpServletRequest request,FileParam fileParam){
        fileService.moddifyFile(fileParam);
        Result result=new Result().newSuccessResult();
        return result;
    }
    //显示某个参赛者作品
    @ResponseBody
    @RequestMapping(value="/getFileByAttendorId",method = RequestMethod.POST)
    public Result<FileResult> getFileByAttendorId(HttpServletResponse response, HttpServletRequest request, FileParam fileParam){
        fileService.getFileByAttendorId(fileParam);
        Result result=new Result();
        return  result;
    }
    //显示当前活动所有的参赛者作品
    @ResponseBody
    @RequestMapping(value = "/getAllFile",method = RequestMethod.POST)
    public Result<List<FileResult>> getAllFile(HttpServletResponse response, HttpServletRequest request, ActivityParam activityParam){
        fileService.getAllFile(activityParam);

        Result result=new Result();
        return result;
    }
    //上传参赛者作品
    @ResponseBody
    @RequestMapping(value = "/uploadFile",method=RequestMethod.POST)
    public Result<FileResult> uploadFile(UploadFileParam param, HttpServletRequest request) {
        Result result=new Result();
        param.setSubmittime(new Date());

        if(param.getFile()==null) {
    //        return result.newFailureResult(new CommonBizException(ExpCodeEnum.FILE_NO_NULL));
        }
        long startTime = System.currentTimeMillis();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        File f = new File("\\file\\"+ fmt.format(new Date()),param.getFile().getOriginalFilename());
        if(!f.getParentFile().exists()){
            f.getParentFile().mkdirs();
        }
        try {
            param.getFile().transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
//            return result.newFailureResult(new CommonBizException(ExpCodeEnum.FILE_UPLOAD_FIED));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("上传用了多少时间：" + String.valueOf(endTime - startTime) + "ms");
        FileParam fileParam=new FileParam();
        param.setAttendorid(123);
        BeanUtils.copyProperties(fileParam,param);
        fileParam.setFileSize(String.valueOf(param.getFile().getSize()));
        fileService.uploadFile(fileParam);
        return result.newSuccessResult();


    }



}
