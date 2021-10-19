package com.kaikeba.common.homer.agent.plugin.servlet;

import com.kaikeba.common.homer.agent.plugin.IPlugin;
import com.kaikeba.common.homer.agent.plugin.InterceptPoint;

/**
 * @author zhaodahai
 * 2021/7/7
 */
public class ServletPlugin implements IPlugin {
    @Override
    public String name() {
        return "servlet";
    }

    @Override
    public InterceptPoint[] buildInterceptPoint() {
        return new InterceptPoint[]{new ServletInterceptPoint()};
    }

    @Override
    public Class adviceClass() {
        return ServletAdvice.class;
    }
}
