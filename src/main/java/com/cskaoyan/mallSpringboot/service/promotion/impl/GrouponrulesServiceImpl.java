package com.cskaoyan.mallSpringboot.service.promotion.impl;


import com.cskaoyan.mallSpringboot.bean.*;
import com.cskaoyan.mallSpringboot.mapper.*;
import com.cskaoyan.mallSpringboot.service.promotion.GrouponService;
import com.cskaoyan.mallSpringboot.bean.Goods;
import com.cskaoyan.mallSpringboot.bean.GrouponIndex;
import com.cskaoyan.mallSpringboot.bean.Grouponrules;
import com.cskaoyan.mallSpringboot.mapper.GoodsMapper;
import com.cskaoyan.mallSpringboot.mapper.GrouponrulesMapper;
import com.cskaoyan.mallSpringboot.service.promotion.GrouponrulesService;
import com.cskaoyan.mallSpringboot.util.OrderUtil;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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
    @Autowired
    GrouponMapper grouponMapper;
    @Autowired
    GrouponService grouponService;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    OrdergoodsMapper ordergoodsMapper;


    @Override
    public ResponseVo queryGrouponrulesList(QueryIn queryIn, String goodsId) {
        HashMap<String, Object> data = new HashMap<>();
        /*if (goodsid != null){
            goodsid = "%" +goodsid +"%";
        }*/
        int total = grouponrulesMapper.queryCount(goodsId);
        data.put("total", total);
        //分页
        PageHelper.startPage(queryIn.getPage(), queryIn.getLimit());
        List<Grouponrules> list = grouponrulesMapper.queryList(queryIn.getSort(), queryIn.getOrder(), goodsId);
        PageInfo<Grouponrules> pageInfo = new PageInfo<>(list);
        data.put("items", pageInfo.getList());

        return new ResponseVo(0, data, "成功");
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
    public int delete(Integer id, Date updateTime) {
        //true对应数据库列deleted的值1，此为假删除做法
        //int i = grouponrulesMapper.deleteBydeleted(id, updateTime);
        int i = grouponrulesMapper.deleteByPrimaryKey(id);
        return i;
    }

    //微信前端-我的拼团

    @Override
    public ResponseVo getMyGroupon(Integer userId, Integer showType) {
        List<Groupon> myGroupons;
        if (showType == 0) {
            myGroupons = grouponService.queryMyGroupon(userId);
        } else {
            myGroupons = grouponService.queryMyJoinGroupon(userId);
        }
        List<Map<String, Object>> grouponVoList = new ArrayList<>(myGroupons.size());
        Order order;
        Grouponrules rules;
        User creator;
        for (Groupon groupon : myGroupons) {
            order = orderMapper.selectByPrimaryKey(groupon.getOrderId());
            rules = grouponrulesMapper.selectByPrimaryKey(groupon.getRulesId());
            creator = userMapper.selectByPrimaryKey(groupon.getCreatorUserId());

            Map<String, Object> grouponVo = new HashMap<>();
            //填充团购信息
            grouponVo.put("id", groupon.getId());
            grouponVo.put("groupon", groupon);
            grouponVo.put("rules", rules);
            grouponVo.put("creator", creator.getNickname());

            int linkGrouponId;
            // 这是一个团购发起记录
            if (groupon.getGrouponId() == 0) {
                linkGrouponId = groupon.getId();
                grouponVo.put("isCreator", creator.getId() == userId);
            } else {
                linkGrouponId = groupon.getGrouponId();
                grouponVo.put("isCreator", false);
            }
            int joinerCount = grouponService.countGroupon(linkGrouponId);
            grouponVo.put("joinerCount", joinerCount + 1);

            //填充订单信息
            grouponVo.put("orderId", order.getId());
            grouponVo.put("orderSn", order.getOrderSn());
            grouponVo.put("actualPrice", order.getActualPrice());
            grouponVo.put("orderStatusText", OrderUtil.orderStatusText(order));//
            grouponVo.put("handleOption", OrderUtil.build(order));//

            List<Ordergoods> ordergoodsList = ordergoodsMapper.queryByOid(order.getId());
            List<Map<String, Object>> ordergoodsVoList = new ArrayList<>(ordergoodsList.size());
            for (Ordergoods ordergoods : ordergoodsList) {
                Map<String, Object> ordergoodsVo = new HashMap<>();
                ordergoodsVo.put("id", ordergoods.getId());
                ordergoodsVo.put("goodsName", ordergoods.getGoodsName());
                ordergoodsVo.put("number", ordergoods.getNumber());
                ordergoodsVo.put("picUrl", ordergoods.getPicUrl());
                ordergoodsVoList.add(ordergoodsVo);
            }
            grouponVo.put("goodsList", ordergoodsVoList);
            grouponVoList.add(grouponVo);

        }

        HashMap<String, Object> result = new HashMap<>();
        result.put("count", grouponVoList.size());
        result.put("data", grouponVoList);
        return new ResponseVo(0, result, "成功");
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
