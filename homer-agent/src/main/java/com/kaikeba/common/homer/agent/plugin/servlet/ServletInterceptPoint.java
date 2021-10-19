package com.kaikeba.common.homer.agent.plugin.servlet;

import com.kaikeba.common.homer.agent.plugin.InterceptPoint;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author zhaodahai
 * 2021/7/7
 */
public class ServletInterceptPoint implements InterceptPoint {

    @Override
    public ElementMatcher<TypeDescription> buildTypesMacher() {
        return ElementMatchers.hasSuperType(ElementMatchers.named("javax.servlet.http.HttpServlet"))
                .and(ElementMatchers.not(ElementMatchers.isAbstract()));
    }

    @Override
    public ElementMatcher<MethodDescription> buildMethodsMacher() {
        return ElementMatchers.isMethod()
                .and(ElementMatchers.takesArguments(2))
                .and(ElementMatchers.takesArgument(0, ElementMatchers.hasSuperType(ElementMatchers.named("javax.servlet.http.HttpServletRequest"))))
                .and(ElementMatchers.takesArgument(1, ElementMatchers.hasSuperType(ElementMatchers.named("javax.servlet.http.HttpServletResponse"))))
                .and(ElementMatchers.nameStartsWith("do"));
    }
}
