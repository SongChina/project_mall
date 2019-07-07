package com.cskaoyan.mallSpringboot.service.goods.impl;

import com.cskaoyan.mallSpringboot.bean.Comment;
import com.cskaoyan.mallSpringboot.bean.CommentExample;
import com.cskaoyan.mallSpringboot.mapper.CommentMapper;
import com.cskaoyan.mallSpringboot.service.goods.GoodsCommentService;
import com.cskaoyan.mallSpringboot.vo.BaseResultVo;
import com.cskaoyan.mallSpringboot.vo.RequestVo;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsCommentServiceImpl implements GoodsCommentService {
    @Autowired
    CommentMapper commentMapper;


    @Override
    public ResponseVo getCommentList(RequestVo requestVo, Integer userId, Integer valueId) {
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        if (userId != null){
            criteria.andUserIdEqualTo(userId);
        }else if(valueId != null){
            criteria.andValueIdEqualTo(valueId);
        }else{
            criteria.getAllCriteria();
        }
        PageHelper.startPage(requestVo.getPage(),requestVo.getLimit());
        List<Comment> commentList = commentMapper.selectByExample(commentExample);
        BaseResultVo<Comment> baseResultVo = new BaseResultVo<>();
        baseResultVo.setItems(commentList);
        int total = (int) commentMapper.countByExample(commentExample);
        baseResultVo.setTotal(total);
        return new ResponseVo(0,baseResultVo,"成功");
    }

    @Override
    public ResponseVo deleteById(Comment comment) {
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria().andIdEqualTo(comment.getId());
        int i = commentMapper.deleteByExample(commentExample);
        return new ResponseVo(0,"","成功");
    }
}
