package com.rev.revcontroller.file;


import com.rev.revfile.param.ActivityParam;
import com.rev.revfile.param.FileParam;
import com.rev.revfile.result.FileResult;
import com.rev.revfile.service.FileService;
import com.rev.revuser.result.Result;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
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


}
