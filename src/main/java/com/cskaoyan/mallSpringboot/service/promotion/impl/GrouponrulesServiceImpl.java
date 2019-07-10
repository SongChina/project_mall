package com.cskaoyan.mallSpringboot.service.promotion.impl;

import com.cskaoyan.mallSpringboot.bean.Goods;
import com.cskaoyan.mallSpringboot.bean.GrouponIndex;
import com.cskaoyan.mallSpringboot.bean.Grouponrules;
import com.cskaoyan.mallSpringboot.mapper.GoodsMapper;
import com.cskaoyan.mallSpringboot.mapper.GrouponrulesMapper;
import com.cskaoyan.mallSpringboot.service.promotion.GrouponrulesService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class GrouponrulesServiceImpl implements GrouponrulesService {
    @Autowired
    GrouponrulesMapper grouponrulesMapper;
    @Autowired
    GoodsMapper goodsMapper;

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

    @Override
    public Grouponrules createGrouponrule(Grouponrules grouponrules) {
        //根据商品id获得对应商品信息goodsName、picUrl，封装进grouponrules
        Integer goodsId = grouponrules.getGoodsId();
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        grouponrules.setGoodsName(goods.getName());
        grouponrules.setPicUrl(goods.getPicUrl());
        grouponrules.setAddTime(new Date());
        grouponrules.setUpdateTime(new Date());
        grouponrules.setDeleted(false);

        int insert = grouponrulesMapper.insert(grouponrules);
        Integer id = grouponrulesMapper.lastInsertId();
        grouponrules.setId(id);
        return grouponrules;
    }

    @Override
    public int update(Grouponrules grouponrules) {
        int i = grouponrulesMapper.updateByPrimaryKey(grouponrules);
        return i;
    }

    @Override
    public int delete(Integer id,Date updateTime) {
        //true对应数据库列deleted的值1，此为假删除做法
        int i = grouponrulesMapper.deleteBydeleted(id,updateTime);
        return i;
    }
    //微信前台查询
    @Override
    public ResponseVo getWxGrouponList(int page, int size) {
        PageHelper.startPage(page, size);
        List<Grouponrules> grouponrulesList = grouponrulesMapper.selectAllGrouponRules();
        List<GrouponIndex> grouponIndexList = new ArrayList<>();
        for (Grouponrules grouponrules : grouponrulesList) {
            //获取商品表中的团购商品
            Goods goods = goodsMapper.selectIndexGoods(String.valueOf(grouponrules.getGoodsId()));
            //创建团购对象
            GrouponIndex grouponIndex = new GrouponIndex();
            //封装团购商品
            grouponIndex.setGoods(goods);
            //封装团购数量
            grouponIndex.setGroupon_member(grouponrules.getDiscountMember());
            //封装团购价格（此价格是商品零售价减去团购折扣）
            grouponIndex.setGroupon_price(goods.getRetailPrice().subtract(grouponrules.getDiscount()));
            //添加进团购list
            grouponIndexList.add(grouponIndex);
        }
        PageInfo<Grouponrules> pageInfo = new PageInfo<>(grouponrulesList);
        HashMap<String, Object> map = new HashMap<>();
        map.put("count", pageInfo.getTotal());
        map.put("data", grouponIndexList);
        return new ResponseVo(0, map, "成功");
    }
}
