package com.cskaoyan.mallSpringboot.service.mall.impl;

import com.cskaoyan.mallSpringboot.bean.Order;
import com.cskaoyan.mallSpringboot.bean.Ordergoods;
import com.cskaoyan.mallSpringboot.mapper.OrderMapper;
import com.cskaoyan.mallSpringboot.service.mall.OrderService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    //查找订单
    @Override
    public ResponseVo orderList(QueryIn queryIn, String[] orderStatusArray, String orderSn, String userId) {
        PageHelper.startPage(queryIn.getPage(), queryIn.getLimit());
        if(orderSn != null){
            orderSn = "%" + orderSn + "%";
        }
        if(userId != null){
            userId = "%" + userId + "%";
        }
        /*//数组转换为字符串
        StringBuffer sb = new StringBuffer();
        for (String s : orderStatusArray) {
            sb.append(s).append(",");
        }
        String orderStatus = sb.substring(0, sb.length()-1);*/
        List<Order> orderList = orderMapper.queryOrderList(orderStatusArray, orderSn, userId);
        PageInfo<Order> pageInfo = new PageInfo<>(orderList);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("items", pageInfo.getList());
        return new ResponseVo(0, map, "成功");
    }

    //查询订单详情
    @Override
    public ResponseVo orderDetail(String id) {
        Order order = orderMapper.queryOrderDetail(id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("orderGoods", order.getOrdergoodsList());
        map.put("user", order.getUser());
        map.put("order", order);

        return new ResponseVo(0, map, "成功");
    }
}
