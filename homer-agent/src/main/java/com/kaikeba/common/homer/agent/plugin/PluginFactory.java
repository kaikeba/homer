package com.kaikeba.common.homer.agent.plugin;

import com.kaikeba.common.homer.agent.plugin.feign.FeignPlugin;
import com.kaikeba.common.homer.agent.plugin.okhttp.OkhttpPlugin;
import com.kaikeba.common.homer.agent.plugin.httpclient.HttpClientPlugin;
import com.kaikeba.common.homer.agent.plugin.resttemplate.RestTemplatePlugin;
import com.kaikeba.common.homer.agent.plugin.servlet.ServletPlugin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaodahai
 * 2021/7/13
 */
public class PluginFactory {

    public static final List<IPlugin> pluginGroup = new ArrayList<>();

    static {
        pluginGroup.add(new OkhttpPlugin());
        pluginGroup.add(new HttpClientPlugin());
        pluginGroup.add(new FeignPlugin());
        pluginGroup.add(new ServletPlugin());
        pluginGroup.add(new RestTemplatePlugin());
        //pluginGroup.add(new ThreadPlugin());
    }

}
