package com.cskaoyan.mallSpringboot.service.promotion.impl;

import com.cskaoyan.mallSpringboot.bean.Topic;
import com.cskaoyan.mallSpringboot.mapper.TopicMapper;
import com.cskaoyan.mallSpringboot.service.promotion.TopicService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicMapper topicMapper;

    @Override
    public Topic createTopic(Topic topic) {
        topic.setAddTime(new Date());
        topic.setUpdateTime(new Date());
        topic.setDeleted(false);

        int insert = topicMapper.insert(topic);
        Integer id = topicMapper.lastInsertId();
        topic.setId(id);
        return topic;
    }

    @Override
    public ResponseVo queryList(QueryIn queryIn, String title, String subtitle) {
        //data用来装条件查询所得total topicList
        HashMap<String, Object> data = new HashMap<>();
        //条件,用于模糊查询
        if (title != null & title != ""){
            title = "%" + title + "%";
        }
        if (subtitle != null & subtitle != ""){
            subtitle = "%" + subtitle + "%";
        }
        int total = topicMapper.queryCount(title,subtitle);
        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());
        List<Topic> list = topicMapper.queryList(title, subtitle, queryIn.getSort(), queryIn.getOrder());
        PageInfo<Topic> pageInfo = new PageInfo<>(list);
        data.put("total",total);
        data.put("items",pageInfo.getList());

        return new ResponseVo(0,data,"成功");
    }

    @Override
    public int delete(Integer id,Date updateTime) {
        //true对应数据库列deleted的值1，此为假删除做法
        int i = topicMapper.deleteBydeleted(id,updateTime);
        return i;
    }

    @Override
    public int update(Topic topic) {
        int i = topicMapper.updateByPrimaryKey(topic);
        return i;
    }
}
