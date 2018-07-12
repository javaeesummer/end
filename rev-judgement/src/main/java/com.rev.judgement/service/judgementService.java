package com.rev.judgement.service;

//import com.rev.revuser.result.UserView;

import com.rev.judgement.entity.review;

import java.util.List;

public interface judgementService {

    /**

     *@描述 获取一个作品所有的评价列表

     *@参数  作品id

     *@返回值  返回裁判评分的类

     *@创建人  hxs

     *@修改人和其它信息

     */
    List<review> getOneWork(int workid);
    /**

     *@描述 获取一个裁判的所有评分表

     *@参数

     *@返回值

     *@创建人  hxs

     *@修改人和其它信息

     */
    List<review> getOneJudge(int judgeid);
    /**

     *@描述 获取一个裁判对一个作品的评价

     *@参数

     *@返回值

     *@创建人  hxs

     *@修改人和其它信息

     */
    review getOneWorkOneJudge(int workid,int judgeid);
    /**

     *@描述 求一个列表的评分表的平均分,这个列表需要自己制作好

     *@参数

     *@返回值

     *@创建人  hxs

     *@修改人和其它信息

     */
    double avg(List<review> reviewList);

}
