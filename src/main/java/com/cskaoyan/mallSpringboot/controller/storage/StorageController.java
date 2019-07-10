package com.cskaoyan.mallSpringboot.controller.storage;

import com.cskaoyan.mallSpringboot.bean.Storage;
import com.cskaoyan.mallSpringboot.oss.MyOssClient;
import com.cskaoyan.mallSpringboot.service.storage.StorageService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class StorageController {

    @Autowired
    StorageService storageService;

    @Autowired
    MyOssClient myOssClient;

    //查找
    @RequestMapping("admin/storage/list")
    public ResponseVo storageList(QueryIn queryIn, String key, String name){
        ResponseVo responseVo = storageService.storageList(queryIn, key, name);
        return responseVo;
    }


    //添加图片
    @RequestMapping("admin/storage/create")
    public ResponseVo storageCreate(MultipartFile file) throws IOException {
        Storage storage = myOssClient.ossFileUpload(file);
        ResponseVo responseVo = storageService.storageCreate(storage);
        return responseVo;
    }
    //修改图片
    @RequestMapping("admin/storage/update")
    public ResponseVo storageUpdate(@RequestBody Storage storage){
        ResponseVo responseVo = storageService.storageUpdate(storage);
        return responseVo;
    }

    //删除
    @RequestMapping("admin/storage/delete")
    public ResponseVo storageDelete(@RequestBody Storage storage){
        ResponseVo responseVo = storageService.storageDelete(storage);
        return responseVo;
    }


    //微信端上传图片
    @RequestMapping("wx/storage/upload")
    public ResponseVo storageUpload(MultipartFile file) throws IOException {
        Storage storage = myOssClient.ossFileUpload(file);
        ResponseVo responseVo = storageService.storageUpload(storage);
        return responseVo;
    }

}
