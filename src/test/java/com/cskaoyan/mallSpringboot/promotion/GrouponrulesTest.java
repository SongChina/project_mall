package com.cskaoyan.mallSpringboot.promotion;

import com.cskaoyan.mallSpringboot.bean.Grouponrules;
import com.cskaoyan.mallSpringboot.mapper.GrouponrulesMapper;
import com.cskaoyan.mallSpringboot.service.promotion.GrouponrulesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GrouponrulesTest {
    //Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    GrouponrulesMapper grouponrulesMapper;
    @Autowired
    GrouponrulesService grouponrulesService;

    @Test
    public void mytest1(){
        int i = grouponrulesMapper.queryCount("1109008");
       // System.out.println(i);
        //logger.info(i);
    }
    @Test
    public void mytest2(){
        List<Grouponrules> list = grouponrulesMapper.queryList("add_time","desc","1109008");
        //System.out.println(list);
        //logger.info(i);
    }
    @Test
    public void mytest3(){
        //ResponseVo vo = grouponrulesService.queryGrouponrulesList(new QueryIn(1,10,"add_time","desc"),"1109008");
        //System.out.println(list);
        //logger.info(i);
    }
}
