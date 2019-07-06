package com.cskaoyan.mallSpringboot.service.user;

import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

/**
 * @author AsidentVoice
 * @date 2019/7/6 15:03
 */
public interface FootPrintService {
    ResponseVo queryFootPrintList(QueryIn queryIn, String userId, String goodsId);
}






