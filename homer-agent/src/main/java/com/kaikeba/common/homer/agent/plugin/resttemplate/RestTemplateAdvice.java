package com.kaikeba.common.homer.agent.plugin.resttemplate;

import com.kkb.common.homer.core.HomerContext;
import com.kkb.common.homer.core.HomerContextHolder;
import net.bytebuddy.asm.Advice;
import org.springframework.http.HttpHeaders;

/**
 * @author zhaodahai
 * 2021/7/7
 */
public class RestTemplateAdvice {

    public static ThreadLocal<Boolean> RESTTEMPLATE_HANDLED = new ThreadLocal<>();


    @Advice.OnMethodEnter()
    public static void enter(@Advice.Origin("#t") String className,
                             @Advice.Origin("#m") String methodName,
                             @Advice.AllArguments Object[] args) {
        if (RESTTEMPLATE_HANDLED.get() != null) {
            RESTTEMPLATE_HANDLED.remove();
            return;
        }
        System.out.println("restTemplate-enter-classname:" + className + ",methodName:" + methodName);
        // 从ttl中遍历取key和value，放入header中
        HomerContext homerContext = HomerContextHolder.get();
        if (homerContext == null || homerContext.isEmpty()) {
            return;
        }
        for (Object arg : args) {
            if (arg instanceof HttpHeaders) {
                HttpHeaders httpHeaders = (HttpHeaders) arg;
                homerContext.forEach(httpHeaders::add);
                break;
            }
        }
        RESTTEMPLATE_HANDLED.set(true);
    }

}
