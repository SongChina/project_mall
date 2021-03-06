package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.Keyword;
import com.cskaoyan.mallSpringboot.bean.KeywordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KeywordMapper {
    long countByExample(KeywordExample example);

    int deleteByExample(KeywordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Keyword record);

    int insertSelective(Keyword record);

    List<Keyword> selectByExample(KeywordExample example);

    Keyword selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Keyword record, @Param("example") KeywordExample example);

    int updateByExample(@Param("record") Keyword record, @Param("example") KeywordExample example);

    int updateByPrimaryKeySelective(Keyword record);

    int updateByPrimaryKey(Keyword record);

    List<Keyword> queryKeywordList(@Param("keyword") String keyword, @Param("url") String url);

    int keywordInsert(Keyword keyword);

    int keywordUpdate(Keyword keyword);

    int keywordDelete(Keyword keyword);


    Keyword queryDefultKeyword();

    List<Keyword> queryHotKeywordList();

    String[] querySimpleKeyword(@Param("keyword") String keyword);
}