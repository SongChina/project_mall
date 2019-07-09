package com.cskaoyan.mallSpringboot.service.user;

import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

/**
 * @author AsidentVoice
 * @date 2019/7/5 15:19
 */
public interface AddressService {
    ResponseVo queryAddressList(QueryIn queryIn, String userId, String name);
}
