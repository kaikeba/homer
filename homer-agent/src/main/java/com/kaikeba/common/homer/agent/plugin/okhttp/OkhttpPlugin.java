package com.kaikeba.common.homer.agent.plugin.okhttp;

import com.kaikeba.common.homer.agent.plugin.IPlugin;
import com.kaikeba.common.homer.agent.plugin.InterceptPoint;

/**
 * @author zhaodahai
 * 2021/7/13
 */
public class OkhttpPlugin implements IPlugin {
    @Override
    public String name() {
        return "okhttp";
    }

    @Override
    public InterceptPoint[] buildInterceptPoint() {
        return new InterceptPoint[]{new OkhttpInterceptPoint()};
    }

    @Override
    public Class adviceClass() {
        return OkhttpAdvice.class;
    }
}
