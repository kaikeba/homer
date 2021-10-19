package com.kaikeba.common.homer.agent.plugin.okhttp;

import com.kaikeba.common.homer.agent.plugin.InterceptPoint;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author zhaodahai
 * 2021/7/13
 */
public class OkhttpInterceptPoint implements InterceptPoint {
    @Override
    public ElementMatcher<TypeDescription> buildTypesMacher() {
        return ElementMatchers.named("okhttp3.Request");

    }

    @Override
    public ElementMatcher<MethodDescription> buildMethodsMacher() {
        return ElementMatchers.isConstructor();
    }
}
