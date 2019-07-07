package com.cskaoyan.mallSpringboot.service.user;

import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

/**
 * @author AsidentVoice
 * @date 2019/7/4 22:03
 */
public interface UserService {
    ResponseVo queryUserList(QueryIn queryIn, String username, String mobile);
}
