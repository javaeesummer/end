package com.rev.revcontorller.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RestController;
import com.rev.facade.st;

@RestController
public class test {

    @Reference(version = "1.0.0")
    private st sts;

    public void test(){
        sts.sayhello();
    }
}
