package com.cskaoyan.mallSpringboot.service.user.impl;

import com.cskaoyan.mallSpringboot.bean.Collect;
import com.cskaoyan.mallSpringboot.bean.Searchhistory;
import com.cskaoyan.mallSpringboot.mapper.SearchhistoryMapper;
import com.cskaoyan.mallSpringboot.service.SearchHistoryService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author AsidentVoice
 * @date 2019/7/6 16:01
 */
@Service
public class SearchHistoryServiceImpl implements SearchHistoryService {
    @Autowired
    SearchhistoryMapper searchhistoryMapper;

    @Override
    public ResponseVo querySearchHistoryList(QueryIn queryIn, String userId, String keyword) {
        HashMap<String, Object> map = new HashMap<>();
        if (userId!=null) {
            //通过百度查询个数据类型转换问题String转换为Integer：  Integer it = Integer.valueOf(str);  it str都为变量
            //此方法与本项目无关，这里接受数据用的String类型，定义的方法和bean中的数据类型无关
            //Integer只能转换为数字类型，不能%模糊查询
            userId = "%" + userId + "%";
        }
        if (keyword!=null) {
            keyword = "%" + keyword + "%";
        }

        int total = searchhistoryMapper.querySearchHistoryCount(userId, keyword);

        map.put("total",total);
        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());
        List<Searchhistory> searchHistoryList = searchhistoryMapper.querySearchHistoryList(userId, keyword);
        map.put("items",searchHistoryList);
        return new ResponseVo(0,map,"成功");
    }
}
