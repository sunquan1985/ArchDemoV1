package com.noboauto.demoapp.data.source.remote.gank.response;

import com.google.gson.annotations.SerializedName;

/**
 * API响应
 *
 * @author zhongjiaxing
 */
public class ApiResponse<T> {
    @SerializedName("status")
    public Integer status;
    @SerializedName("data")
    public T data;
    /**
     * 以下属性是为适配gank.io接口定义，api接口常定定义为code、msg、data的格式。
     */
    @SerializedName("page")
    public Integer page;
    @SerializedName("page_count")
    public Integer pageCount;
    @SerializedName("total_counts")
    public Integer totalCounts;
}
