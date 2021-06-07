package com.noboauto.base.component;

import android.app.Application;

import com.noboauto.common.util.ContextHolder;

/**
 * 公共Application
 *
 * @author zhongjiaxing
 */
public class CommonApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ContextHolder.setContext(this);
    }
}
