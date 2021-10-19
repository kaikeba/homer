package com.kkb.common.homer.core;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @author zhaodahai
 * 2021/7/13
 */
public class HomerContextHolder {

    /**
     * 使用ttl保存数据
     */
    private static final TransmittableThreadLocal<HomerContext> HOMER_CONTEXT = new TransmittableThreadLocal<>();

    /**
     * 获取HomerContext
     * @return
     */
    public static HomerContext get(){
        return HOMER_CONTEXT.get();
    }

    /**
     * 设置HomerContext
     * @param homerContext
     */
    public static void set(HomerContext homerContext){
        HOMER_CONTEXT.set(homerContext);
    }

    /**
     * 清除ttl
     */
    public static void clear(){
        HOMER_CONTEXT.remove();
    }


}
