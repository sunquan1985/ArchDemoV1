package com.noboauto.common.event;

/**
 * 界面事件监听接口
 *
 * @author zhongjiaxing
 * @date 2021/6/2
 */
public interface UiEventListener<T> {
    /**
     * 被点击
     * @param data
     */
    void onClick(T data);
}
