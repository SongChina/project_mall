package com.cskaoyan.mallSpringboot.controller.mall;

import com.cskaoyan.mallSpringboot.bean.Issue;
import com.cskaoyan.mallSpringboot.service.mall.IssueService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IssueController {

    @Autowired
    IssueService issueService;

    //查询
    @RequestMapping("admin/issue/list")
    public ResponseVo issueList(QueryIn queryIn, String question){
        ResponseVo responseVo = issueService.issueList(queryIn, question);
        return responseVo;
    }
    //新增
    @RequestMapping("admin/issue/create")
    public ResponseVo issueCreate(@RequestBody Issue issue){
        ResponseVo responseVo = issueService.issueCreate(issue);
        return responseVo;
    }
    //修改
    @RequestMapping("admin/issue/update")
    public ResponseVo issueUpdate(@RequestBody Issue issue){
        ResponseVo responseVo = issueService.issueUpdate(issue);
        return responseVo;
    }
    //删除
    @RequestMapping("admin/issue/delete")
    public ResponseVo issueDelete(@RequestBody Issue issue){
        ResponseVo responseVo = issueService.issueDelete(issue);
        return responseVo;
    }

}
