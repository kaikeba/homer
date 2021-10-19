package com.kaikeba.common.homer.agent.plugin.okhttp;

import com.kkb.common.homer.core.HomerContext;
import com.kkb.common.homer.core.HomerContextHolder;
import net.bytebuddy.asm.Advice;

/**
 * @author zhaodahai
 * 2021/7/13
 */
public class OkhttpAdvice {

    public static ThreadLocal<Boolean> OKHTTP_HANDLED = new ThreadLocal<>();


    @Advice.OnMethodEnter()
    public static void enter(@Advice.Origin("#t") String className,
                             @Advice.Origin("#m") String methodName,
                             @Advice.AllArguments Object[] allArguments) {
        if (OKHTTP_HANDLED.get() != null){
            OKHTTP_HANDLED.remove();
            return;
        }
        System.out.println("okhttp:className:" + className + ",methodName:" + methodName);
        HomerContext homerContext = HomerContextHolder.get();
        if (homerContext == null || homerContext.isEmpty()) {
            return;
        }
        for (Object argument : allArguments) {
            if (argument instanceof okhttp3.Request.Builder) {
                okhttp3.Request.Builder builder = (okhttp3.Request.Builder) allArguments[0];
                homerContext.forEach(builder::header);
                break;
            }
        }
        OKHTTP_HANDLED.set(true);
    }

}
