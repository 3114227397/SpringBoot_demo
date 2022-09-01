package com.itheima;

import com.itheima.config.MybatisPlusConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(MybatisPlusConfig.class)
public class Demo13PratiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo13PratiseApplication.class, args);
    }

}
