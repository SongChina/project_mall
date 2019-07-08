package com.cskaoyan.mallSpringboot.service.user.impl;

import com.cskaoyan.mallSpringboot.bean.User;
import com.cskaoyan.mallSpringboot.mapper.UserMapper;
import com.cskaoyan.mallSpringboot.service.user.UserService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author AsidentVoice
 * @date 2019/7/4 22:03
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public ResponseVo queryUserList(QueryIn queryIn, String username, String mobile) {
        HashMap<String, Object> map = new HashMap<>();
        if (username!=null) {
            //id的左右都进行模糊查询
            username = "%" + username + "%" ;
        }
        if (mobile!=null) {
            mobile = "%" + mobile + "%";
        }

        int total = userMapper.queryUserCount(username,mobile);

        map.put("total",total);
        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());
        List<User> userList = userMapper.queryUserList(username,mobile);
        map.put("items",userList);
        return new ResponseVo(0,map,"成功");

    }
}
