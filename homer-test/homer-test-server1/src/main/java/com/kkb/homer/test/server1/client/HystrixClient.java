package com.kkb.homer.test.server1.client;

import com.kkb.common.homer.client.HomerUtil;
import com.kkb.homer.test.server1.controller.Server1Controller;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhaodahai
 * 2021/7/14
 */
@Service
@Slf4j
public class HystrixClient {

    @Autowired
    RestTemplateClient restTemplateClient;

    @HystrixCommand(fallbackMethod = "errorMethod")
    public String call(){
        log.info("threadLocal:{}", Server1Controller.threadLocal.get());
        log.info("homerContext:{}", HomerUtil.get("a"));
        int i = 1 / 0;
        return restTemplateClient.restTemplate1();
    }

    public String errorMethod(){
        return "error";
    }


}
