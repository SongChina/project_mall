package com.cskaoyan.mallSpringboot.service.promotion;


import com.cskaoyan.mallSpringboot.bean.Groupon;
import com.cskaoyan.mallSpringboot.vo.QueryIn;

import java.util.List;

public interface GrouponService {
    List<Groupon> queryList(QueryIn queryIn, String goodsId);//查
    //微信端
    List<Groupon> queryMyGroupon( Integer userId);
    List<Groupon> queryMyJoinGroupon( Integer userId);
    int countGroupon(Integer linkGrouponId);
    List<Groupon> queryJoinRecord(Integer id);

}
