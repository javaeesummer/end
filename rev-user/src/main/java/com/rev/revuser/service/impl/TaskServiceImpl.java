package com.rev.revuser.service.impl;

import com.rev.revuser.bean.ActivityBean;
import com.rev.revuser.dao.ActivityBeanMapper;
import com.rev.revuser.dao.UserMapper;
import com.rev.revuser.param.GetCurrentEndTimeParam;
import com.rev.revuser.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Resource
    UserMapper userMapper;
    @Resource
    ActivityBeanMapper activityBeanMapper;
    @Override
    public void updateActivityStatus() {
        List<ActivityBean> list=activityBeanMapper.selectall();
        list.stream().forEach(a->{
            GetCurrentEndTimeParam param=new GetCurrentEndTimeParam();
            param.setActivityId(a.getActivityId());
            param.setPriority(a.getConutStatus());
            ActivityBean activityBean=activityBeanMapper.getCurrentEndTime(param);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(activityBean.getEndTime());
            String dateString2=formatter.format(new Date());
            if(dateString.equals(dateString2)){
                activityBeanMapper.updateCountStatus(a.getActivityId(),a.getConutStatus()+1);
            }
        });
    }
}
