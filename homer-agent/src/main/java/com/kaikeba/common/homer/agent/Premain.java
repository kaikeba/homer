package com.kaikeba.common.homer.agent;

import com.alibaba.ttl.threadpool.agent.TtlAgent;
import com.kaikeba.common.homer.agent.plugin.IPlugin;
import com.kaikeba.common.homer.agent.plugin.InterceptPoint;
import com.kaikeba.common.homer.agent.plugin.PluginFactory;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;

import java.lang.instrument.Instrumentation;
import java.util.List;

/**
 * @author zhaodahai
 * 2021/7/13
 */
public class Premain {

    public static void premain(String agentArgs, Instrumentation instrumentation) {
        System.out.println("homer");
        // 使用ttl修饰线程池实现数据传递
        TtlAgent.premain(agentArgs, instrumentation);
        AgentBuilder agentBuilder = new AgentBuilder.Default();
        methodPlugin(agentBuilder).installOn(instrumentation);
    }

    static AgentBuilder methodPlugin(AgentBuilder agentBuilder) {
        List<IPlugin> pluginGroup = PluginFactory.pluginGroup;
        for (IPlugin plugin : pluginGroup) {
            InterceptPoint[] interceptPoints = plugin.buildInterceptPoint();
            for (InterceptPoint point : interceptPoints) {
                AgentBuilder.Transformer transformer = (builder, typeDescription, classLoader, javaModule) -> {
                    builder = builder.visit(Advice.to(plugin.adviceClass()).on(point.buildMethodsMacher()));
                    return builder;
                };
                agentBuilder = agentBuilder.type(point.buildTypesMacher()).transform(transformer);
            }
        }
        return agentBuilder;
    }
}
