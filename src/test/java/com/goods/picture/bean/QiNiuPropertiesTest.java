package com.goods.picture.bean;

import com.goods.picture.PictureApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=PictureApplication.class)
public class QiNiuPropertiesTest {
    @Autowired
    private QiNiuProperties qiNiuProperties;

    @Test
    public void test(){
        System.out.println(qiNiuProperties);
    }
}