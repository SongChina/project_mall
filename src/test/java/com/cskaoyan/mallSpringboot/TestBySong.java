package com.cskaoyan.mallSpringboot;

import com.cskaoyan.mallSpringboot.bean.User;
import com.cskaoyan.mallSpringboot.bean.UserExample;
import com.cskaoyan.mallSpringboot.gss_vo.CustomerStatisticInfo;
import com.cskaoyan.mallSpringboot.gss_vo.OrderStatisticInfo;
import com.cskaoyan.mallSpringboot.mapper.GoodsMapper;
import com.cskaoyan.mallSpringboot.mapper.OrderMapper;
import com.cskaoyan.mallSpringboot.mapper.UserMapper;
import com.cskaoyan.mallSpringboot.utils.MD5Util;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
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
    GoodsMapper goodsMapper;

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

/*        String[] strings = {"111", "222", "333"};
        System.out.println(strings);*/
/*        String mall123 = MD5Util.encode("mall123");
        String promotion123 = MD5Util.encode("promotion123");
        System.out.println(mall123);
        System.out.println(promotion123);*/
        String admin123 = MD5Util.encode("admin123");
        String promotion123 = MD5Util.encode("promotion123");
        String mall123 = MD5Util.encode("mall123");
        System.out.println(admin123);
        System.out.println(promotion123);
        System.out.println(mall123);
    }
}
