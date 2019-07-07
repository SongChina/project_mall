package com.cskaoyan.mallSpringboot.service.user.impl;

import com.cskaoyan.mallSpringboot.bean.Collect;
import com.cskaoyan.mallSpringboot.bean.Footprint;
import com.cskaoyan.mallSpringboot.mapper.FootprintMapper;
import com.cskaoyan.mallSpringboot.service.user.FootPrintService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author AsidentVoice
 * @date 2019/7/6 15:09
 */
@Service
public class FootPrintServiceImpl implements FootPrintService {
    @Autowired
    FootprintMapper footprintMapper;

    @Override
    public ResponseVo queryFootPrintList(QueryIn queryIn, String userId, String goodsId) {
        HashMap<String, Object> map = new HashMap<>();
        if (userId!=null) {
            //通过百度查询个数据类型转换问题String转换为Integer：  Integer it = Integer.valueOf(str);  it str都为变量
            //此方法与本项目无关，这里接受数据用的String类型，定义的方法和bean中的数据类型无关
            //Integer只能转换为数字类型，不能%模糊查询
            userId = "%" + userId + "%";
        }
        if (goodsId!=null) {
            goodsId = "%" + goodsId + "%";
        }

        int total = footprintMapper.queryFootPrintCount(userId,goodsId);

        map.put("total",total);
        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());
        List<Footprint> footprintList = footprintMapper.queryFootPrintList(userId, goodsId);
        map.put("items",footprintList);
        return new ResponseVo(0,map,"成功");
    }
}
