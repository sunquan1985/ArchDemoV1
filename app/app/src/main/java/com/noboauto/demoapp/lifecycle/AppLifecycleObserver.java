package com.noboauto.demoapp.lifecycle;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;


/**
 * 应用声明周期监听
 * 判断应用是否前台
 * 可以实现两种接口其中一个
 * 1. LifecycleEventObserver 以统一方法onStateChanged的方式回调
 * 2. LifecycleObserver 回调方法上面的注解
 *
 * @author zhongjiaxing
 * @date 2021/5/28
 */
public class AppLifecycleObserver implements LifecycleEventObserver {
    private static final String TAG = "ApplicationLifecycleObs";
    private Lifecycle.Event mEvent;

    @Override
    public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
        Log.i(TAG, "onStateChanged: " + source + " event: "+ event);
        mEvent = event;
    }
/*
    // 实现LifecycleEventObserver可使用单个方法注解的方式
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(){
        Log.i(TAG, "onStateChanged: onStart");
    }*/

    public boolean isAppFront() {
        return mEvent == Lifecycle.Event.ON_RESUME;
    }
}
