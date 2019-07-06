package com.cskaoyan.mallSpringboot.controller.user;

import com.cskaoyan.mallSpringboot.service.SearchHistoryService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AsidentVoice
 * @date 2019/7/6 15:47
 */
@RestController
public class SearchHistoryController {
    @Autowired
    SearchHistoryService searchHistoryService;

    //搜索历史分类查询
    @RequestMapping("history/list")
    public ResponseVo SearchHistoryList(QueryIn queryIn,String userId,String keyword) {
        ResponseVo responseVo = searchHistoryService.querySearchHistoryList(queryIn,userId,keyword);
        return responseVo;
    }

}
