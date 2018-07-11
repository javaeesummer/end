package com.rev.controller.judgement.Controllerimp;

import com.rev.dto.judgement.WorkDto;
import com.rev.req.judgement.VoteReq;
import com.rev.res.Result;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author hxs
 * @desprition vote控制类
 **/
@RequestMapping("/test")
public interface voteController {

    @RequestMapping("/vote")
    Result vote(VoteReq voteReq);

    @RequestMapping("/sharelink")
    Result shareLink(); //将作品分享出去 拉票 待定怎么做

    @RequestMapping("/getRankingList")
    Result<List<WorkDto>> getRankingList(int activityid);
}
