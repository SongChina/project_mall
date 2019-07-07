package com.cskaoyan.mallSpringboot.service.mall.impl;

import com.cskaoyan.mallSpringboot.bean.Issue;
import com.cskaoyan.mallSpringboot.mapper.IssueMapper;
import com.cskaoyan.mallSpringboot.service.mall.IssueService;
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
public class IssueServiceImpl implements IssueService {

    @Autowired
    IssueMapper issueMapper;

    //查询
    @Override
    public ResponseVo issueList(QueryIn queryIn, String question) {
        if(question != null){
            question = "%" + question + "%";
        }
        HashMap<String, Object> map = new HashMap<>();
        List<Issue> issueList = issueMapper.queryIssueList(question);
        PageHelper.startPage(queryIn.getPage(), queryIn.getLimit());
        PageInfo<Issue> pageInfo = new PageInfo<>(issueList);
        map.put("total", pageInfo.getTotal());
        map.put("items", pageInfo.getList());
        return new ResponseVo(0, map, "成功");
    }

    //新增
    @Override
    public ResponseVo issueCreate(Issue issue) {
        ResponseVo responseVo = new ResponseVo();
        Date date = new Date();
        issue.setAddTime(date);
        issue.setUpdateTime(date);
        int id = issueMapper.issueInsert(issue);
        Issue issue1 = issueMapper.selectByPrimaryKey(issue.getId());
        if(id ==1 && issue1 != null){
            responseVo.setErrno(0);
            responseVo.setData(issue1);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(605);
            responseVo.setErrmsg("失败");
        }
        return responseVo;
    }

    //修改
    @Override
    public ResponseVo issueUpdate(Issue issue) {
        ResponseVo responseVo = new ResponseVo();
        Date date = new Date();
        issue.setUpdateTime(date);
        int update = issueMapper.issueUpdate(issue);
        Issue issue1 = issueMapper.selectByPrimaryKey(issue.getId());
        if(update == 1){
            responseVo.setErrno(0);
            responseVo.setData(issue1);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(605);
            responseVo.setErrmsg("失败");
        }
        return responseVo;
    }

    //删除
    @Override
    public ResponseVo issueDelete(Issue issue) {
        ResponseVo responseVo = new ResponseVo();
        Date date = new Date();
        issue.setUpdateTime(date);
        int delete = issueMapper.issueDelete(issue);
        if(delete == 1){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(605);
            responseVo.setErrmsg("失败");
        }
        return responseVo;
    }
}
