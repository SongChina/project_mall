package com.cskaoyan.mallSpringboot.service.goods;

import com.cskaoyan.mallSpringboot.bean.Comment;
import com.cskaoyan.mallSpringboot.vo.RequestVo;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

public interface GoodsCommentService {
    ResponseVo getCommentList(RequestVo requestVo, Integer userId, Integer valueId);

    ResponseVo deleteById(Comment comment);

}
