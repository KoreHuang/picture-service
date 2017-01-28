package com.goods.picture.service;

import com.goods.picture.bean.QiNiuProperties;
import com.qiniu.common.QiniuException;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

/**
 * @author Dan
 * Created by zhengjunbo on 2015/10/15.
 */
@Service
public class PictureService{

    @Autowired
    private QiNiuProperties qiNiuProperties;

    /**
     * 下载图片到内存
     * @param sourceUrl
     * @return
     * @throws IOException
     */
    public byte[] pictureDownLoad(String sourceUrl) throws IOException {
        byte[] str ;
        try {
            HttpClient httpClient = new DefaultHttpClient();

            HttpGet get  = new HttpGet(sourceUrl);
            HttpResponse execute = httpClient.execute(get);

            str = EntityUtils.toByteArray(execute.getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str;

    }

    public String updatePicture(String url) throws IOException {
        return  updatePicture(pictureDownLoad(url));
    }

    public String updatePicture(byte [] picStream) throws QiniuException {
        Auth auth = Auth.create(qiNiuProperties.getAccessKey(), qiNiuProperties.getSecretKey());
        String token = auth.uploadToken(qiNiuProperties.getBucket());
        UploadManager uploadManager = new UploadManager();
        // 上传文件添加时间戳，防止文件重名，七牛报错
        String datetime = String.valueOf(new Date().getTime());

        String fileName =  datetime + ".jpg";
        uploadManager.put(picStream, fileName, token);
        return  qiNiuProperties.getUrl() + "/" + fileName;
    }


}
