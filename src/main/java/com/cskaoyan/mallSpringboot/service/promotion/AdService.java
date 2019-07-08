package com.cskaoyan.mallSpringboot.service.promotion;

import com.cskaoyan.mallSpringboot.bean.Ad;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

import java.util.Date;

public interface AdService {
    Ad createAd(Ad ad);//增
    ResponseVo queryList(QueryIn queryIn, String name, String content);//查
    int delete(Integer id, Date updateTime);//删
    int update(Ad ad);//改
}
