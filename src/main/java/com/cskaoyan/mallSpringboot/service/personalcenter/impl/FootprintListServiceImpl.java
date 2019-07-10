package com.cskaoyan.mallSpringboot.service.personalcenter.impl;

import com.cskaoyan.mallSpringboot.bean.Footprint;
import com.cskaoyan.mallSpringboot.bean.FootprintData;
import com.cskaoyan.mallSpringboot.bean.FootprintExample;
import com.cskaoyan.mallSpringboot.bean.FootprintListData;
import com.cskaoyan.mallSpringboot.mapper.FootprintMapper;
import com.cskaoyan.mallSpringboot.service.personalcenter.FootprintListService;
import com.cskaoyan.mallSpringboot.util.UserTokenManager;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Service
public class FootprintListServiceImpl implements FootprintListService {

    @Autowired
    FootprintMapper footprintMapper;

    @Override
    public ResponseVo footprintList(int page, int size, HttpServletRequest request) {
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        List<FootprintData> footprintData = footprintMapper.footprintList(userId);
        int i = footprintData.size();
        int totalPage = i / size ;
        FootprintListData footprintListData = new FootprintListData();
        footprintListData.setFootprintList(footprintData);
        footprintListData.setTotalPage(totalPage);
        return new ResponseVo(0,footprintListData,"成功");
    }
}
