package com.cskaoyan.mallSpringboot.promotion;

import com.cskaoyan.mallSpringboot.bean.Topic;
import com.cskaoyan.mallSpringboot.mapper.TopicMapper;
import com.cskaoyan.mallSpringboot.service.promotion.TopicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TopicTest {
    @Autowired
    TopicMapper topicMapper;
    @Autowired
    TopicService topicService;

    @Test
    public void mytest1(){
        int i = topicMapper.queryCount("%条%", "%百%");
        System.out.println(i);
    }
    @Test
    public void mytest2(){
        List<Topic> list = topicMapper.queryList("%的%", "%好%", "add_time", "desc");
        System.out.println(list.get(0));
    }
    @Test
    public void mytest3(){
        int i = topicMapper.deleteBydeleted(314, new Date());
        System.out.println(i);
    }
    @Test
    public void mytest4(){

    }
}
