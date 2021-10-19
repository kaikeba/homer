package com.kaikeba.common.homer.agent.plugin.servlet;


import com.kkb.common.homer.client.HomerUtil;
import com.kkb.common.homer.core.HomerContextHolder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bytecode.assign.Assigner;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author zhaodahai
 * 2021/7/7
 */
public class ServletAdvice {

    public static ThreadLocal<Boolean> SERVLET_HANDLED = new ThreadLocal<>();

    @Advice.OnMethodEnter()
    public static void enter(@Advice.Origin("#t") String className,
                             @Advice.Origin("#m") String methodName,
                             @Advice.Argument(value = 0, readOnly = false, typing = Assigner.Typing.DYNAMIC) Object req) {
        if (SERVLET_HANDLED.get() != null) {
            SERVLET_HANDLED.remove();
            return;
        }
        HttpServletRequest request = (HttpServletRequest) req;
        // 遍历所有header，取Homer-开头的放入ttl中
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            if (headerName.startsWith(HomerUtil.HOMER_HEADER_PREFIX)) {
                HomerUtil.setWithPrefix(headerName, request.getHeader(headerName));
            }
        }
        SERVLET_HANDLED.set(true);
    }

    @Advice.OnMethodExit()
    public static void exit(@Advice.Origin("#t") String className,
                            @Advice.Origin("#m") String methodName,
                            @Advice.Argument(value = 0, readOnly = false, typing = Assigner.Typing.DYNAMIC) Object req,
                            @Advice.Argument(value = 1, readOnly = false, typing = Assigner.Typing.DYNAMIC) Object resp) {
        // 请求结束清除ttl，防止内存泄漏
        if (HomerContextHolder.get() != null) {
            HomerContextHolder.clear();
        }
    }

}
