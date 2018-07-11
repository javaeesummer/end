package com.rev.facade.revjugdement;

import com.rev.dto.common.UserDto;
import com.rev.dto.judgement.JudgeDto;

import java.util.List;

public interface JudegementService {

    //对一件作品得出最终得分(平均分)
    double avg(List<JudgeDto> judgeDtoList);

    //裁判对一个作品进行打分
    boolean judgeOneWork(JudgeDto judgeDto);

    //得到一个裁判历史的所有打分的作品记录,可能只要UserDto的userid字段
    List<JudgeDto> getHistoryJudge(UserDto userDto);
}
