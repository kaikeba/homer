package com.kaikeba.common.homer.agent.plugin.resttemplate;

import com.kaikeba.common.homer.agent.plugin.InterceptPoint;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * 拦截RestTemplate的execute方法，参考restTemplate拦截器
 * @author zhaodahai
 * 2021/7/7
 */
public class RestTemplateInterceptPoint implements InterceptPoint {
    @Override
    public ElementMatcher<TypeDescription> buildTypesMacher() {
        return ElementMatchers.hasSuperType(ElementMatchers.named("org.springframework.http.client.ClientHttpRequest"))
                .and(ElementMatchers.not(ElementMatchers.isAbstract()));
    }

    @Override
    public ElementMatcher<MethodDescription> buildMethodsMacher() {

        return ElementMatchers.isMethod()
                .and(ElementMatchers.named("executeInternal"))
                .and(ElementMatchers.takesArgument(0, ElementMatchers.hasSuperType(ElementMatchers.named("org.springframework.http.HttpHeaders"))));
    }
}
