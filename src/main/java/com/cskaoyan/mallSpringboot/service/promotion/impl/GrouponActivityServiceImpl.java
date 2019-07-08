package com.cskaoyan.mallSpringboot.service.promotion.impl;

import com.cskaoyan.mallSpringboot.bean.GrouponActivity;
import com.cskaoyan.mallSpringboot.mapper.GrouponActivityMapper;
import com.cskaoyan.mallSpringboot.service.promotion.GrouponActivityService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class GrouponActivityServiceImpl implements GrouponActivityService {
    @Autowired
    GrouponActivityMapper grouponActivityMapper;

    @Override
    public ResponseVo queryList(QueryIn queryIn,String goodsId) {
        HashMap<String, Object> data = new HashMap<>();

        int total = grouponActivityMapper.queryCount(goodsId);
        data.put("total",total);
        //分页
        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());
        List<GrouponActivity> list = grouponActivityMapper.queryList(queryIn.getSort(),queryIn.getOrder(),goodsId);
        PageInfo<GrouponActivity> pageInfo = new PageInfo<>(list);
        data.put("items",pageInfo.getList());

        return new ResponseVo(0,data,"成功");
    }


}
