package com.cskaoyan.mallSpringboot;

import com.cskaoyan.mallSpringboot.bean.GoodsInWeb;
import com.cskaoyan.mallSpringboot.bean.User;
import com.cskaoyan.mallSpringboot.bean.UserExample;
import com.cskaoyan.mallSpringboot.gss_vo.CustomerStatisticInfo;
import com.cskaoyan.mallSpringboot.gss_vo.OrderStatisticInfo;
import com.cskaoyan.mallSpringboot.mapper.GoodsInWebMapper;
import com.cskaoyan.mallSpringboot.mapper.OrderMapper;
import com.cskaoyan.mallSpringboot.mapper.UserMapper;
import com.cskaoyan.mallSpringboot.utils.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan(basePackages = "com.cskaoyan.mallSpringboot.mapper")
public class TestBySong {
    @Autowired
    UserMapper mapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    GoodsInWebMapper goodsInWebMapper;
    @Test
    public void mapperTest() {

/*        List<OrderStatisticInfo> orderStatisticInfos = orderMapper.queryOrdersByAddTimeInGroup();
        System.out.println(orderStatisticInfos);*/
        //mapper.queryUserByAddTimeInGroup()

        //System.out.println(customerStatisticInfos);
/*        MyPasswordEncoder myPasswordEncoder = new MyPasswordEncoder();
        Object o = new Object();
        String s = myPasswordEncoder.encodePassword("123456", new Object());
        boolean passwordValid = myPasswordEncoder.isPasswordValid(s, "123456", new Object());
        System.out.println(passwordValid);*/
        GoodsInWeb goodsInWeb = new GoodsInWeb();
        //goodsInWeb.setId(99999999);
        goodsInWeb.setGallery(new String[]{"111","222"});
        goodsInWeb.setGoodsSn("32344");
        goodsInWeb.setName("43434");

        goodsInWebMapper.insert(goodsInWeb);
    }
}
