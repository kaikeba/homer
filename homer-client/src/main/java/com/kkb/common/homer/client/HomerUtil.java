package com.kkb.common.homer.client;

import com.kkb.common.homer.core.HomerContext;
import com.kkb.common.homer.core.HomerContextHolder;

/**
 * @author zhaodahai
 * 2021/7/13
 */
public class HomerUtil {

    public static final String HOMER_HEADER_PREFIX = "homer-";


    /**
     * 设置key,key有前缀，和value
     *
     * @param key
     * @param value
     */
    public static void setWithPrefix(String key, String value) {
        HomerContext homerContext = HomerContextHolder.get();
        if (homerContext == null) {
            homerContext = new HomerContext();
        }
        homerContext.put(key, value);
        HomerContextHolder.set(homerContext);
    }

    /**
     * 设置key和value
     *
     * @param key
     * @param value
     */
    public static void set(String key, String value) {
        HomerContext homerContext = HomerContextHolder.get();
        if (homerContext == null) {
            homerContext = new HomerContext();
            HomerContextHolder.set(homerContext);
        }
        homerContext.put(HOMER_HEADER_PREFIX + key, value);
    }

    /**
     * 根据Key获取value
     *
     * @param key
     * @return
     */
    public static String get(String key) {
        HomerContext homerContext = HomerContextHolder.get();
        if (homerContext == null) {
            return null;
        }
        return homerContext.get(HOMER_HEADER_PREFIX + key);
    }
}
