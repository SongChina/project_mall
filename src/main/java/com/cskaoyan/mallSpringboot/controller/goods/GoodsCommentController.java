package com.cskaoyan.mallSpringboot.controller.goods;

import com.cskaoyan.mallSpringboot.bean.Comment;
import com.cskaoyan.mallSpringboot.service.goods.GoodsCommentService;
import com.cskaoyan.mallSpringboot.vo.RequestVo;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comment")
public class GoodsCommentController {
    @Autowired
    GoodsCommentService goodsCommentService;


    @RequestMapping("list")
    public ResponseVo search(RequestVo requestVo,Integer userId,Integer valueId){
        return goodsCommentService.getCommentList(requestVo,userId,valueId);

    }

    @RequestMapping("delete")
    public ResponseVo delete(@RequestBody Comment comment){
        return goodsCommentService.deleteById(comment);
    }


}
