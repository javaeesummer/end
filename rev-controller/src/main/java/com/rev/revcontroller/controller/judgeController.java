package com.rev.revcontroller.controller;

import com.alibaba.dubbo.config.annotation.Reference;

import com.rev.judgement.Param.JudgeParam;
import com.rev.judgement.bean.AttendorInfo;
import com.rev.judgement.service.JudgeService;
import com.rev.revfile.param.FileParam;
import com.rev.revuser.result.Result;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@Component("judgeService")
@RequestMapping("/judge")
public class judgeController {
    @Reference
    JudgeService judgeService;

    @ResponseBody
    @RequestMapping(value = "/getAttendorList",method = RequestMethod.POST)
    public Result<List<AttendorInfo>> getAttendorList(HttpServletResponse response, HttpServletRequest request, JudgeParam param)
    {
        Result<List<AttendorInfo>> result=new Result<List<AttendorInfo>>();
        result.setData(judgeService.getAttendorList(param.getActivityId(),param.getGroupId()));
        result.setSuccess(true);
        return result;
    }


}
