package com.cskaoyan.mallSpringboot;

import com.cskaoyan.mallSpringboot.bean.Admin;
import com.cskaoyan.mallSpringboot.bean.Order;
import com.cskaoyan.mallSpringboot.bean.OrderExample;
import com.cskaoyan.mallSpringboot.bean.Ordergoods;
import com.cskaoyan.mallSpringboot.mapper.AdminMapper;
import com.cskaoyan.mallSpringboot.mapper.OrderMapper;
import com.cskaoyan.mallSpringboot.mapper.OrdergoodsMapper;
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
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrdergoodsMapper ordergoodsMapper;

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

    @Test
    public void mytest99(){
/*        AdminInWeb adminInWeb = new AdminInWeb("333", "111", new int[]{1, 2});
        adminInWebMapper.insertAdmin(adminInWeb);*/
        Admin admin = new Admin();
        admin.setPassword("555");
        admin.setUsername("111");
        admin.setAvatar(null);
        admin.setRoleIds(new int[]{1});
        int i = adminMapper.insertAdmin(admin);
        System.out.println(i);

    }
    @Test
    public void mytest10(){
        OrderExample orderExample=new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.getAllCriteria();
        List<Order> orders=orderMapper.selectByExample(orderExample);
        System.out.println(orders);
    }


}
