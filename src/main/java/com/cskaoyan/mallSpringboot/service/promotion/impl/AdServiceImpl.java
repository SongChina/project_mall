package com.cskaoyan.mallSpringboot.service.promotion.impl;

import com.cskaoyan.mallSpringboot.bean.Ad;
import com.cskaoyan.mallSpringboot.mapper.AdMapper;
import com.cskaoyan.mallSpringboot.service.promotion.AdService;
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
public class AdServiceImpl implements AdService {
    @Autowired
    AdMapper adMapper;

    @Override
    public Ad createAd(Ad ad) {
        ad.setAddTime(new Date());
        ad.setUpdateTime(new Date());
        //
//        ad.setStartTime(new Date());//不符合逻辑，暂时这样测试
//        ad.setEndTime(new Date());
        //
        ad.setDeleted(false);

        int insert = adMapper.insert(ad);
        Integer id = adMapper.lastInsertId();
        ad.setId(id);
        return ad;
    }

    @Override
    public ResponseVo queryList(QueryIn queryIn, String name, String content) {
        HashMap<String, Object> data = new HashMap<>();
        //条件,用于模糊查询
        if (name != null & name != ""){
            name = "%" + name + "%";
        }
        if (content != null & content != ""){
            content = "%" + content + "%";
        }
        int total = adMapper.queryCount(name,content);
        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());
        List<Ad> list = adMapper.queryList(name, content, queryIn.getSort(), queryIn.getOrder());
        PageInfo<Ad> pageInfo = new PageInfo<>(list);//这句是否多余，是否只在查询语句前使用startPage就足够
        data.put("total",total);
        data.put("items",pageInfo.getList());

        return new ResponseVo(0,data,"成功");
    }

    @Override
    public int delete(Integer id, Date updateTime) {
        //int i = adMapper.deleteBydeleted(id, updateTime);
        int i = adMapper.deleteByPrimaryKey(id);

        return i;
    }

    @Override
    public int update(Ad ad) {
        int i = adMapper.updateByPrimaryKey(ad);
        return i;
    }
}
