package com.noboauto.demoapp.data.source.remote;

import com.noboauto.demoapp.data.PageData;
import com.noboauto.demoapp.domain.Article;

import io.reactivex.rxjava3.core.Observable;

/**
 * 数据源接口
 *
 * @author zhongjiaxing
 */
public interface DataSource {
    /**
     * 返回照片列表
     *
     * @param type
     * @param page
     * @param limit
     * @return
     */
    Observable<PageData<Article>> getArticles(String type, int page, int limit);
}
