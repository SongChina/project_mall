package com.cskaoyan.mallSpringboot.service.promotion;


import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

public interface GrouponActivityService {
    ResponseVo queryList(QueryIn queryIn, String goodsId);//查

}
