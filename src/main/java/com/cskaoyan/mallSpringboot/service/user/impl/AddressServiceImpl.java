package com.cskaoyan.mallSpringboot.service.user.impl;

import com.cskaoyan.mallSpringboot.bean.Address;
import com.cskaoyan.mallSpringboot.bean.AddressDetail;
import com.cskaoyan.mallSpringboot.bean.AddressExample;
import com.cskaoyan.mallSpringboot.mapper.AddressMapper;
import com.cskaoyan.mallSpringboot.service.user.AddressService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author AsidentVoice
 * @date 2019/7/5 15:20
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;

    @Override
    public ResponseVo queryAddressList(QueryIn queryIn, String userId, String name) {
        HashMap<String, Object> map = new HashMap<>();
        if (userId!=null) {
            //通过百度查询个数据类型转换问题String转换为Integer：  Integer it = Integer.valueOf(str);  it str都为变量
            //此方法与本项目无关，这里接受数据用的String类型，定义的方法和bean中的数据类型无关
            //Integer只能转换为数字类型，不能%模糊查询
            userId = "%" + userId + "%";
        }
        if (name!=null) {
            name = "%" + name + "%";
        }

        int total = addressMapper.queryAddressCount(userId,name);

        map.put("total",total);
        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());
        List<Address> addressList = addressMapper.queryAddressList(userId, name);
        map.put("items",addressList);
        return new ResponseVo(0,map,"成功");
    }

    @Override
    public List<Address> queryAddressByUserId(Integer userId) {
        AddressExample addressExample = new AddressExample();
        AddressExample.Criteria criteria = addressExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<Address> addresses = addressMapper.selectByExample(addressExample);

        return addresses;
    }


    @Override
    public boolean deleteAddressById(int parseInt) {
        int i = addressMapper.deleteByPrimaryKey(parseInt);
        if(i >0)
            return true;
        return false;
    }

    @Override
    public boolean insertSingleAddress(Address address) {
        int insert = -1;
        if(address.getId() == 0) {
            insert = addressMapper.insert(address);
        }else{
            AddressExample addressExample = new AddressExample();
            AddressExample.Criteria criteria = addressExample.createCriteria();
            criteria.andIdEqualTo(address.getId());
            insert = addressMapper.updateByExample(address, addressExample);
        }
        if (insert > 0){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public Address queryAddressById(int id) {
        Address address = addressMapper.selectByPrimaryKey(id);

        return address;
    }

    @Override
    public AddressDetail queryAddressById2(int id) {
        AddressDetail addressDetail = addressMapper.selectByPrimaryKey2(id);
        return addressDetail;
    }
}
