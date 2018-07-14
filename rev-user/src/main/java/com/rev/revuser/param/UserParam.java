package com.rev.revuser.param;

import com.rev.revuser.bean.UserBean;

import java.io.Serializable;

public class UserParam implements Serializable {
    public com.rev.revuser.bean.UserBean getUserBean() {
        return UserBean;
    }

    public void setUserBean(com.rev.revuser.bean.UserBean userBean) {
        UserBean = userBean;
    }

    UserBean UserBean;
}
