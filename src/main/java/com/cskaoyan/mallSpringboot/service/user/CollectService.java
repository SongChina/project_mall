package com.cskaoyan.mallSpringboot.service.user;

import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

/**
 * @author AsidentVoice
 * @date 2019/7/5 17:57
 */
public interface CollectService {
    ResponseVo queryCollectList(QueryIn queryIn, String userId, String valueId);
}





