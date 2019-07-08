package com.cskaoyan.mallSpringboot;

import com.cskaoyan.mallSpringboot.bean.Admin;
import com.cskaoyan.mallSpringboot.bean.AdminInWeb;
import com.cskaoyan.mallSpringboot.mapper.AdminInWebMapper;
import com.cskaoyan.mallSpringboot.mapper.AdminMapper;
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
public class AdminTest {
    @Autowired
    AdminMapper adminMapper;

    @Test
    public void mytest1() {
        List<Admin> admins = adminMapper.queryAllAdmins();
        System.out.println(admins);
    }

    @Test
    public void mytest2(){
        List<Admin> admins=adminMapper.queryAdminByName("admin");
        System.out.println(admins);
    }


    @Test
    public void mytest(){
        int i=adminMapper.deleteAdmin(12);
        System.out.println(i);
    }

    @Autowired
    AdminInWebMapper adminInWebMapper;
    @Test
    public void mytest99(){
/*        AdminInWeb adminInWeb = new AdminInWeb("333", "111", new int[]{1, 2});
        adminInWebMapper.insertAdmin(adminInWeb);*/
        Admin admin = new Admin();
        admin.setId(13);
        admin.setPassword("555");
        admin.setUsername("111");
        int i = adminMapper.updateByPrimaryKey(admin);
        System.out.println(i);

    }

}
