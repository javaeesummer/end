package com.rev.revuser;

import com.rev.revuser.application.GaoxiControllerApplication;
import com.rev.revuser.service.UserService;
import net.minidev.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GaoxiControllerApplication.class)
public class userTest {
    @Resource
    UserService userService;
    @Test
    public void testGetAllUser(){
        System.out.print("*********************"+JSONArray.toJSONString(userService.getAllUser()));
    }


}
