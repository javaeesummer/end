package com.rev.facade.revjugdement;


import com.rev.dto.judgement.WorkDto;
import com.rev.req.judgement.VoteReq;

import java.util.List;

public interface VoteService {
     Boolean vote(VoteReq voteReq);
     String shareLink(); //将作品分享出去 拉票 待定怎么做
     List<WorkDto> getRankingList();
}