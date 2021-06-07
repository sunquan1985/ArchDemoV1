package com.noboauto.demoapp.data.source.remote.gank;

import com.noboauto.demoapp.data.PageData;
import com.noboauto.demoapp.data.source.remote.DataSource;
import com.noboauto.demoapp.data.source.remote.gank.response.ApiResponse;
import com.noboauto.demoapp.domain.Article;

import java.util.List;
import java.util.Objects;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;

/**
 * Gank网站数据源
 *
 * @author zhongjiaxing
 */
public class GankDataSource implements DataSource {
    private GankApi mGankApi;

    public GankDataSource() {
        mGankApi = GankHttpClient.getInstance().getGankApi();
    }

    @Override
    public Observable<PageData<Article>> getArticles(String category, int page, int limit) {
        return mGankApi.fetchResources(category, page, limit)
                // 转为通用数据结构
                .map(new Function<ApiResponse<List<Article>>, PageData<Article>>() {
                    @Override
                    public PageData<Article> apply(ApiResponse<List<Article>> response) throws Throwable {
                        PageData<Article> pageData = new PageData<>();
                        if (Objects.nonNull(response) && Objects.nonNull(response.data)) {
                            pageData.data = response.data;
                            pageData.totalCount = response.pageCount;
                            pageData.page = response.page;
                            pageData.totalCount = response.totalCounts;
                        }
                        return pageData;
                    }
                });
    }
}
