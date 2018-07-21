package com.rev.revuser.task;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rev.revuser.service.TaskService;
import com.rev.revuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ActivityTask {
    @Autowired
    TaskService taskService;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // 定义每过3秒执行任务
    @Scheduled(cron="0 0 0 * * ?" )
    public void reportCurrentTime() {
        taskService.updateActivityStatus();

    }
}