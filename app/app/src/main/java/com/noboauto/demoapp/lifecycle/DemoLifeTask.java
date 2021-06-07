package com.noboauto.demoapp.lifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * 生命周期相关的任务
 * 可以实现两种接口其中一个
 * 1. LifecycleEventObserver 以统一方法onStateChanged的方式回调
 * 2. LifecycleObserver 回调方法上面的注解
 * @author zhongjiaxing
 * @date 2021/5/28
 */
public class DemoLifeTask implements LifecycleObserver {
    private static final String TAG = "DemoLifeTask";

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void startTask() {
        Log.i(TAG, "startTask: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void pauseTask() {
        Log.i(TAG, "pauseTask: ");
    }
}
