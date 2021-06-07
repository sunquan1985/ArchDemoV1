package com.noboauto.common.util.log;

import android.util.Log;

/**
 * 日志打印工具类
 *
 * @author zhongjiaxing
 */
public class LogUtil {
    // TODO: 2021/5/12 日志工具类完善

    public static void v(String tag, String msg) {
        Log.v(tag, msg);
    }

    public static void d(String tag, String msg) {
        Log.d(tag, msg);
    }

    public static void i(String tag, String msg) {
        Log.i(tag, msg);
    }

    public static void w(String tag, String msg) {
        Log.w(tag, msg);
    }

    public static void e(String tag, String msg) {
        Log.e(tag, msg);
    }

}
