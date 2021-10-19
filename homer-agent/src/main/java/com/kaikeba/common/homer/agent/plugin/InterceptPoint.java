package com.kaikeba.common.homer.agent.plugin;

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;

/**
 * @author zhaodahai
 * 2021/7/13
 */
public interface InterceptPoint {

    /**
     * 类匹配规则
     * @return
     */
    ElementMatcher<TypeDescription> buildTypesMacher();

    /**
     * 方法匹配规则
     * @return
     */
    ElementMatcher<MethodDescription> buildMethodsMacher();

}
