package com.cskaoyan.mallSpringboot.service.promotion;


import com.cskaoyan.mallSpringboot.bean.Grouponrules;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

import java.util.Date;

public interface GrouponrulesService {
    ResponseVo queryGrouponrulesList(QueryIn queryIn,String goodsId);//查

    Grouponrules createGrouponrule(Grouponrules grouponrules);//增

    int update(Grouponrules record);//改

    int delete(Integer id, Date updateTime);//删


    //微信前端
    ResponseVo getMyGroupon(Integer userId,Integer showType);//我的拼团
    ResponseVo detail(Integer userId,Integer grouponId);//我的拼团-团购详情

    ResponseVo getWxGrouponList(int page, int size);

}
