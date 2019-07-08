package com.cskaoyan.mallSpringboot.promotion;

import com.cskaoyan.mallSpringboot.bean.Coupon;
import com.cskaoyan.mallSpringboot.mapper.CouponMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CouponTest {
    @Autowired
    CouponMapper couponMapper;


    @Test
    public void mytest1(){
        int i = couponMapper.queryCount("%券%","0","0");
        System.out.println(i);
    }
    @Test
    public void mytest2(){
        List<Coupon> list = couponMapper.queryList("%券%","0","0", "add_time", "desc");
        System.out.println(list.get(0));
    }
    /*@Test
    public void mytest3(){
        int i = topicMapper.deleteBydeleted(314, new Date());
        System.out.println(i);
    }
    @Test
    public void mytest4(){

    }*/
}
