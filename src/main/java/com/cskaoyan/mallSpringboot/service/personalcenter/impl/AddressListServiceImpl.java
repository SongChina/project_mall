package com.cskaoyan.mallSpringboot.service.personalcenter.impl;

import com.cskaoyan.mallSpringboot.bean.Address;
import com.cskaoyan.mallSpringboot.bean.AddressExample;
import com.cskaoyan.mallSpringboot.mapper.AddressMapper;
import com.cskaoyan.mallSpringboot.service.personalcenter.AddressListService;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressListServiceImpl implements AddressListService {
    @Autowired
    AddressMapper addressMapper;

    @Override
    public ResponseVo addressList() {
        List<Address> addresses = addressMapper.selectAddress();
        return new ResponseVo(0,addresses,"成功");

    }
}
