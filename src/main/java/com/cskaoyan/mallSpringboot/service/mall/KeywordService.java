package com.cskaoyan.mallSpringboot.service.mall;

import com.cskaoyan.mallSpringboot.bean.Keyword;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

public interface KeywordService {
    ResponseVo queryKeywordList(QueryIn queryIn, String keyword, String url);

    ResponseVo keywordCreate(Keyword keyword);

    ResponseVo keywordUpdate(Keyword keyword);

    ResponseVo keywordDelete(Keyword keyword);

    ResponseVo findIndexSearchMessage();

    ResponseVo searchHelper(String keyword);
}
