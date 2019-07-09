package com.cskaoyan.mallSpringboot;

import com.cskaoyan.mallSpringboot.bean.GoodsInWeb;
import com.cskaoyan.mallSpringboot.bean.User;
import com.cskaoyan.mallSpringboot.bean.UserExample;
import com.cskaoyan.mallSpringboot.gss_vo.CustomerStatisticInfo;
import com.cskaoyan.mallSpringboot.gss_vo.OrderStatisticInfo;
import com.cskaoyan.mallSpringboot.mapper.GoodsMapper;

import com.cskaoyan.mallSpringboot.mapper.GoodsInWebMapper;
import com.cskaoyan.mallSpringboot.mapper.OrderMapper;
import com.cskaoyan.mallSpringboot.mapper.UserMapper;
import com.cskaoyan.mallSpringboot.renguopingVO.ResponseVo;
import com.cskaoyan.mallSpringboot.utils.MD5Util;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mysql.fabric.Response;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
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

    GoodsInWebMapper goodsInWebMapper;
    @Test
    public void mapperTest() throws IOException {

        //File file = new File("src/main/resources/data.json");
        //String content = FileUtils.readFileToString(file);
        //(ResponseVo) new JsonParser().parse(content);
        //System.out.println(jsonObject);
    }
}
