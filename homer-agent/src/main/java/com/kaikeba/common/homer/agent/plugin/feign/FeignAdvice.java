package com.kaikeba.common.homer.agent.plugin.feign;

import com.kkb.common.homer.core.HomerContext;
import com.kkb.common.homer.core.HomerContextHolder;
import feign.RequestTemplate;
import net.bytebuddy.asm.Advice;

import java.util.Map;

/**
 * @author zhaodahai
 * 2021/7/7
 */
public class FeignAdvice {

    public static ThreadLocal<Boolean> FEIGN_HANDLED = new ThreadLocal<>();


    @Advice.OnMethodEnter()
    public static void enter(@Advice.Origin("#t") String className,
                             @Advice.Origin("#m") String methodName,
                             @Advice.AllArguments Object[] allArgs) {
        if (FEIGN_HANDLED.get() != null) {
            FEIGN_HANDLED.remove();
            return;
        }
        System.out.println("feigns:className:" + className + ",methodName:" + methodName);
        HomerContext homerContext = HomerContextHolder.get();
        if (homerContext == null || homerContext.isEmpty()) {
            return;
        }
        for (Object arg : allArgs) {
            if (arg instanceof RequestTemplate) {
                RequestTemplate requestTemplate = (RequestTemplate) arg;
                // homerContext.forEach(requestTemplate::header);
                for (Map.Entry<String, String> entry : homerContext.entrySet()) {
                    requestTemplate.header(entry.getKey(), entry.getValue());
                }
                break;
            }
        }
        FEIGN_HANDLED.set(true);
    }

}
