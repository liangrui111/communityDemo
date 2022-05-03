package com.liangrui.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration//声明配置类
public class AlphaConfig {
    //获取第三方的bean(因为第三方的源码你改不了 或者只有jar包没有源码)
    @Bean
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

}
