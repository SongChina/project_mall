package com.cskaoyan.mallSpringboot.controller;

import com.cskaoyan.mallSpringboot.bean.Order;
import com.cskaoyan.mallSpringboot.bean.OrderExample;
import com.cskaoyan.mallSpringboot.bean.User;
import com.cskaoyan.mallSpringboot.bean.UserExample;
import com.cskaoyan.mallSpringboot.mapper.OrderMapper;
import com.cskaoyan.mallSpringboot.mapper.UserMapper;
import com.cskaoyan.mallSpringboot.util.*;
import com.cskaoyan.mallSpringboot.utils.MD5Util;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by little Stone
 * Date 2019/7/8 Time 20:55
 */
@RestController
@RequestMapping("wx")
public class WxAuthController {
	@Autowired
	UserMapper userMapper;

	@RequestMapping("/auth/login")
	@ResponseBody
	public Object login(@RequestBody String body, HttpServletRequest request) {
		String username = JacksonUtil.parseString(body, "username");
		String password = JacksonUtil.parseString(body, "password");

		//*******************************
		//根据username和password查询user信息
		//*******************************
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andUsernameEqualTo(username);
		String passwordInEncode = MD5Util.encode(password);
		criteria.andPasswordEqualTo(passwordInEncode);
		List<User> users = userMapper.selectByExample(userExample);

		// userInfo
		UserInfo userInfo = new UserInfo();
		userInfo.setNickName(username);
		//userInfo.setAvatarUrl(user.getAvatar());

		if(users != null && users.size() == 1) {

			//********************************
			//根据获得userid
			int userId = users.get(0).getId();
			//********************************
			// token
			UserToken userToken = UserTokenManager.generateToken(userId);

			Map<Object, Object> result = new HashMap<Object, Object>();
			result.put("token", userToken.getToken());
			result.put("tokenExpire", userToken.getExpireTime().toString());
			result.put("userInfo", userInfo);
			return BaseRespVo.ok(result);
		}else{
			return BaseRespVo.fail();
		}


	}

	@Autowired
	OrderMapper orderMapper;

	@GetMapping("user/index")
	public Object list(HttpServletRequest request) {
		//前端写了一个token放在请求头中
		//*************************
		//获得请求头
		String tokenKey = request.getHeader("X-Litemall-Token");
		Integer userId = UserTokenManager.getUserId(tokenKey);
		//通过请求头获得userId，进而可以获得一切关于user的信息
		//**************************
		if (userId == null) {
			return BaseRespVo.fail();
		}

		Map<Object, Object> data = new HashMap<Object, Object>();

		//***********************************
		//根据userId查询订单信息
		OrderExample orderExample = new OrderExample();
		OrderExample.Criteria criteria = orderExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<Order> orders = orderMapper.selectByExample(orderExample);
		data.put("order", orders);
		//***********************************

		return BaseRespVo.ok(data);
	}
}
