package com.cskaoyan.mallSpringboot.service.user;

import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

/**
 * @author AsidentVoice
 * @date 2019/7/6 16:23
 */
public interface FeedBackService {

    ResponseVo queryFeedBackList(QueryIn queryIn, String id, String username);
}
