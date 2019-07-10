package com.cskaoyan.mallSpringboot;

import com.cskaoyan.mallSpringboot.mapper.GoodsMapper;

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

import java.io.IOException;

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

    GoodsInWebMapper goodsInWebMapper;
    @Test
    public void mapperTest() throws IOException {

        //File file = new File("src/main/resources/data.json");
        //String content = FileUtils.readFileToString(file);
        //(ResponseVo) new JsonParser().parse(content);
        //System.out.println(jsonObject);
        String encode = MD5Util.encode("123");
        System.out.println(encode);
    }
}
