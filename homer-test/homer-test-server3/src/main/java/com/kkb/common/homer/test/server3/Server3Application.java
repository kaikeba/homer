package com.kkb.common.homer.test.server3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhaodahai
 * 2021/7/14
 */
@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class Server3Application {

    public static void main(String[] args) {
        SpringApplication.run(Server3Application.class,args);
        log.info("server3启动成功");
    }

}
