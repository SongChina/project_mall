package com.cskaoyan.mallSpringboot.controller.mall;

import com.cskaoyan.mallSpringboot.bean.Issue;
import com.cskaoyan.mallSpringboot.bean.Keyword;
import com.cskaoyan.mallSpringboot.mapper.KeywordMapper;
import com.cskaoyan.mallSpringboot.service.mall.KeywordService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeywordController {

    @Autowired
    KeywordService keywordService;

    //查找
    @RequestMapping("keyword/list")
    public ResponseVo keyword(QueryIn queryIn, String keyword, String url){
        ResponseVo responseVo = keywordService.queryKeywordList(queryIn, keyword, url);
        return responseVo;
    }

    //新增
    @RequestMapping("keyword/create")
    public ResponseVo keywordCreate(@RequestBody Keyword keyword){
        ResponseVo responseVo = keywordService.keywordCreate(keyword);
        return responseVo;
    }

    //修改
    @RequestMapping("keyword/update")
    public ResponseVo keywordUpdate(@RequestBody Keyword keyword){
        ResponseVo responseVo = keywordService.keywordUpdate(keyword);
        return responseVo;
    }

    //删除
    @RequestMapping("keyword/delete")
    public ResponseVo keywordDelete(@RequestBody Keyword keyword){
        ResponseVo responseVo = keywordService.keywordDelete(keyword);
        return responseVo;
    }

}
