package com.kaikeba.common.homer.agent.plugin.httpclient;

import com.kkb.common.homer.core.HomerContext;
import com.kkb.common.homer.core.HomerContextHolder;
import net.bytebuddy.asm.Advice;
import org.apache.http.HttpRequest;

import java.util.Map;

/**
 * @author zhaodahai
 * 2021/7/13
 */
public class HttpClientAdvice {

    public static ThreadLocal<Boolean> HTTPCLIENT_HANDLED = new ThreadLocal<>();

    @Advice.OnMethodEnter()
    public static void enter(@Advice.Origin("#t") String className,
                             @Advice.Origin("#m") String methodName,
                             @Advice.AllArguments Object[] args) {
        if (HTTPCLIENT_HANDLED.get() != null){
            HTTPCLIENT_HANDLED.remove();
            return;
        }
        System.out.println("httpClient:className:" + className + ",methodName:" + methodName);
        HomerContext homerContext = HomerContextHolder.get();
        if (homerContext == null || homerContext.isEmpty()){
            return;
        }
        for (Object arg : args) {
            if (arg instanceof HttpRequest){
                HttpRequest httpRequest = (HttpRequest) arg;
                // homerContext.forEach(httpRequest::addHeader);
                for (Map.Entry<String,String> entry:homerContext.entrySet()){
                    httpRequest.addHeader(entry.getKey(),entry.getValue());
                    break;
                }
            }
        }
        HTTPCLIENT_HANDLED.set(true);
    }
}
