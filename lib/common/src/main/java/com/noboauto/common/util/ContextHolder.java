package com.noboauto.common.util;

import android.content.Context;

/**
 * Context工具类
 * 持有Application级别的全局Context
 *
 * @author zhongjiaxing
 */
public class ContextHolder {
    private static Context sContext;

    public static Context getContext() {
        return sContext;
    }

    public static void setContext(Context context) {
        sContext = context;
    }
}
