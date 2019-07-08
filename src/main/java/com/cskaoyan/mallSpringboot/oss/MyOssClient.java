package com.cskaoyan.mallSpringboot.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.cskaoyan.mallSpringboot.bean.Storage;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@ConfigurationProperties(prefix = "myoss")
@Component
public class MyOssClient {
    String bucket;
    String endpoint ;
    String accessKey ;
    String secret ;

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Storage ossFileUpload(MultipartFile myfile) throws IOException {
        InputStream inputStream = myfile.getInputStream();
        long size = myfile.getSize();
        String contentType = myfile.getContentType();

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(size);
        objectMetadata.setContentType(contentType);

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, uuid, inputStream, objectMetadata);

        OSSClient ossClient = new OSSClient(endpoint, accessKey, secret);
        ossClient.putObject(putObjectRequest);

        //封装数据进storage
        Storage storage = new Storage();
        storage.setName(myfile.getName());
        storage.setSize((int) size);
        storage.setType(contentType);
        storage.setUrl("http://" + bucket + "." + endpoint + "/" + uuid);
        storage.setKey(uuid);
        return storage;
    }
}
