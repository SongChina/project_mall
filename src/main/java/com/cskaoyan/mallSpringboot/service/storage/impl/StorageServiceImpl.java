package com.cskaoyan.mallSpringboot.service.storage.impl;


import com.cskaoyan.mallSpringboot.bean.Storage;
import com.cskaoyan.mallSpringboot.mapper.StorageMapper;
import com.cskaoyan.mallSpringboot.service.storage.StorageService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    StorageMapper storageMapper;

    //查找
    @Override
    public ResponseVo storageList(QueryIn queryIn, String key, String name) {
        PageHelper.startPage(queryIn.getPage(), queryIn.getLimit());
        List<Storage> storageList =  storageMapper.selectStorageList(key, name);
        PageInfo<Storage> pageInfo = new PageInfo<>(storageList);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("items", pageInfo.getList());
        return new ResponseVo(0, map, "成功");
    }

    //插入存储记录
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


    //修改
    @Override
    public ResponseVo storageUpdate(Storage storage) {
        ResponseVo responseVo = new ResponseVo();
        storage.setUpdateTime(new Date());
        int update = storageMapper.storageUpdate(storage);
        Storage storage1 = storageMapper.selectStorageById(storage.getId());
        if(update == 1 && storage1 != null){
            responseVo.setErrno(0);
            responseVo.setData(storage1);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(605);
            responseVo.setErrmsg("失败");
        }
        return responseVo;
    }

    //删除
    @Override
    public ResponseVo storageDelete(Storage storage) {
        ResponseVo responseVo = new ResponseVo();
        storage.setUpdateTime(new Date());
        int delete = storageMapper.storageDelete(storage);
        if(delete == 1){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(605);
            responseVo.setErrmsg("失败");
        }
        return responseVo;
    }




}
