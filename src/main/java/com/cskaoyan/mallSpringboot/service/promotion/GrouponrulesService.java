package com.cskaoyan.mallSpringboot.service.promotion;


import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

public interface GrouponrulesService {
    ResponseVo queryGrouponrulesList(QueryIn queryIn,String goodsId);
}
