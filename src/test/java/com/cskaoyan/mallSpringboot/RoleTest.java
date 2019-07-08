package com.cskaoyan.mallSpringboot;

import com.cskaoyan.mallSpringboot.bean.Role;
import com.cskaoyan.mallSpringboot.mapper.RoleMapper;
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
public class RoleTest {
    @Autowired
    RoleMapper roleMapper;

    @Test
    public void mytest(){
        List<Role> roles=roleMapper.queryAllRole();
        System.out.println(roles);
    }
}
