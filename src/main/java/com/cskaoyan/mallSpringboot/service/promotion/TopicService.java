package com.cskaoyan.mallSpringboot.service.promotion;

import com.cskaoyan.mallSpringboot.bean.Topic;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

import java.util.Date;

public interface TopicService {
    Topic createTopic(Topic topic);//增
    ResponseVo queryList(QueryIn queryIn, String title, String subtitle);//查
    int delete(Integer id, Date updateTime);//删
    int update(Topic topic);//改
}
