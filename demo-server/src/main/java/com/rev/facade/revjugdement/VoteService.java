package com.rev.facade.revjugdement;


import com.rev.dto.judgement.WorkDto;
import com.rev.req.judgement.VoteReq;

import java.util.List;

public interface VoteService {
    /**

     *@描述 给某一作品投票

     *@参数  投票信息(作品id,来源)

     *@返回值  成功与否

     *@创建人  hxs

     *@修改人和其它信息

     */
     Boolean vote(VoteReq voteReq);
     /**

      *@描述 投票分享链接

      *@参数

      *@返回值

      *@创建人  hxs

      *@修改人和其它信息

      */
     String shareLink(); //将作品分享出去 拉票 待定怎么做
    /**

     *@描述  获取参赛作品排行榜

     *@参数  活动id

     *@返回值  该活动参赛作品的(投票)排行榜

     *@创建人  hxs

     *@修改人和其它信息

     */
     List<WorkDto> getRankingList(int activityid);
}