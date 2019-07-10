package com.cskaoyan.mallSpringboot;

import com.cskaoyan.mallSpringboot.bean.*;
import com.cskaoyan.mallSpringboot.bean.systempermission.Data;
import com.cskaoyan.mallSpringboot.bean.systempermission.SystemPermission;
import com.cskaoyan.mallSpringboot.gss_vo.CustomerStatisticInfo;
import com.cskaoyan.mallSpringboot.gss_vo.OrderStatisticInfo;
import com.cskaoyan.mallSpringboot.mapper.*;

import com.cskaoyan.mallSpringboot.renguopingVO.ResponseVo;
import com.cskaoyan.mallSpringboot.utils.MD5Util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mysql.fabric.Response;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
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
import java.lang.System;
import java.nio.charset.Charset;
import java.util.ArrayList;
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

    @Autowired
    PermissionMapper permissionMapper;

    @Autowired
    FeedbackMapper feedbackMapper;

    @Autowired
    AddressMapper addressMapper;

    @Test
    public void mapperTest() throws IOException {

 /*       File file = new File("src/main/resources/data.json");
        String content = FileUtils.readFileToString(file, "utf8");
        Gson gson = new Gson();
       Data data= gson.fromJson(content, Data.class);
        System.out.println(data);

        String 你要设置的密码 = MD5Util.encode("你要设置的密码");
        System.out.println(你要设置的密码);*/
        /*ArrayList<Permission> permissions = new ArrayList<>();
        Permission permission = new Permission();
        permission.setRoleId(2);
        permission.setPermission("111");

        Permission permission1 = new Permission();
        permission1.setRoleId(3);
        permission1.setPermission("222");

        permissions.add(permission);
        permissions.add(permission1);
        int i = permissionMapper.insertInBatch(permissions);
        System.out.println(i);*/
       /* List<Feedback> feedbacks = feedbackMapper.queryFeedBackList(null, null);
        System.out.println(feedbacks);*/
        AddressDetail addressDetail = addressMapper.selectByPrimaryKey2(1);
        System.out.println(addressDetail);

        Address address = addressMapper.selectByPrimaryKey(1);
        System.out.println(address);
    }
}
