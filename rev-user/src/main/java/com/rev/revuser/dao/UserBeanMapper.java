package com.rev.revuser.dao;

import com.rev.revuser.bean.AttendorBean;
import com.rev.revuser.bean.UserBean;
import com.rev.revuser.result.UserView;

import java.util.List;

public interface UserBeanMapper {

    List<UserView> getAllUser();
    int deleteByPrimaryKey(Integer userid);

    int insert(UserBean record);

    int insertSelective(UserBean record);

    UserBean selectByPrimaryKey(Integer userid);

    UserBean selectByUsername(String username);

    //这个本来是想这样的:
    /*
        输入一个活动Id,返回参赛者BEAN(其中包含了USerbean)
        只不过这样要多表查询不说,还要设置对象中的对象,何必呢?
        不如调用两次.
        不如归去,不如归去!
        (虽然这样,要多n次的查询(列表中的每一项都要一遍))
     */
    List<UserBean> selectUserByActivityId(int activityid);


    int updateByPrimaryKeySelective(UserBean record);

    int updateByPrimaryKey(UserBean record);
}