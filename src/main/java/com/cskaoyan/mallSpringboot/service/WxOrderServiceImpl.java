package com.cskaoyan.mallSpringboot.service;

import com.cskaoyan.mallSpringboot.bean.Order;
import com.cskaoyan.mallSpringboot.bean.OrderExample;
import com.cskaoyan.mallSpringboot.bean.Ordergoods;
import com.cskaoyan.mallSpringboot.bean.OrdergoodsExample;
import com.cskaoyan.mallSpringboot.gss_vo.GoodsStatisticInfo;
import com.cskaoyan.mallSpringboot.mapper.GoodsMapper;
import com.cskaoyan.mallSpringboot.mapper.OrderMapper;
import com.cskaoyan.mallSpringboot.mapper.OrdergoodsMapper;
import com.cskaoyan.mallSpringboot.renguopingVO.GoodsListInfo;
import com.cskaoyan.mallSpringboot.renguopingVO.HandleOption;
import com.cskaoyan.mallSpringboot.renguopingVO.OrderListInfo;
import com.cskaoyan.mallSpringboot.renguopingVO.WxResultVo;
import com.cskaoyan.mallSpringboot.util.UserTokenManager;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class WxOrderServiceImpl implements WxOrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrdergoodsMapper ordergoodsMapper;

    WxResultVo wxResultVo;
    ResponseVo responseVo;

    @Override
    public ResponseVo queryList(HttpServletRequest request, int showType, int page, int size) {
        wxResultVo=new WxResultVo();
        responseVo=new ResponseVo();

        PageHelper.startPage(page,size);

        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);

        switch(showType) {
            case 0:
                OrderExample orderExample=new OrderExample();
                 orderExample.createCriteria()
                         .andUserIdEqualTo(userId);
                List<Order> orders=orderMapper.selectByExample(orderExample);

                List<OrderListInfo> orderListInfos=new ArrayList<>();
                for(Order order:orders){
                    OrderListInfo orderListInfo=new OrderListInfo();
                    Short status=order.getOrderStatus();
                    switch(status){
                        case 101:
                            orderListInfo.setOrderStatusText("未支付");
                            HandleOption handleOption=new HandleOption(true,false,false,false,true,false,false);
                            orderListInfo.setHandleOption(handleOption);
                            break;
                        case 102:
                            orderListInfo.setOrderStatusText("已取消");
                            HandleOption handleOption2=new HandleOption(false,false,false,true,false,true,false);
                            orderListInfo.setHandleOption(handleOption2);
                            break;
                        case 103:
                            orderListInfo.setOrderStatusText("已取消(系统)");
                            HandleOption handleOption3=new HandleOption(false,false,false,true,false,true,false);
                            orderListInfo.setHandleOption(handleOption3);
                            break;
                        case 201:
                            orderListInfo.setOrderStatusText("已付款");
                            HandleOption handleOption4=new HandleOption(false,false,false,true,false,true,true);
                            orderListInfo.setHandleOption(handleOption4);
                            break;
                        case 202:
                            orderListInfo.setOrderStatusText("订单取消,退款中");
                            HandleOption handleOption5=new HandleOption(false,false,false,false,false,true,false);
                            orderListInfo.setHandleOption(handleOption5);
                            break;
                        case 301:
                            orderListInfo.setOrderStatusText("已发货");
                            HandleOption handleOption6=new HandleOption(false,false,true,false,false,true,true);
                            orderListInfo.setHandleOption(handleOption6);
                            break;
                        case 401:
                        case 402:
                            orderListInfo.setOrderStatusText("已收货");
                            HandleOption handleOption7=new HandleOption(false,true,false,true,false,true,false);
                            orderListInfo.setHandleOption(handleOption7);
                            break;
                    }
                    if(order.getGrouponPrice().equals(order.getGoodsPrice())){
                        orderListInfo.setGroup(false);
                    }else{
                        orderListInfo.setGroup(true);
                    }
                    orderListInfo.setOrderSn(order.getOrderSn());
                    orderListInfo.setId(order.getId());

                    OrdergoodsExample ordergoodsExample=new OrdergoodsExample();
                    ordergoodsExample.createCriteria()
                            .andOrderIdEqualTo(order.getId());
                    List<Ordergoods> ordergoodsList=ordergoodsMapper.selectByExample(ordergoodsExample);
                    List<GoodsListInfo> goodsListInfos=new ArrayList<>();
                    for(Ordergoods ordergoods:ordergoodsList){
                        GoodsListInfo goodsListInfo=new GoodsListInfo(
                                ordergoods.getGoodsId(),
                                ordergoods.getGoodsName(),
                                ordergoods.getNumber(),
                                ordergoods.getPicUrl()
                        );
                        goodsListInfos.add(goodsListInfo);
                    }
                    orderListInfo.setGoodsList(goodsListInfos);




                    orderListInfo.setActualPrice(order.getActualPrice());
                    orderListInfos.add(orderListInfo);

                }
                PageInfo<OrderListInfo> pageInfo=new PageInfo(orderListInfos);
                wxResultVo.setData(pageInfo.getList());
                wxResultVo.setCount((int)pageInfo.getTotal());
                wxResultVo.setTotalPages(pageInfo.getPages());

                break;


            case 1:
                OrderExample orderExample1=new OrderExample();
                orderExample1.createCriteria()
                        .andUserIdEqualTo(userId)
                        .andOrderStatusEqualTo((short)101);
                List<Order> orders1=orderMapper.selectByExample(orderExample1);
                List<OrderListInfo> orderListInfos1=new ArrayList<>();
                for(Order order:orders1){
                    OrderListInfo orderListInfo=new OrderListInfo();
                    orderListInfo.setOrderStatusText("未支付");
                    orderListInfo.setOrderSn(order.getOrderSn());
                    orderListInfo.setId(order.getId());
                    orderListInfo.setActualPrice(order.getActualPrice());


                    if(order.getGrouponPrice().equals(order.getGoodsPrice())){
                        orderListInfo.setGroup(false);
                    }else{
                        orderListInfo.setGroup(true);
                    }


                    OrdergoodsExample ordergoodsExample=new OrdergoodsExample();
                    ordergoodsExample.createCriteria()
                            .andOrderIdEqualTo(order.getId());
                    List<Ordergoods> ordergoodsList=ordergoodsMapper.selectByExample(ordergoodsExample);
                    List<GoodsListInfo> goodsListInfos=new ArrayList<>();

                    for(Ordergoods ordergoods:ordergoodsList){
                        GoodsListInfo goodsListInfo=new GoodsListInfo(
                                ordergoods.getGoodsId(),
                                ordergoods.getGoodsName(),
                                ordergoods.getNumber(),
                                ordergoods.getPicUrl()
                        );
                        goodsListInfos.add(goodsListInfo);
                    }
                    orderListInfo.setGoodsList(goodsListInfos);


                    HandleOption handleOption=new HandleOption(true,false,false,false,true,false,false);
                    orderListInfo.setHandleOption(handleOption);
                    orderListInfos1.add(orderListInfo);

                }
                PageInfo<OrderListInfo> pageInfo1=new PageInfo(orderListInfos1);
                wxResultVo.setData(pageInfo1.getList());
                wxResultVo.setCount((int)pageInfo1.getTotal());
                wxResultVo.setTotalPages(pageInfo1.getPageSize());
                break;


            case 2:
                OrderExample orderExample2=new OrderExample();
                orderExample2.createCriteria()
                        .andUserIdEqualTo(userId)
                        .andOrderStatusEqualTo((short)201);
                List<Order> orders2=orderMapper.selectByExample(orderExample2);
                List<OrderListInfo> orderListInfos2=new ArrayList<>();
                for(Order order:orders2){
                    OrderListInfo orderListInfo=new OrderListInfo();
                    orderListInfo.setOrderStatusText("已付款");
                    orderListInfo.setOrderSn(order.getOrderSn());
                    orderListInfo.setId(order.getId());
                    orderListInfo.setActualPrice(order.getActualPrice());


                    if(order.getGrouponPrice().equals(order.getGoodsPrice())){
                        orderListInfo.setGroup(false);
                    }else{
                        orderListInfo.setGroup(true);
                    }


                    OrdergoodsExample ordergoodsExample=new OrdergoodsExample();
                    ordergoodsExample.createCriteria()
                            .andOrderIdEqualTo(order.getId());
                    List<Ordergoods> ordergoodsList=ordergoodsMapper.selectByExample(ordergoodsExample);
                    List<GoodsListInfo> goodsListInfos=new ArrayList<>();

                    for(Ordergoods ordergoods:ordergoodsList){
                        GoodsListInfo goodsListInfo=new GoodsListInfo(
                                ordergoods.getGoodsId(),
                                ordergoods.getGoodsName(),
                                ordergoods.getNumber(),
                                ordergoods.getPicUrl()
                        );
                        goodsListInfos.add(goodsListInfo);
                    }
                    orderListInfo.setGoodsList(goodsListInfos);


                    HandleOption handleOption=new HandleOption(false,false,false,false,false,true,true);
                    orderListInfo.setHandleOption(handleOption);
                    orderListInfos2.add(orderListInfo);

                }
                PageInfo<OrderListInfo> pageInfo2=new PageInfo(orderListInfos2);
                wxResultVo.setData(pageInfo2.getList());
                wxResultVo.setCount((int)pageInfo2.getTotal());
                wxResultVo.setTotalPages(pageInfo2.getPageSize());
                break;

            case 3:
                OrderExample orderExample3=new OrderExample();
                orderExample3.createCriteria()
                        .andUserIdEqualTo(userId)
                        .andOrderStatusEqualTo((short)301);
                List<Order> orders3=orderMapper.selectByExample(orderExample3);
                List<OrderListInfo> orderListInfos3=new ArrayList<>();
                for(Order order:orders3){
                    OrderListInfo orderListInfo=new OrderListInfo();
                    orderListInfo.setOrderStatusText("已发货");
                    orderListInfo.setOrderSn(order.getOrderSn());
                    orderListInfo.setId(order.getId());
                    orderListInfo.setActualPrice(order.getActualPrice());


                    if(order.getGrouponPrice().equals(order.getGoodsPrice())){
                        orderListInfo.setGroup(false);
                    }else{
                        orderListInfo.setGroup(true);
                    }


                    OrdergoodsExample ordergoodsExample=new OrdergoodsExample();
                    ordergoodsExample.createCriteria()
                            .andOrderIdEqualTo(order.getId());
                    List<Ordergoods> ordergoodsList=ordergoodsMapper.selectByExample(ordergoodsExample);
                    List<GoodsListInfo> goodsListInfos=new ArrayList<>();

                    for(Ordergoods ordergoods:ordergoodsList){
                        GoodsListInfo goodsListInfo=new GoodsListInfo(
                                ordergoods.getGoodsId(),
                                ordergoods.getGoodsName(),
                                ordergoods.getNumber(),
                                ordergoods.getPicUrl()
                        );
                        goodsListInfos.add(goodsListInfo);
                    }
                    orderListInfo.setGoodsList(goodsListInfos);


                    HandleOption handleOption=new HandleOption(false,false,true,false,false,true,true);
                    orderListInfo.setHandleOption(handleOption);
                    orderListInfos3.add(orderListInfo);

                }
                PageInfo<OrderListInfo> pageInfo3=new PageInfo(orderListInfos3);
                wxResultVo.setData(pageInfo3.getList());
                wxResultVo.setCount((int)pageInfo3.getTotal());
                wxResultVo.setTotalPages(pageInfo3.getPageSize());
                break;
            case 4:
                OrderExample orderExample4=new OrderExample();
                orderExample4.createCriteria()
                        .andUserIdEqualTo(userId)
                        .andOrderStatusEqualTo((short)401);
                List<Order> orders4=orderMapper.selectByExample(orderExample4);
                List<OrderListInfo> orderListInfos4=new ArrayList<>();
                for(Order order:orders4){
                    OrderListInfo orderListInfo=new OrderListInfo();
                    orderListInfo.setOrderStatusText("已收货");
                    orderListInfo.setOrderSn(order.getOrderSn());
                    orderListInfo.setId(order.getId());
                    orderListInfo.setActualPrice(order.getActualPrice());


                    if(order.getGrouponPrice().equals(order.getGoodsPrice())){
                        orderListInfo.setGroup(false);
                    }else{
                        orderListInfo.setGroup(true);
                    }


                    OrdergoodsExample ordergoodsExample=new OrdergoodsExample();
                    ordergoodsExample.createCriteria()
                            .andOrderIdEqualTo(order.getId());
                    List<Ordergoods> ordergoodsList=ordergoodsMapper.selectByExample(ordergoodsExample);
                    List<GoodsListInfo> goodsListInfos=new ArrayList<>();

                    for(Ordergoods ordergoods:ordergoodsList){
                        GoodsListInfo goodsListInfo=new GoodsListInfo(
                                ordergoods.getGoodsId(),
                                ordergoods.getGoodsName(),
                                ordergoods.getNumber(),
                                ordergoods.getPicUrl()
                        );
                        goodsListInfos.add(goodsListInfo);
                    }
                    orderListInfo.setGoodsList(goodsListInfos);


                    HandleOption handleOption=new HandleOption(false,true,false,true,false,true,false);
                    orderListInfo.setHandleOption(handleOption);
                    orderListInfos4.add(orderListInfo);

                }
                PageInfo<OrderListInfo> pageInfo4=new PageInfo(orderListInfos4);
                wxResultVo.setData(pageInfo4.getList());
                wxResultVo.setCount((int)pageInfo4.getTotal());
                wxResultVo.setTotalPages(pageInfo4.getPageSize());
                break;
        }

        responseVo.setErrno(0);
        responseVo.setData(wxResultVo);
        responseVo.setErrmsg("成功");

        return responseVo;
    }
}
