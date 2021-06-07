package com.noboauto.demoapp.ui.article;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.noboauto.base.BaseObserver;
import com.noboauto.demoapp.data.PageData;
import com.noboauto.demoapp.data.source.DataSourceManager;
import com.noboauto.demoapp.data.source.remote.DataSource;
import com.noboauto.demoapp.domain.Article;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * 文章列表ViewModel
 *
 * @author zhongjiaxing
 * @date 2021/6/1
 */
public class ArticleListViewModel extends ViewModel {
    private static final String TAG = "ArticleListViewModel";
    private int mLastPageSize = 10;
    private MutableLiveData<PageData<Article>> mPageData = new MutableLiveData<>();
    private DataSource mDataSource;

    public ArticleListViewModel() {
        mDataSource = DataSourceManager.getInstance().getDataSource();
    }

    public void getArticles(int pageNumber) {
        mDataSource.getArticles(Article.CATEGORY_GAN_HUO, pageNumber, mLastPageSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<PageData<Article>>() {

                    @Override
                    public void onNext(@NonNull PageData<Article> data) {
                        mPageData.setValue(data);
                    }
                });
    }

    public MutableLiveData<PageData<Article>> getPageData() {
        return mPageData;
    }

    public void loadNextPage() {
        // TODO: 2021/5/31 实际项目需要做页码处理
        getArticles(mPageData.getValue().page += 1);
    }
}
