package com.kaikeba.common.homer.agent.plugin.feign;

import com.kaikeba.common.homer.agent.plugin.InterceptPoint;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author zhaodahai
 * 2021/7/7
 */
public class FeignInterceptPoint implements InterceptPoint {

    @Override
    public ElementMatcher<TypeDescription> buildTypesMacher() {
        return ElementMatchers.named("feign.SynchronousMethodHandler");
    }

    @Override
    public ElementMatcher<MethodDescription> buildMethodsMacher() {
        return ElementMatchers.isMethod()
                .and(ElementMatchers.named("targetRequest"));
    }
}
