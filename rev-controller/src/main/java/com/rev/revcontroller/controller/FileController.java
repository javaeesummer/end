
package com.rev.revcontroller.controller;


import com.alibaba.dubbo.config.annotation.Reference;
//<<<<<<< Updated upstream:rev-controller/src/main/java/com/rev/revcontroller/controller/FileController.java
import com.rev.revcontroller.file.uploadManage.UploadFileParam;
//=======
//>>>>>>> Stashed changes:rev-controller/src/main/java/com/rev/revcontroller/file/FileController.java
import com.rev.revfile.param.ActivityParam;
import com.rev.revfile.param.FileParam;
import com.rev.revfile.result.FileResult;
import com.rev.revfile.service.FileService;
//import com.rev.revuser.exception.CommonBizException;
//import com.rev.revuser.exception.ExpCodeEnum;
import com.rev.revuser.result.Result;
//<<<<<<< Updated upstream:rev-controller/src/main/java/com/rev/revcontroller/controller/FileController.java


import org.apache.commons.io.FileUtils;
import org.springframework.beans.BeanUtils;
//=======
//>>>>>>> Stashed changes:rev-controller/src/main/java/com/rev/revcontroller/file/FileController.java
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@Component("fileService")
@RequestMapping("/file")
public class FileController {
    @Reference
    FileService fileService;
    //下载作品
    @ResponseBody
    @RequestMapping(value = "/downloadFile",method = RequestMethod.GET)
    public  ResponseEntity<byte[]> downloadFile(HttpServletResponse response, HttpServletRequest request,FileParam fileParam) {
       // Result result = new Result();
        System.out.println("############"+fileParam.getAttendorid());
        FileResult fileResult = fileService.getFileByAttendorId(fileParam);//从数据库中取出作品表的信息
        String filePath = fileResult.getFilepath();
        int len=filePath.length();
        String fname=filePath.substring(17,len);
        System.out.println("-----"+filePath);
        if (filePath == null || filePath == "") {
//            CommonBizException commonBizException = new CommonBizException(ExpCodeEnum.FILE_NO_NULL);
//            return Result.newFailureResult(commonBizException);
            //result.setMessage("文件路径不存在");

        }
        File file = new File(filePath);
        String difileName=null;
        try {
            difileName= new String(fname.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//字节流
        headers.setContentDispositionFormData("attachment",fname);//文件名
        ResponseEntity<byte[]> responseEntity=null;
        try {
             responseEntity= new ResponseEntity< byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
           // result.setData(responseEntity);
            //result.setSuccess(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
          return  responseEntity;

    }
    //删除作品
    @ResponseBody
    @RequestMapping(value = "/deleteFile",method = RequestMethod.POST)
    public Result deleteFile(HttpServletResponse response, HttpServletRequest request, FileParam fileParam){
        Result result=new Result();
        FileResult fileResult = fileService.getFileByAttendorId(fileParam);
        String filepath = fileResult.getFilepath();
        System.out.println("+++++"+filepath);
        if(filepath==null){
              result.setMessage("无此文件");
        }
        else{
            File file=new File(filepath);
            file.delete();
            fileService.deleteFile(fileParam);
            result.setMessage("删除成功");
        }
        return result;
    }
    //修改作品信息无新文件
    @ResponseBody
    @RequestMapping(value = "/moddifyNoFile",method = RequestMethod.POST)
    public Result<FileResult> moddifyNoFile(HttpServletResponse response, HttpServletRequest request,UploadFileParam param){
        Result result=new Result();
        FileParam fileParam=new FileParam();
        fileParam.setAttendorid(param.getAttendorid());
        fileParam.setWorkname(param.getWorkname());
        fileParam.setSubmittime(new Date());
        fileParam.setDescription(param.getDescription());
        System.out.println("+++"+fileParam.getAttendorid());
        System.out.println("+++"+fileParam.getWorkname());
        System.out.println("+++"+fileParam.getDescription());
        fileService.moddifyNoFile(fileParam);
        result.setMessage("修改成功");
        result.setSuccess(true);
        return result;
    }
    //修改作品信息上传新文件
    @ResponseBody
    @RequestMapping(value = "/moddifyFile",method = RequestMethod.POST)
    public Result<FileResult> moddifyFile(HttpServletResponse response, HttpServletRequest request,UploadFileParam param){
        Result result=new Result();
//        if(param.getWorkname()==null){
//            result.setMessage("作品名为空");
//            return  result;
//        }
//        if(param.getFile()!=null)
            //file upload
//            System.out.println("ppppp"+param.getAttendorid());
//            System.out.println("ppppp"+param.getWorkname());
//            param.setSubmittime(new Date());
//            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
//            File f = new File("/file/"+ fmt.format(new Date()),param.getFile().getOriginalFilename());
//            if(!f.getParentFile().exists()){
//                f.getParentFile().mkdirs();
//            }
//            try {
//                param.getFile().transferTo(f);
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (IllegalStateException e) {
//            return result.newFailureResult(new CommonBizException(ExpCodeEnum.FILE_UPLOAD_FIED));
//            }
            FileParam fileParam=new FileParam();
//            BeanUtils.copyProperties(param,fileParam);
//            fileParam.setFileSize(String.valueOf(param.getFile().getSize()));
//            fileParam.setFilepath(f.getAbsolutePath());
            fileParam.setWorkname(param.getWorkname());
            fileParam.setSubmittime(new Date());
            fileParam.setDescription(param.getDescription());
            fileParam.setFileSize(param.getFileSize());
            fileParam.setFilepath(param.getFilepath());
//            System.out.println(f.getAbsolutePath());
//            System.out.println("aaa"+fileParam.getAttendorid());
            result.setMessage("修改成功");
            fileService.moddifyFile(fileParam);
            result.setSuccess(true);
            return result;

        //database update
//        FileParam fileParam=new FileParam();
//        fileParam.setAttendorid(param.getAttendorid());
//        fileParam.setSubmittime(new Date());
//        fileParam.setWorkname(param.getWorkname());
//        fileParam.setDescription(param.getDescription());
//        System.out.println("+++"+fileParam.getAttendorid());
//        System.out.println("+++"+fileParam.getWorkname());
//        System.out.println("+++"+fileParam.getDescription());
//        fileService.moddifyNoFile(fileParam);
//        return result;
    }
    //显示某个参赛者作品
    @ResponseBody
    @RequestMapping(value="/getFileByAttendorId",method = RequestMethod.POST)
    public Result<FileResult> getFileByAttendorId(HttpServletResponse response, HttpServletRequest request, FileParam fileParam){
        //fileService.getFileByAttendorId(fileParam);
        System.out.println("+++"+fileParam.getAttendorid());
        Result result=new Result();
//        result.setMessage("查询成功");
        FileResult fileResult=new FileResult();
        fileResult=fileService.getFileByAttendorId(fileParam);
        if(fileResult==null){
            result.setMessage("您还没有上传过作品，请先上传作品");
            result.setSuccess(false);
        }
        else {
            result.setData(fileResult);
            result.setMessage("查询成功");
            result.setSuccess(true);
        }
        return  result;
    }
    //显示当前活动所有的参赛者作品
    @ResponseBody
    @RequestMapping(value = "/getAllFile",method = RequestMethod.POST)
    public Result<List<FileResult>> getAllFile(HttpServletResponse response, HttpServletRequest request, ActivityParam activityParam){
        //fileService.getAllFile(activityParam);
        System.out.println(activityParam.getAcctivityId());
        Result result=new Result();
        result.setMessage("查询成功");
        result.setData(fileService.getAllFile(activityParam));
        result.setSuccess(true);
        return result;
    }
    //上传参赛者作品
    @ResponseBody
    @RequestMapping(value = "/uploadFile",method=RequestMethod.POST)
    public Result<FileResult> uploadFile(UploadFileParam param, HttpServletRequest request) {
        Result result=new Result();
//        FileParam fileParam1=new FileParam();
//        fileParam1.setAttendorid(param.getAttendorid());
//        FileResult fileResult = new FileResult();
//        fileResult=fileService.getFileByAttendorId(fileParam1);
//        if(fileResult.getFilepath()!=null){
//           result.setMessage("您已经提交过作品，请勿多次提交");
//           return  result;
//        }
//        System.out.println("*******"+param.getAttendorid());
       // param.setAttendorid(Integer.valueOf((String) request.getSession().getAttribute("aId")));
        param.setSubmittime(new Date());
        if(param.getFile()==null) {
    //        return result.newFailureResult(new CommonBizException(ExpCodeEnum.FILE_NO_NULL));
        }
//        long startTime = System.currentTimeMillis();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        File f = new File("/file/"+ fmt.format(new Date()),param.getFile().getOriginalFilename());
        //File f = new File("C:\\Users\\lenovo\\Downloads\\"+ fmt.format(new Date()),param.getFile().getOriginalFilename());
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
//        long endTime = System.currentTimeMillis();
//        System.out.println("上传用了多少时间：" + String.valueOf(endTime - startTime) + "ms");
        FileParam fileParam=new FileParam();
        BeanUtils.copyProperties(param,fileParam);
        fileParam.setFileSize(String.valueOf(param.getFile().getSize()));
        fileParam.setFilepath(f.getAbsolutePath());
        //获取上传的文件名
        fileParam.setFileName(param.getFile().getOriginalFilename());
        System.out.println(f.getAbsolutePath());
       // fileService.uploadFile(fileParam);
        result.setData(fileParam);
        result.setSuccess(true);
       // return result.newSuccessResult();
        return result;
    }
    //上传文件信息插入数据库中
    @ResponseBody
    @RequestMapping(value = "/uploadFileDAate",method=RequestMethod.POST)
    public Result<FileResult> uploadFileDAate(UploadFileParam param, HttpServletRequest request){
        Result result=new Result();
        FileParam fileParam1=new FileParam();
        fileParam1.setAttendorid(param.getAttendorid());
        FileResult fileResult=fileService.getFileByAttendorId(fileParam1);
        if(fileResult!=null){
            result.setMessage("您已经上传过作品，请勿多次提交");
            result.setSuccess(false);
            return result;
        }
        FileParam fileParam =new FileParam();
        fileParam.setAttendorid(param.getAttendorid());
        fileParam.setWorkname(param.getWorkname());
        fileParam.setFileSize(param.getFileSize());
        fileParam.setFilepath(param.getFilepath());
        fileParam.setDescription(param.getDescription());
        fileParam.setSubmittime(new Date());
        fileService.uploadFile(fileParam);
        result.setData("插入成功");
       // result.newSuccessResult();
        result.setSuccess(true);
        return result;
    }

}
