package com.cskaoyan.mallSpringboot.service.promotion.impl;

import com.cskaoyan.mallSpringboot.bean.Groupon;
import com.cskaoyan.mallSpringboot.mapper.GrouponMapper;
import com.cskaoyan.mallSpringboot.service.promotion.GrouponService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrouponServiceImpl implements GrouponService {
    @Autowired
    GrouponMapper grouponMapper;

    @Override
    public List<Groupon> queryList(QueryIn queryIn, String goodsId) {

        /*if (goodsId != "" & goodsId != null) {
            goodsId = "%" + goodsId + "%";
        }*/

        //分页
        PageHelper.startPage(queryIn.getPage(), queryIn.getLimit());
        List<Groupon> list = grouponMapper.queryList(queryIn.getSort(), queryIn.getOrder(), goodsId);


        return list;
    }


}
