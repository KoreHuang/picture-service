package com.goods.picture.service;

import com.goods.picture.PictureApplication;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=PictureApplication.class)
public class PictureServiceTest  {

    @Autowired
    private PictureService pictureService;

    public void testPictureDownLoad() throws Exception {
        byte[] bytes = pictureService.pictureDownLoad("http://himg2.huanqiu.com/attachment2010/2015/1015/07/54/20151015075437952.jpg");
    }

    @Test
    public void testUpdatePicture() throws IOException {
        String s = pictureService.updatePicture(pictureService.pictureDownLoad("http://c.hiphotos.baidu.com/image/pic/item/377adab44aed2e73519d81f98301a18b86d6faeb.jpg"));
        System.out.println(s);
    }

}