package com.cskaoyan.mallSpringboot.service.mall;

import com.cskaoyan.mallSpringboot.bean.Issue;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

public interface IssueService {
    ResponseVo issueList(QueryIn queryIn, String question);

    ResponseVo issueCreate(Issue issue);

    ResponseVo issueUpdate(Issue issue);

    ResponseVo issueDelete(Issue issue);
}
