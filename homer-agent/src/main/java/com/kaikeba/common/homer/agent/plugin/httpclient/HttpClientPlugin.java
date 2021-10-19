package com.kaikeba.common.homer.agent.plugin.httpclient;


import com.kaikeba.common.homer.agent.plugin.IPlugin;
import com.kaikeba.common.homer.agent.plugin.InterceptPoint;

/**
 * @author zhaodahai
 * 2021/7/13
 */
public class HttpClientPlugin implements IPlugin {
    @Override
    public String name() {
        return "httpClient";
    }

    @Override
    public InterceptPoint[] buildInterceptPoint() {
        return new InterceptPoint[]{
                new HttpClientInterceptPoint()
        };
    }

    @Override
    public Class adviceClass() {
        return HttpClientAdvice.class;
    }
}
