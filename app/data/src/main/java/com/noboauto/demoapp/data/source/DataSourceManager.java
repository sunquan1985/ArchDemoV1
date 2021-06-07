package com.noboauto.demoapp.data.source;

import com.noboauto.demoapp.data.source.remote.DataSource;

/**
 * 数据源管理器
 * 持有数据源的实现
 *
 * @author zhongjiaxing
 */
public class DataSourceManager {
    private static final String TAG = "DataSourceManager";
    private static final DataSourceManager instance = new DataSourceManager();
    private DataSource mDataSource;
    private DataSourceManager() {

    }

    public static DataSourceManager getInstance() {
        return instance;
    }

    public DataSource getDataSource() {
        return mDataSource;
    }

    public void setDataSource(DataSource mDataSource) {
        this.mDataSource = mDataSource;
    }
}
