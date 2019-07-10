package com.cskaoyan.mallSpringboot.service.user;

import com.cskaoyan.mallSpringboot.bean.Address;
import com.cskaoyan.mallSpringboot.bean.AddressDetail;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

import java.util.List;

/**
 * @author AsidentVoice
 * @date 2019/7/5 15:19
 */
public interface AddressService {
    ResponseVo queryAddressList(QueryIn queryIn, String userId, String name);

    List<Address> queryAddressByUserId(Integer userId);

    boolean deleteAddressById(int parseInt);

    boolean insertSingleAddress(Address address);

    Address queryAddressById(int id);

    AddressDetail queryAddressById2(int id);
}
