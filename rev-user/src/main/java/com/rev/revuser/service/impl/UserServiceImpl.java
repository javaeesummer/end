package com.rev.revuser.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.rev.revuser.dao.UserMapper;
import com.rev.revuser.result.UserView;
import com.rev.revuser.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Resource
    UserMapper userMapper;
    @Override
    public List<UserView> getAllUser() {
        return userMapper.getAllUser();
    }
}
