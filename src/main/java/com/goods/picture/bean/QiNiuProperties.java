package com.goods.picture.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

/**
 * 七牛配置
 * Created by zhengjunbo on 2015/10/15.
 */

@ConfigurationProperties(prefix = "qiniu", ignoreUnknownFields = false)
@Component
public class QiNiuProperties {
    private String accessKey;
    private String secretKey;
    private String bucket;
    private String url;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "QiNiuProperties{" +
                "url='" + url + '\'' +
                ", bucket='" + bucket + '\'' +
                ", secretKey='" + secretKey + '\'' +
                ", accessKey='" + accessKey + '\'' +
                '}';
    }
}
