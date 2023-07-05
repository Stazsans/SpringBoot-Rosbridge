package com.ros;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RosBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RosBackendApplication.class, args);
    }

}
