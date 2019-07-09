package com.cskaoyan.mallSpringboot.controller.promotion;

import com.cskaoyan.mallSpringboot.bean.Topic;
import com.cskaoyan.mallSpringboot.service.promotion.TopicService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.cskaoyan.mallSpringboot.vo.promotion.ErrorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
public class TopicController {
    @Autowired
    TopicService topicService;
    //查
    @RequestMapping("admin/topic/list")
    public ResponseVo queryTopicList(QueryIn queryIn,String title,String subtitle){
        ResponseVo responseVo = topicService.queryList(queryIn, title, subtitle);
        return responseVo;
    }
    @RequestMapping("admin/topic/create")
    public Object createTopic(@RequestBody Topic topic){
        try {
            Topic data = topicService.createTopic(topic);
            return new ResponseVo(0,data,"成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorVo(401,"参数不对");
        }
    }
    //update
    @RequestMapping("admin/topic/update")
    public Object update(@RequestBody Topic topic) {
        topic.setUpdateTime(new Date());
        topic.setDeleted(false);
        try {
            topicService.update(topic);
            return new ResponseVo(0, topic,"成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorVo(401,"参数不对");
        }
    }
    //delete
    @RequestMapping("admin/topic/delete")
    public ErrorVo delete(@RequestBody Topic topic) {
        Integer id = topic.getId();
        Date updateTime = topic.getUpdateTime();
        try {
            topicService.delete(id,updateTime);
            return new ErrorVo(0, "成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorVo(401,"删除失败，稍后重试");
        }
    }
}
