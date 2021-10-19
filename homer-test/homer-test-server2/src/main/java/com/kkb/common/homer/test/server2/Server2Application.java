package com.kkb.common.homer.test.server2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhaodahai
 * 2021/7/14
 */
@Slf4j
@SpringBootApplication
@EnableEurekaClient
public class Server2Application {

    public static void main(String[] args) {
        SpringApplication.run(Server2Application.class,args);
        log.info("server2 启动成功");
    }
}
