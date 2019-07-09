package com.cskaoyan.mallSpringboot.controller.statistics;

import com.cskaoyan.mallSpringboot.gss_vo.*;
import com.cskaoyan.mallSpringboot.mapper.OrderMapper;
import com.cskaoyan.mallSpringboot.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.List;

@RestController
@Api(tags = {"statisticTags","tage"},value = "statisticValue")
public class StatisticController {

    @DateTimeFormat(pattern="yyyy-MM-dd")

    @Autowired
    UserMapper usermapper;

    @RequestMapping(value = "admin/stat/user", method = RequestMethod.GET)
    @ApiOperation(value = "getUserStatistics", notes = "这是获取用户统计数据的测试")
    public StatisticsVo getUserStatistics(){
        List<CustomerStatisticInfo> customerStatisticInfos = usermapper.queryUserByAddTimeInGroup();

        StatisticsVo statisticsVo = new StatisticsVo();
        statisticsVo.setErrno(0);
        statisticsVo.setErrmsg("success");

        StatisticsData<CustomerStatisticInfo> data = new StatisticsData();
        data.setRows(customerStatisticInfos);

        CustomerStatisticInfo temp = new CustomerStatisticInfo();
        Class<? extends CustomerStatisticInfo> aClass = temp.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        String[] columns = new String[declaredFields.length];
        int i = 0;

        for (Field declaredField : declaredFields) {
            columns[i] = declaredField.getName();
            i ++;
        }

        data.setColumns(columns);
        statisticsVo.setData(data);
        return statisticsVo;
    }

    @Autowired
    OrderMapper orderMapper;

    @RequestMapping("admin/stat/order")
    public StatisticsVo getOrderStatistics() {
        List<OrderStatisticInfo> orderStatisticInfos = orderMapper.queryOrdersByAddTimeInGroup();

        StatisticsVo statisticsVo = new StatisticsVo();
        statisticsVo.setErrno(0);
        statisticsVo.setErrmsg("success");

        StatisticsData<OrderStatisticInfo> data = new StatisticsData();
        data.setRows(orderStatisticInfos);

        OrderStatisticInfo temp = new OrderStatisticInfo();
        Class<? extends OrderStatisticInfo> aClass = temp.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        String[] columns = new String[declaredFields.length];
        int i = 0;

        for (Field declaredField : declaredFields) {
            columns[i] = declaredField.getName();
            i ++;
        }

        data.setColumns(columns);
        statisticsVo.setData(data);
        return statisticsVo;
    }

    @RequestMapping("admin/stat/goods")
    public StatisticsVo getGoodsStatistics() {
        List<GoodsStatisticInfo> goodsStatisticInfos = orderMapper.queryGoodsByAddTimeInGroup();

        StatisticsVo statisticsVo = new StatisticsVo();
        statisticsVo.setErrno(0);
        statisticsVo.setErrmsg("success");

        StatisticsData<GoodsStatisticInfo> data = new StatisticsData();
        data.setRows(goodsStatisticInfos);

        GoodsStatisticInfo temp = new GoodsStatisticInfo();
        Class<? extends GoodsStatisticInfo> aClass = temp.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        String[] columns = new String[declaredFields.length];
        int i = 0;

        for (Field declaredField : declaredFields) {
            columns[i] = declaredField.getName();
            i ++;
        }

        data.setColumns(columns);
        statisticsVo.setData(data);
        return statisticsVo;
    }

/*
    private StatisticsVo pack(StatisticsVo statisticsVo, Object rowType, Object rows){
        statisticsVo.setErrno(0);
        statisticsVo.setErrmsg("success");

        Class<?> aClass = rowType.getClass();
        StatisticsData<aClass> data = new StatisticsData();

    }
*/


}
