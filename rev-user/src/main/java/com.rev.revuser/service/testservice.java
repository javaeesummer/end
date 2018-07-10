package com.rev.revuser.service;
import com.alibaba.dubbo.config.annotation.Service;
import com.rev.facade.st;


@Service(version = "1.0.0")
public class testservice implements st{
    @Override
    public void sayhello() {
        System.out.println("hello world");
    }
}
