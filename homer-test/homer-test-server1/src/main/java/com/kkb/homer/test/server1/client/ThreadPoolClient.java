package com.kkb.homer.test.server1.client;

import com.kkb.common.homer.client.HomerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhaodahai
 * 2021/7/14
 */
@Service
public class ThreadPoolClient {

    @Autowired
    RestTemplateClient restTemplateClient;

    ExecutorService executorService = Executors.newFixedThreadPool(2);

    public String doThread(){
        new Thread(() -> restTemplateClient.restTemplate1()).start();

        for (int i = 0; i < 10; i ++){
            int j = i;
            executorService.submit(() -> {
                String a = HomerUtil.get("a") + j;
                HomerUtil.set("a",a);
                restTemplateClient.restTemplate1();
            });
        }
        return "ok";
    }

}
