package com.cskaoyan.mallSpringboot;

import com.cskaoyan.mallSpringboot.bean.User;
import com.cskaoyan.mallSpringboot.bean.UserExample;
import com.cskaoyan.mallSpringboot.gss_vo.CustomerStatisticInfo;
import com.cskaoyan.mallSpringboot.mapper.UserMapper;
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

    @Test
    public void mapperTest() {

        //mapper.queryUserByAddTimeInGroup()

        //System.out.println(customerStatisticInfos);
    }
}
