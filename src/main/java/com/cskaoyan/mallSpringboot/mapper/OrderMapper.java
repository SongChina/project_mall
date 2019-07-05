package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.Order;
import com.cskaoyan.mallSpringboot.bean.OrderExample;
import java.util.List;

import com.cskaoyan.mallSpringboot.gss_vo.CustomerStatisticInfo;
import com.cskaoyan.mallSpringboot.gss_vo.GoodsStatisticInfo;
import com.cskaoyan.mallSpringboot.gss_vo.OrderStatisticInfo;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    //by wpm
    List<Order> queryOrderList(@Param("orderStatusArray") String[] orderStatusArray, @Param("orderSn") String orderSn, @Param("userId") String userId);

    Order queryOrderDetail(String id);
    //

    List<OrderStatisticInfo> queryOrdersByAddTimeInGroup();

    List<GoodsStatisticInfo> queryGoodsByAddTimeInGroup();

}