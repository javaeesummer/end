package com.rev.controller.judgement.Controllerimp;

import com.rev.dto.judgement.WorkDto;
import com.rev.req.judgement.VoteReq;
import com.rev.res.Result;

import java.util.List;

/**
 * @author hxs
 * @desprition 用来干嘛的呢, 也就是随便写写的
 **/

public class voteControllerImp implements voteController{

    /**

     *@描述 投票

     *@参数 voteReq 包含 投票来源,投票作品等信息

     *@返回值 boolean

     *@创建人  hxs

     *@修改人和其它信息

     */
    @Override
    public Result vote(VoteReq voteReq) {
        return null;
    }

    /**

     *@描述 创建分享链接,待定

     *@参数

     *@返回值

     *@创建人  hxs

     *@修改人和其它信息

     */
    @Override
    public Result shareLink() {
        return null;
    }

    /**

     *@描述 根据活动id得到投票排行榜

     *@参数

     *@返回值

     *@创建人  hxs

     *@修改人和其它信息

     */
    @Override
    public Result<List<WorkDto>> getRankingList(int activityid) {
        return null;
    }
}
