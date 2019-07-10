package com.cskaoyan.mallSpringboot.controller.user;

import com.cskaoyan.mallSpringboot.bean.Address;
import com.cskaoyan.mallSpringboot.bean.AddressDetail;
import com.cskaoyan.mallSpringboot.bean.AddressId;
import com.cskaoyan.mallSpringboot.service.mall.RegionService;
import com.cskaoyan.mallSpringboot.service.user.AddressService;
import com.cskaoyan.mallSpringboot.util.UserTokenManager;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author AsidentVoice
 * @date 2019/7/5 15:04
 */
@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    @Autowired
    RegionService regionService;

    //收货地址分类查询
    @RequestMapping("admin/address/list")
    public ResponseVo addressList(QueryIn queryIn,String userId,String name) {
        ResponseVo responseVo = addressService.queryAddressList(queryIn,userId,name);
        return responseVo;
    }

    @RequestMapping("wx/address/list")
    public ResponseVo getAddressesByUserId(HttpServletRequest request){
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);

        List<Address> addressList = addressService.queryAddressByUserId(userId);
        ResponseVo responseVo = new ResponseVo();
        responseVo.setData(addressList);
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");

        return responseVo;
    }

    @RequestMapping("wx/address/delete")
    public ResponseVo deleteAddressById(@RequestBody AddressId addressId, HttpServletRequest request){
        ResponseVo responseVo = new ResponseVo();
        boolean flag = addressService.deleteAddressById(addressId.getId());
        if(flag){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else{
            responseVo.setErrmsg("失败");
        }
        return responseVo;

    }

    @RequestMapping("wx/address/save")
    public ResponseVo insertAddress(@RequestBody Address address, HttpServletRequest request){
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);

        ResponseVo responseVo = new ResponseVo();

        address.setUserId(userId);
        boolean flag = addressService.insertSingleAddress(address);

        if (flag){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else{
            responseVo.setErrmsg("失败");
        }
        return responseVo;

    }

    @RequestMapping("wx/address/detail")
    public ResponseVo getAddressDetail(int id){
        AddressDetail addressDetail =  addressService.queryAddressById2(id);

        ResponseVo responseVo = new ResponseVo();

        boolean flag = regionService.setRegionName(addressDetail);
        if(flag){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
            responseVo.setData(addressDetail);
        }
        return responseVo;
    }

   /* @RequestMapping("wx/address/detail")
    public ResponseVo getUserDetail(int id){
        addressService.
    }*/
}
