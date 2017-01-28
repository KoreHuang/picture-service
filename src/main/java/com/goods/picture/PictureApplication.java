package com.goods.picture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by zhengjunbo on 2015/9/16.
 */

@SpringBootApplication
@EnableAutoConfiguration
public class PictureApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PictureApplication.class, args);
    }
}
