package com.rev.revuser.bean;

import java.io.Serializable;

public class UserBean implements Serializable,Cloneable {
    private Integer userid;

    private String username;

    private String userpwd;

    private String userType;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    private static final long serialVersionUID = 1L;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }
    @Override
    public Object clone() {
        UserBean judgeBean = null;
        try{
            judgeBean = (UserBean) super.clone();
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return judgeBean;
//        return null;
    }
}