package com.cskaoyan.mallSpringboot.controller.user;

import com.cskaoyan.mallSpringboot.service.user.FeedBackService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AsidentVoice
 * @date 2019/7/6 16:18
 */
@RestController
public class FeedBackController {
    @Autowired
    FeedBackService feedBackService;

    //意见反馈分类查询
    @RequestMapping("admin/feedback/list")
    public ResponseVo feedbackList(QueryIn queryIn,String id,String username){
        ResponseVo responseVo = feedBackService.queryFeedBackList(queryIn,id,username);
        return  responseVo;
    }
}
