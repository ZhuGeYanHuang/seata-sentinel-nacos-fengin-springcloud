package com.zyh.order.orderseata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.zyh", exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
public class AccountSeataApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountSeataApplication.class, args);
    }

}
