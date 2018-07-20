package com.rev.revuser.result;

import com.rev.revuser.bean.JudgeBean;

/**
 * @author hxs
 * @desprition 用来干嘛的呢, 也就是随便写写的
 **/

public class JudgeView extends  JudgeBean{
    private String username;

    private String userpwd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }


    //下面这几个要删掉得
    JudgeBean judgeBean;

    public JudgeBean getJudgeBean() {
        return judgeBean;
    }

    public void setJudgeBean(JudgeBean judgeBean) {
        this.judgeBean = judgeBean;
    }
}
