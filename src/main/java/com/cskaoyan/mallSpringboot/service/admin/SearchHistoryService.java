package com.cskaoyan.mallSpringboot.service.admin;

import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

/**
 * @author AsidentVoice
 * @date 2019/7/6 16:00
 */
public interface SearchHistoryService {

    ResponseVo querySearchHistoryList(QueryIn queryIn, String userId, String keyword);
}
