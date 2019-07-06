package com.cskaoyan.mallSpringboot.controller.storage;

import com.cskaoyan.mallSpringboot.bean.Storage;
import com.cskaoyan.mallSpringboot.oss.MyOssClient;
import com.cskaoyan.mallSpringboot.service.storage.StorageService;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
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

    //添加图片
    @RequestMapping("storage/create")
    public ResponseVo storageCreate(MultipartFile file) throws IOException {
        Storage storage = myOssClient.ossFileUpload(file);
        ResponseVo responseVo = storageService.storageCreate(storage);
        return responseVo;
    }

}
