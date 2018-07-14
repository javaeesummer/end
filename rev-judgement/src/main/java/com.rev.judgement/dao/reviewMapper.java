package com.rev.judgement.dao;

import com.rev.judgement.entity.review;

public interface reviewMapper {
    int deleteByPrimaryKey(Integer reviewid);

    int insert(review record);

    int insertSelective(review record);

    review selectByPrimaryKey(Integer reviewid);

    int updateByPrimaryKeySelective(review record);

    int updateByPrimaryKey(review record);
}