package com.kaikeba.common.homer.agent.plugin;

/**
 * @author zhaodahai
 * 2021/7/13
 */
public interface IPlugin {

    String HOMER_HEADER_PREFIX = "homer-";

    /**
     * 名称
     * @return
     */
    String name();

    /**
     * 监控点
     * @return
     */
    InterceptPoint[] buildInterceptPoint();

    /**
     * 拦截器类
     * @return
     */
    Class adviceClass();

}
