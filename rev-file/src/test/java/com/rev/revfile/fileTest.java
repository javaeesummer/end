package com.rev.revfile;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.JSONObject;
import com.rev.revfile.application.controllerApplication;
import com.rev.revfile.param.ActivityParam;
import com.rev.revfile.param.FileParam;
import com.rev.revfile.result.FileResult;
import net.minidev.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.rev.revfile.service.FileService;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = controllerApplication.class)
public class fileTest {
    @Resource
    FileService fileService;

    //修改作品
    @Test
    public void testmoddifyFile(){
        FileParam testfile=new FileParam();
        Date date=new Date();
        //java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        testfile.setSubmittime(date);
        testfile.setAttendorid(1);
        testfile.setFilepath("ssssssss");
        testfile.setWorkname("作品1");
        testfile.setDescription("haode");
        fileService.moddifyFile(testfile);
    }
    //删除作品
    @Test
    public void testDelFile(){
        FileParam testfile=new FileParam();
        testfile.setAttendorid(1);
        fileService.deleteFile(testfile);
    }
    //显示某个参赛者作品
    @Test
    public void testGetAttFile(){
        FileParam testfile=new FileParam();
        testfile.setAttendorid(1);
        System.out.println(com.alibaba.fastjson.JSON.toJSON(fileService.getFileByAttendorId(testfile)));
    }
    //显示当前活动所有参赛者作品
    @Test
    public void testGetAllFile(){
        ActivityParam activityParam=new ActivityParam();
        activityParam.setAcctivityId(1);
        System.out.println(JSONArray.toJSONString(fileService.getAllFile(activityParam)));
    }
}
