package com.kaikeba.common.homer.agent.plugin.resttemplate;

import com.kaikeba.common.homer.agent.plugin.IPlugin;
import com.kaikeba.common.homer.agent.plugin.InterceptPoint;

/**
 * @author zhaodahai
 * 2021/7/7
 */
public class RestTemplatePlugin implements IPlugin {
    @Override
    public String name() {
        return "restTemplate";
    }

    @Override
    public InterceptPoint[] buildInterceptPoint() {
        return new InterceptPoint[]{new RestTemplateInterceptPoint()};
    }

    @Override
    public Class adviceClass() {
        return RestTemplateAdvice.class;
    }
}
