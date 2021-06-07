package com.noboauto.demoapp;

import androidx.lifecycle.ProcessLifecycleOwner;

import com.noboauto.base.component.CommonApplication;
import com.noboauto.demoapp.data.source.DataSourceManager;
import com.noboauto.demoapp.data.source.remote.gank.GankDataSource;
import com.noboauto.demoapp.lifecycle.AppLifecycleObserver;

/**
 * 应用自定义Application
 *
 * @author zhongjiaxing
 */
public class AppApplication extends CommonApplication {
    private static final String TAG = "AppApplication";
    private AppLifecycleObserver mAppLifeObserver;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        // NOTE [冷启动] Application的初始化尽可能保持轻量、迅速，非必要组件的初始化放到子线程

        // 监听应用生命周期（业务场景需要判断应用是否在前台可以参考使用）
        ProcessLifecycleOwner.get().getLifecycle().addObserver(mAppLifeObserver = new AppLifecycleObserver());

        // 配置网络数据源
        DataSourceManager.getInstance().setDataSource(new GankDataSource());
    }
}
