package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.Goods;
import com.cskaoyan.mallSpringboot.bean.OrderGood;
import com.cskaoyan.mallSpringboot.bean.Ordergoods;
import com.cskaoyan.mallSpringboot.bean.OrdergoodsExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;




import java.util.List;
@Component
public interface OrdergoodsMapper {
    long countByExample(OrdergoodsExample example);

    int deleteByExample(OrdergoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Ordergoods record);

    int insertSelective(Ordergoods record);

    List<Ordergoods> selectByExample(OrdergoodsExample example);

    Ordergoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Ordergoods record, @Param("example") OrdergoodsExample example);

    int updateByExample(@Param("record") Ordergoods record, @Param("example") OrdergoodsExample example);

    int updateByPrimaryKeySelective(Ordergoods record);

    int updateByPrimaryKey(Ordergoods record);


    //我的订单
    List<OrderGood> selectGoodsByOrderId(@Param("id")int id);
    //微信前端-我的拼团
    List<Ordergoods> queryByOid(Integer orderId);

}