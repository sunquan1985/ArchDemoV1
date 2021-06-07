package com.noboauto.demoapp.data.source.remote.gank;

import com.noboauto.demoapp.data.source.remote.gank.response.ApiResponse;
import com.noboauto.demoapp.domain.Article;
import com.noboauto.demoapp.domain.Category;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Gank接口
 *
 * @author zhongjiaxing
 */
public interface GankApi {

    /**
     * 获取某类型下的子分类
     *
     * @param type
     * @return
     */
    @GET("/api/v2/categories/{type}")
    Observable<ApiResponse<List<Category>>> fetchCategories(@Path("type") String type);

    /**
     * 获取子分类下的资源
     *
     * @param category
     * @param page
     * @param limit
     * @return
     */
    @GET("/api/v2/data/category/{category}/type/All/page/{page}/count/{limit}")
    Observable<ApiResponse<List<Article>>> fetchResources(@Path("category") String category,
                                                          @Path("page") int page, @Path("limit") int limit);
}
