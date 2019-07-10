package com.cskaoyan.mallSpringboot.service.user.impl;

import com.cskaoyan.mallSpringboot.bean.Collect;
import com.cskaoyan.mallSpringboot.bean.Feedback;
import com.cskaoyan.mallSpringboot.bean.User;
import com.cskaoyan.mallSpringboot.mapper.FeedbackMapper;
import com.cskaoyan.mallSpringboot.mapper.UserMapper;
import com.cskaoyan.mallSpringboot.service.user.FeedBackService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author AsidentVoice
 * @date 2019/7/6 16:24
 */
@Service
public class FeedBackServiceImpl implements FeedBackService {
    @Autowired
    FeedbackMapper feedbackMapper;

    @Override
    public ResponseVo queryFeedBackList(QueryIn queryIn, String id, String username) {
        HashMap<String, Object> map = new HashMap<>();
        if (id!=null) {
            //通过百度查询个数据类型转换问题String转换为Integer：  Integer it = Integer.valueOf(str);  it str都为变量
            //此方法与本项目无关，这里接受数据用的String类型，定义的方法和bean中的数据类型无关
            //Integer只能转换为数字类型，不能%模糊查询
            id = "%" + id + "%";
        }
        if (username!=null) {
            username = "%" + username + "%";
        }

        int total = feedbackMapper.queryFeedBackCount(id,username);

        map.put("total",total);
        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());
        List<Feedback> feedbackList = feedbackMapper.queryFeedBackList(id, username);
        map.put("items",feedbackList);
        return new ResponseVo(0,map,"成功");
    }

    @Autowired
    UserMapper userMapper;
    @Override
    public boolean insertSingleFeedBack(Feedback feedback) {
        User user = userMapper.selectByPrimaryKey(feedback.getUserId());
        feedback.setUsername(user.getUsername());
        feedback.setAddTime(new Date());
        feedback.setStatus(0);
        int insert = feedbackMapper.insert(feedback);
        if (insert > 0){
            return true;
        }
        return false;
    }
}
