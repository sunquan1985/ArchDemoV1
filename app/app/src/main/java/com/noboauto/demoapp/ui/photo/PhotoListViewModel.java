package com.noboauto.demoapp.ui.photo;

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
 * 照片列表ViewModel
 * 负责调用业务API获取数据并保存数据，当Activity发生重建时，数据不会丢失。
 * 实例化方式：
 * 1. 继承自ViewModel
 * new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(vmClass)
 * 2. 当View需要使用Context时，可以继承AndroidViewModel(提供application级别的Context)
 * new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(vmClass)
 *
 * @author zhongjiaxing
 * @date 2021-5-27
 */
public class PhotoListViewModel extends ViewModel {
    private static final String TAG = "PhotoListViewModel";
    private int mLastPageSize = 12;
    private MutableLiveData<PageData<Article>> mPageData = new MutableLiveData<>();
    private DataSource mDataSource;

    public PhotoListViewModel() {
        mDataSource = DataSourceManager.getInstance().getDataSource();
    }

    public void getPhotos(int pageNumber) {
        mDataSource.getArticles(Article.CATEGORY_GIRL, pageNumber, mLastPageSize)
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
        getPhotos(mPageData.getValue().page += 1);
    }
}
