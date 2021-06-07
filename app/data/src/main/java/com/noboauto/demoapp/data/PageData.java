package com.noboauto.demoapp.data;

import java.util.List;

/**
 * 分页数据
 *
 * @author zhongjiaxing
 */
public class PageData<T> {
    public List<T> data;
    public int totalCount;
    public int totalPage;
    public int page;
    public int limit;
}
