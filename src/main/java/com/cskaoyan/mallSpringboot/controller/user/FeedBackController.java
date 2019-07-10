package com.cskaoyan.mallSpringboot.controller.user;

import com.cskaoyan.mallSpringboot.bean.Feedback;
import com.cskaoyan.mallSpringboot.service.user.FeedBackService;
import com.cskaoyan.mallSpringboot.util.UserTokenManager;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping("wx/feedback/submit")
    public ResponseVo getFeedBackInfo(@RequestBody Feedback feedback, HttpServletRequest request){
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);

        ResponseVo responseVo = new ResponseVo();
        feedback.setUserId(userId);
        boolean flag = feedBackService.insertSingleFeedBack(feedback);

        if(flag){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else{
            responseVo.setErrmsg("失败");
        }
        return responseVo;

    }
}
