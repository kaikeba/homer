package com.kkb.homer.test.server1.client;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhaodahai
 * 2021/7/14
 */
@org.springframework.cloud.openfeign.FeignClient(name = "test-server2")
@Component
@RequestMapping("/server2")
public interface FeignClient {
    @GetMapping("/r1")
    String r1();

}
