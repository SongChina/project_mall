package com.cskaoyan.mallSpringboot.service.promotion.impl;

import com.cskaoyan.mallSpringboot.bean.Groupon;
import com.cskaoyan.mallSpringboot.bean.GrouponExample;
import com.cskaoyan.mallSpringboot.mapper.GrouponMapper;
import com.cskaoyan.mallSpringboot.service.promotion.GrouponService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrouponServiceImpl implements GrouponService {
    @Autowired
    GrouponMapper grouponMapper;

    @Override
    public List<Groupon> queryList(QueryIn queryIn, String goodsId) {

        /*if (goodsId != "" & goodsId != null) {
            goodsId = "%" + goodsId + "%";
        }*/

        //分页
        PageHelper.startPage(queryIn.getPage(), queryIn.getLimit());
        List<Groupon> list = grouponMapper.queryList(queryIn.getSort(), queryIn.getOrder(), goodsId);


        return list;
    }

    //微信前端我的拼团


    @Override
    public List<Groupon> queryMyGroupon(Integer userId) {
        GrouponExample example = new GrouponExample();
        //example.or().andUserIdEqualTo(userId).andCreatorUserIdEqualTo(userId).andGrouponIdEqualTo(0).andDeletedEqualTo(false).andPayedEqualTo(true);
        example.or().andUserIdEqualTo(userId).andCreatorUserIdEqualTo(userId).andGrouponIdEqualTo(0).andPayedEqualTo(true);
        example.setOrderByClause("add_time desc");
        return grouponMapper.selectByExample(example);
    }

    @Override
    public List<Groupon> queryMyJoinGroupon(Integer userId) {
        GrouponExample example = new GrouponExample();
        //example.or().andUserIdEqualTo(userId).andGrouponIdNotEqualTo(0).andDeletedEqualTo(false).andPayedEqualTo(true);
        example.or().andUserIdEqualTo(userId).andGrouponIdNotEqualTo(0).andPayedEqualTo(true);
        example.setOrderByClause("add_time desc");
        return grouponMapper.selectByExample(example);
    }

    @Override
    public int countGroupon(Integer grouponId) {
        GrouponExample example = new GrouponExample();
        //example.or().andGrouponIdEqualTo(grouponId).andDeletedEqualTo(false).andPayedEqualTo(true);
        example.or().andGrouponIdEqualTo(grouponId).andPayedEqualTo(true);
        return (int) grouponMapper.countByExample(example);
    }

    @Override
    public List<Groupon> queryJoinRecord(Integer id) {
        GrouponExample example = new GrouponExample();
        example.or().andGrouponIdEqualTo(id).andPayedEqualTo(true);
        example.setOrderByClause("add_time desc");
        return grouponMapper.selectByExample(example);
    }
}
