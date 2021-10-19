package com.kaikeba.common.homer.agent.plugin.httpclient;

import com.kaikeba.common.homer.agent.plugin.InterceptPoint;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author zhaodahai
 * 2021/7/13
 */
public class HttpClientInterceptPoint implements InterceptPoint {

    @Override
    public ElementMatcher<TypeDescription> buildTypesMacher() {
        return ElementMatchers.hasSuperType(ElementMatchers.named("org.apache.http.client.HttpClient"))
                .and(ElementMatchers.not(ElementMatchers.isInterface()));
    }

    @Override
    public ElementMatcher<MethodDescription> buildMethodsMacher() {
        return ElementMatchers.isMethod().and(ElementMatchers.named("execute"));
    }
}
