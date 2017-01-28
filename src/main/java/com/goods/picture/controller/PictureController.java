package com.goods.picture.controller;

import com.goods.picture.bean.ResponseBean;
import com.goods.picture.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @author Dan
 * Created by zhengjunbo on 2015/10/15.
 */
@Controller
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping("/picture")
    @ResponseBody
    public ResponseBean getPicture(String sourceUrl){
        ResponseBean responseBean = new ResponseBean();
        String result = null;
        try {
            result = pictureService.updatePicture(sourceUrl);
            responseBean.setStatus("1");
        } catch (Throwable e) {
            responseBean.setStatus("0");
            e.printStackTrace();
        }

        responseBean.setUrl(result);
        return responseBean;
    }


}
