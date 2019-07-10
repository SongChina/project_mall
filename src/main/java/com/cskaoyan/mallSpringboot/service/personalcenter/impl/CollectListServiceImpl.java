package com.cskaoyan.mallSpringboot.service.personalcenter.impl;


import com.cskaoyan.mallSpringboot.bean.CollectData;
import com.cskaoyan.mallSpringboot.bean.CollectListData;
import com.cskaoyan.mallSpringboot.mapper.CollectDataMapper;
import com.cskaoyan.mallSpringboot.mapper.CollectMapper;
import com.cskaoyan.mallSpringboot.service.personalcenter.CollectListService;
import com.cskaoyan.mallSpringboot.util.UserTokenManager;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class CollectListServiceImpl implements CollectListService {

    @Autowired
    CollectMapper collectMapper;
    @Autowired
    CollectDataMapper collectDataMapper;
    @Override
    public ResponseVo collectList(int type, int page, int size, HttpServletRequest request) {
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        List<CollectData> collectData = collectDataMapper.selectByType(type,userId);
        int i = collectData.size();
        int totalPages = i / size;
        CollectListData collectListData = new CollectListData();
        collectListData.setCollectList(collectData);
        collectListData.setTotalPages(totalPages);
        return new ResponseVo(0,collectListData,"成功");


    }
}
