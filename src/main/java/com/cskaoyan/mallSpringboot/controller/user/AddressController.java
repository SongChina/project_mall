package com.cskaoyan.mallSpringboot.controller.user;

import com.cskaoyan.mallSpringboot.service.user.AddressService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AsidentVoice
 * @date 2019/7/5 15:04
 */
@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    //收货地址分类查询
    @RequestMapping("admin/address/list")
    public ResponseVo addressList(QueryIn queryIn,String userId,String name) {
        ResponseVo responseVo = addressService.queryAddressList(queryIn,userId,name);
        return responseVo;
    }
}
