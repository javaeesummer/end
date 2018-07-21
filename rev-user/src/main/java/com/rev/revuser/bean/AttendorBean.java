package com.rev.revuser.bean;

import java.io.Serializable;

public class AttendorBean extends UserBean{

    private Integer attendorid;  //必须,但是是逐渐，自增

    private Integer activityid; //必须

    private String phonenum; //必须

    private Integer votenum;

    private String endresult;

    private String status;

    private Integer attendorgroupid;//默认为０

//    private Integer userid;//必须


    /**

     *@描述 为什么要实现浅克隆呢,因为我们注册一个用户分为两步,一步是基础信息(用户名和密码),
     * 第二步是参赛者或裁判或主办方的信息,所以,sql操作也是分两步骤进行的,克隆的话
     * 代码会清晰一点,用起来也方便

     *@参数

     *@返回值

     *@创建人  hxs

     *@修改人和其它信息

     */
    @Override
    public Object clone() {
        AttendorBean attendorBean = null;
        attendorBean = (AttendorBean)super.clone();
        return attendorBean;
//        return null;
    }

    private static final long serialVersionUID = 1L;

    public Integer getAttendorid() {
        return attendorid;
    }

    public void setAttendorid(Integer attendorid) {
        this.attendorid = attendorid;
    }

    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum == null ? null : phonenum.trim();
    }

    public Integer getVotenum() {
        return votenum;
    }

    public void setVotenum(Integer votenum) {
        this.votenum = votenum;
    }

    public String getEndresult() {
        return endresult;
    }

    public void setEndresult(String endresult) {
        this.endresult = endresult == null ? null : endresult.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getAttendorgroupid() {
        return attendorgroupid;
    }

    public void setAttendorgroupid(Integer attendorgroupid) {
        this.attendorgroupid = attendorgroupid;
    }



    public static void main(String args[]) {
        AttendorBean stu1 = new AttendorBean();
        stu1.setUserid(213);
        AttendorBean stu2 = (AttendorBean)stu1.clone();

        System.out.println("学生1:" + stu1.getUserid());
        System.out.println("学生2:" + stu2.getUserid());

        stu2.setUserid(54321);

        System.out.println("学生1:" + stu1.getUserid());
        System.out.println("学生2:" + stu2.getUserid());

//            System.out.println("学生1:" + stu1.getNumber());
//            System.out.println("学生2:" + stu2.getNumber());
    }
}