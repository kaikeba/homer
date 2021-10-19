package com.kkb.homer.test.server1.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhaodahai
 * 2021/7/14
 */
@Service
@Slf4j
public class RestTemplateClient {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 普通的restTemplate调用
     * @return
     */
    public String restTemplate1() {
        return restTemplate.exchange("http://localhost:8082/server2/r1", HttpMethod.GET, null, String.class).getBody();
    }

    /**
     * 基于注册中心、负载均衡的restTemplate调用
     * @return
     */
    public String restTemplate2() {
        return restTemplate.exchange("http://test-server2/server2/r1", HttpMethod.GET, null, String.class).getBody();
    }


}
