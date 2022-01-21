package com.zyh.stock.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>fegin配置类</p>
 *
 * @author : zyh
 **/
@Configuration
public class FeginConfig {

    @Bean
    public Logger.Level logger() {
        return Logger.Level.FULL;
    }

}
