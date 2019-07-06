package com.cskaoyan.mallSpringboot.service.storage.impl;

import com.cskaoyan.mallSpringboot.bean.Storage;
import com.cskaoyan.mallSpringboot.mapper.StorageMapper;
import com.cskaoyan.mallSpringboot.service.storage.StorageService;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    StorageMapper storageMapper;



    //插入存储记录(待修改)
    @Override
    public ResponseVo storageCreate(Storage storage) {
        Date date = new Date();
        ResponseVo responseVo = new ResponseVo();
        storage.setAddTime(date);
        storage.setUpdateTime(date);
        int i = storageMapper.storageInsert(storage);
        Storage storage1 = storageMapper.selectStorageById(storage.getId());
        if(i == 1 && storage1 != null){
            responseVo.setErrno(0);
            responseVo.setData(storage1);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(605);
            responseVo.setErrmsg("失败");
        }
        return responseVo;
    }
}
