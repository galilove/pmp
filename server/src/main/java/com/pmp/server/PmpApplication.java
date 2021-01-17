package com.pmp.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author gali~
 */
@SpringBootApplication
@MapperScan(basePackages = "com.pmp.model.mapper")
public class PmpApplication {
    public static void main(String[] args) {
        SpringApplication.run(PmpApplication.class,args);
    }
}
