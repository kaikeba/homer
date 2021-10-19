package com.kaikeba.common.homer.agent.plugin.feign;


import com.kaikeba.common.homer.agent.plugin.IPlugin;
import com.kaikeba.common.homer.agent.plugin.InterceptPoint;

/**
 * @author zhaodahai
 * 2021/7/7
 */
public class FeignPlugin implements IPlugin {
    @Override
    public String name() {
        return "feignPlugin";
    }

    @Override
    public InterceptPoint[] buildInterceptPoint() {
        return new InterceptPoint[]{
                new FeignInterceptPoint()
        };
    }

    @Override
    public Class adviceClass() {
        return FeignAdvice.class;
    }
}
