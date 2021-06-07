package com.noboauto.demoapp.ui.home;

import androidx.lifecycle.ViewModel;

import com.noboauto.demoapp.data.source.DataSourceManager;
import com.noboauto.demoapp.data.source.remote.DataSource;

/**
 * 主界面ViewModel
 *
 * @author zhongjiaxing
 * @date 2021/5/28
 */
public class MainViewModel extends ViewModel {
    private static final String TAG = "MainViewModel";
    private DataSource mDataSource;

    public MainViewModel() {
        mDataSource = DataSourceManager.getInstance().getDataSource();
    }
}
