package com.kkb.common.homer.test.server2.controller;

import com.kkb.common.homer.client.HomerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author zhaodahai
 * 2021/7/14
 */
@RestController
@RequestMapping("/server2")
@Slf4j
public class Server2Controller {

    @GetMapping("/r1")
    public String r1(HttpServletRequest httpServletRequest){
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            if (s.startsWith(HomerUtil.HOMER_HEADER_PREFIX)){
                log.info("header:{},value:{}",s,httpServletRequest.getHeader(s));
            }
        }
        return "ok";
    }

}
