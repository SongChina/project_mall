package com.cskaoyan.mallSpringboot.service.promotion.impl;

import com.cskaoyan.mallSpringboot.bean.Grouponrules;
import com.cskaoyan.mallSpringboot.mapper.GrouponrulesMapper;
import com.cskaoyan.mallSpringboot.service.promotion.GrouponrulesService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class GrouponrulesServiceImpl implements GrouponrulesService {
    @Autowired
    GrouponrulesMapper grouponrulesMapper;

    @Override
    public ResponseVo queryGrouponrulesList(QueryIn queryIn,String goodsId) {
        HashMap<String, Object> data = new HashMap<>();

        /*if (goodsid != null){
            goodsid = "%" +goodsid +"%";
        }*/

        int total = grouponrulesMapper.queryCount(goodsId);
        data.put("total",total);
        //分页
        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());
        List<Grouponrules> list = grouponrulesMapper.queryList(queryIn.getSort(),queryIn.getOrder(),goodsId);
        PageInfo<Grouponrules> pageInfo = new PageInfo<>(list);
        data.put("items",pageInfo.getList());

        return new ResponseVo(0,data,"成功");
    }
}
