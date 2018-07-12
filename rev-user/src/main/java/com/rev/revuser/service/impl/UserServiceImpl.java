package com.rev.revuser.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.rev.revuser.bean.sponsorBean;
import com.rev.revuser.dao.UserMapper;
import com.rev.revuser.param.loginParam;
import com.rev.revuser.param.registerJudgeParam;
import com.rev.revuser.param.registerParam;
import com.rev.revuser.result.UserView;
import com.rev.revuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl  implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public String login(loginParam loginParam) {
        return null;
    }

    @Override
    public sponsorBean toHoldActivity(UserView userView) {
        return null;
    }

    @Override
    public String register(registerParam registerParam) {
        return null;
    }

    @Override
    public String registerJudge(registerJudgeParam registerJudgeParam) {
        return null;
    }

    @Override
    public String usertoJudge(registerJudgeParam registerJudgeParam) {
        return null;
    }

    @Override
    public List<UserView> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public List<UserView> getAllAttendor(int activityid) {
        return null;
    }
}
