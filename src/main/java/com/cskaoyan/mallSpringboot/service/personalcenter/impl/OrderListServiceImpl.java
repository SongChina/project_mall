package com.cskaoyan.mallSpringboot.service.personalcenter.impl;

import com.cskaoyan.mallSpringboot.bean.*;
import com.cskaoyan.mallSpringboot.mapper.OrderListMapper;
import com.cskaoyan.mallSpringboot.mapper.OrderMapper;
import com.cskaoyan.mallSpringboot.mapper.OrdergoodsMapper;
import com.cskaoyan.mallSpringboot.service.personalcenter.OrderListService;
import com.cskaoyan.mallSpringboot.util.UserTokenManager;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/*@Service
public class OrderListServiceImpl implements OrderListService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrdergoodsMapper ordergoodsMapper;
    @Autowired
    OrderListMapper orderListMapper;


    @Override
    public ResponseVo orderShowType(int showType, int page, int size, HttpServletRequest request) {
        ResponseVo responseVo = new ResponseVo();
        //通过请求头获得userId，进而可以获得一切关于user的信息
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        OrderExample.Criteria criteria1 = criteria.andUserIdEqualTo(userId);
        List<OrderList> orderLists = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        OrderHandleOption orderHandleOption = new OrderHandleOption();

        if (showType == 0){
            OrderHandleOption orderHandleOption0 = new OrderHandleOption(false,false,false,true,false,false,false);
            List<Order> orders0 = orderMapper.selectByExample(orderExample);
            orderHandleOption = orderHandleOption0;
            orders = orders0;

        }else if (showType == 1){
            OrderHandleOption orderHandleOption1 = new OrderHandleOption(true,false,false,true,true,false,false);
            criteria1.andOrderStatusEqualTo((short) 101);
            List<Order> orders1 = orderMapper.selectByExample(orderExample);
            orderHandleOption = orderHandleOption1;
            orders = orders1;

        }else if (showType == 2){
            OrderHandleOption orderHandleOption2 = new OrderHandleOption(true,false,false,false,false,false,false);
            criteria1.andOrderStatusEqualTo((short) 201);
            List<Order> orders2 = orderMapper.selectByExample(orderExample);
            orderHandleOption = orderHandleOption2;
            orders = orders2;

        }else if (showType == 3){
            OrderHandleOption orderHandleOption3 = new OrderHandleOption(false,false,true,false,false,false,false);
            criteria1.andOrderStatusEqualTo((short) 301);
            List<Order> orders3 = orderMapper.selectByExample(orderExample);
            orderHandleOption = orderHandleOption3;
            orders = orders3;

        }else if (showType == 4){
            OrderHandleOption orderHandleOption4 = new OrderHandleOption(false,true,false,false,false,false,false);
            criteria1.andOrderStatusEqualTo((short) 401);
            List<Order> orders4 = orderMapper.selectByExample(orderExample);
            orderHandleOption = orderHandleOption4;
            orders  = orders4;
        }
        for (Order order:orders) {
            //获取每个订单的ID
            Integer orderId = order.getId();
            //获取每个订单的商品
            List<OrderGood> goodsList = ordergoodsMapper.selectGoodsByOrderId(orderId);
            OrderList orderList = orderListMapper.selectById(orderId);
            orderList.setGroupin(false);
            orderList.setGoodList(goodsList);
            orderList.setHandleOptions(orderHandleOption);
            orderLists.add(orderList);
        }
        int count = orderLists.size();
        int totalPage = count / size ;
        OrderListData orderListData = new OrderListData(count,totalPage,orderLists);
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        responseVo.setData(orderListData);
        return responseVo;

    }

}*/
