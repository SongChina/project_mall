package com.cskaoyan.mallSpringboot.controller.user;

import com.cskaoyan.mallSpringboot.service.user.UserService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AsidentVoice
 * @date 2019/7/4 21:50
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    //会员管理分类查询
    @RequestMapping("user/list")
    public ResponseVo userList(QueryIn queryIn, String username, String mobile) {
        ResponseVo responseVo = userService.queryUserList(queryIn, username, mobile);
        return responseVo;
    }
}

