package com.noboauto.demoapp.data.source.remote.gank;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Gank Http客户端
 *
 * @author zhongjiaxing
 */
public class GankHttpClient {
    private static final String TAG = "GankHttpClient";
    private static final GankHttpClient instance = new GankHttpClient();
    private String API_BASE_URL = "https://gank.io/api/v2/";
    private OkHttpClient mOkHttpClient;
    private Retrofit mRetrofit;
    private GankApi mGankApi;

    private GankHttpClient() {
        init();
    }

    private void init() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.retryOnConnectionFailure(true)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS);
        mOkHttpClient = builder.build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        mGankApi = mRetrofit.create(GankApi.class);
    }

    public static GankHttpClient getInstance() {
        return instance;
    }

    public GankApi getGankApi() {
        return mGankApi;
    }
}
