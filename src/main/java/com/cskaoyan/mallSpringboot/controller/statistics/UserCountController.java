package com.cskaoyan.mallSpringboot.controller.statistics;

import com.cskaoyan.mallSpringboot.gss_vo.CustomerStatisticInfo;
import com.cskaoyan.mallSpringboot.gss_vo.StatisticsData;
import com.cskaoyan.mallSpringboot.gss_vo.StatisticsVo;
import com.cskaoyan.mallSpringboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.List;

@RestController
public class UserCountController {

    @Autowired
    UserMapper usermapper;

    @RequestMapping("stat/user")
    public StatisticsVo getUserStatistics(){
        List<CustomerStatisticInfo> customerStatisticInfos = usermapper.queryUserByAddTimeInGroup();

        StatisticsVo statisticsVo = new StatisticsVo();
        statisticsVo.setErrno(0);
        statisticsVo.setErrmsg("success");

        StatisticsData<CustomerStatisticInfo> data = new StatisticsData();
        data.setRows(customerStatisticInfos);
        data.setColumns(new String[]{"day", "users"});

/*        CustomerStatisticInfo temp = new CustomerStatisticInfo();
        Class<? extends CustomerStatisticInfo> aClass = temp.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();*/
        statisticsVo.setData(data);
        return statisticsVo;

    }

}
