package com.rev.revuser.dao;

import com.rev.revuser.bean.CompanyUserBean;

/**
 * @author hxs
 * @desprition 用来干嘛的呢, 也就是随便写写的
 **/

public interface CompanyUserBeanMapper {
    CompanyUserBean selectByOption(CompanyUserBean companyUserBean);
    void insert(CompanyUserBean companyUserBean);
}
