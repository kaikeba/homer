package com.kkb.homer.test.server1.controller;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.kkb.common.homer.client.HomerUtil;
import com.kkb.homer.test.server1.client.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaodahai
 * 2021/7/14
 */
@RestController
@RequestMapping("/server1")
@Slf4j
public class Server1Controller {

    @Autowired
    RestTemplateClient restTemplateClient;

    @Autowired
    HystrixClient hystrixClient;

    @Autowired
    FeignClient feignClient;

    @Autowired
    OkhttpClient okhttpClient;

    @Autowired
    HttpClientC httpClientC;

    @Autowired
    ThreadPoolClient threadPoolClient;

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static ThreadLocal<String> threadLocal1 = new ThreadLocal<>();

    @GetMapping("/restTemplate1")
    public String restTemplate1() {
        return restTemplateClient.restTemplate1();
    }

    @GetMapping("/restTemplate2")
    public String restTemplate2() {
        return restTemplateClient.restTemplate2();
    }

    @GetMapping("/hystrix")
    public String hystrix() {
        threadLocal.set("a");
        return hystrixClient.call();
    }

    @GetMapping("/feign")
    public String feign() {
        return feignClient.r1();
    }


    @GetMapping("/okhttp")
    public String okhttp() {
        return okhttpClient.doOkhttp();
    }

    @GetMapping("/httpClient")
    public String httpClient() {
        httpClientC.doGetTestOne();
        return "ok";
    }


    @GetMapping("/threadPool")
    public String threadPool() {
        threadPoolClient.doThread();
        return "ok";
    }

    @GetMapping("/setHomer")
    public String setHomer() {
        HomerUtil.set("userinfo","zhagnsan");
        return restTemplateClient.restTemplate1();
    }

    @GetMapping("/test")
    public String test() {
        threadLocal1.set("a");
        log.info("before:{}",threadLocal1.get());
        threadLocal1.remove();
        log.info("after:{}",threadLocal1.get());
        return "ok";
    }
}
