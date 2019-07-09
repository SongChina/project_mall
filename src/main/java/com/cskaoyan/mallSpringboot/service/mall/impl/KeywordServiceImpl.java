package com.cskaoyan.mallSpringboot.service.mall.impl;

import com.cskaoyan.mallSpringboot.bean.Issue;
import com.cskaoyan.mallSpringboot.bean.Keyword;
import com.cskaoyan.mallSpringboot.bean.Searchhistory;
import com.cskaoyan.mallSpringboot.mapper.KeywordMapper;
import com.cskaoyan.mallSpringboot.mapper.SearchhistoryMapper;
import com.cskaoyan.mallSpringboot.service.mall.KeywordService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class KeywordServiceImpl implements KeywordService {

    @Autowired
    KeywordMapper keywordMapper;

    @Autowired
    SearchhistoryMapper searchhistoryMapper;

    //查找
    @Override
    public ResponseVo queryKeywordList(QueryIn queryIn, String keyword, String url) {
        PageHelper.startPage(queryIn.getPage(), queryIn.getLimit());
        HashMap<String, Object> map = new HashMap<>();
        if(keyword != null){
            keyword = "%" + keyword + "%";
        }
        if(url != null){
            url = "%" + url + "%";
        }
        List<Keyword> keywordList = keywordMapper.queryKeywordList(keyword, url);
        PageInfo<Keyword> pageInfo = new PageInfo<>(keywordList);
        map.put("total", pageInfo.getTotal());
        map.put("items", pageInfo.getList());
        return new ResponseVo(0, map, "成功");
    }

    //新增
    @Override
    public ResponseVo keywordCreate(Keyword keyword) {
        ResponseVo responseVo = new ResponseVo();
        Date date = new Date();
        keyword.setAddTime(date);
        keyword.setUpdateTime(date);
        int id = keywordMapper.keywordInsert(keyword);
        Keyword keyword1 = keywordMapper.selectByPrimaryKey(keyword.getId());
        if(id == 1 && keyword1 != null){
            responseVo.setErrno(0);
            responseVo.setData(keyword1);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(605);
            responseVo.setErrmsg("失败");
        }
        return responseVo;
    }

    //修改
    @Override
    public ResponseVo keywordUpdate(Keyword keyword) {
        ResponseVo responseVo = new ResponseVo();
        Date date = new Date();
        keyword.setUpdateTime(date);
        int update = keywordMapper.keywordUpdate(keyword);
        Keyword keyword1 = keywordMapper.selectByPrimaryKey(keyword.getId());
        if(update == 1){
            responseVo.setErrno(0);
            responseVo.setData(keyword1);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(605);
            responseVo.setErrmsg("失败");
        }
        return responseVo;
    }

    //删除
    @Override
    public ResponseVo keywordDelete(Keyword keyword) {
        ResponseVo responseVo = new ResponseVo();
        Date date = new Date();
        keyword.setUpdateTime(date);
        int delete = keywordMapper.keywordDelete(keyword);
        if(delete == 1){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(605);
            responseVo.setErrmsg("失败");
        }
        return responseVo;
    }
    //查询前台首页搜索记录
    @Override
    public ResponseVo findIndexSearchMessage() {
        Keyword defultKeyword = keywordMapper.queryDefultKeyword();
        List<Keyword> hotKeywordList = keywordMapper.queryHotKeywordList();
        List<Searchhistory> searchhistoryList = searchhistoryMapper.querySearchHistoryList(null, null);
        HashMap<String, Object> map = new HashMap<>();
        map.put("defaultKeyword", defultKeyword);
        map.put("hotKeywordList", hotKeywordList);
        map.put("historyKeywordList", searchhistoryList);
        return new ResponseVo(0, map, "成功");
    }

    //前台首页模糊搜索显示下拉框
    @Override
    public ResponseVo searchHelper(String keyword) {
        String[] keywords = keywordMapper.querySimpleKeyword(keyword);
        return new ResponseVo(0, keywords, "成功");
    }
}
