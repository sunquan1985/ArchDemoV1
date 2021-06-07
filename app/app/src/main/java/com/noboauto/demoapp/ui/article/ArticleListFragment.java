package com.noboauto.demoapp.ui.article;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.noboauto.common.event.UiEventListener;
import com.noboauto.common.ui.BaseFragment;
import com.noboauto.common.util.log.LogUtil;
import com.noboauto.demoapp.R;
import com.noboauto.demoapp.data.PageData;
import com.noboauto.demoapp.databinding.ArticleListFragmentBinding;
import com.noboauto.demoapp.domain.Article;

/**
 * 文章列表界面
 *
 * @author liujia
 */
public class ArticleListFragment extends BaseFragment<ArticleListFragmentBinding, ArticleListViewModel> {
    private static final String TAG = "ArticleListFragment";
    private ArticleListAdapter mRecyclerAdapter;

    @Override
    protected void init(ArticleListFragmentBinding binding, ArticleListViewModel viewModel) {
        mBinding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerAdapter = new ArticleListAdapter();
        mRecyclerAdapter.setEventListener(new UiEventListener<Article>() {
            @Override
            public void onClick(Article data) {
                mBinding.ivCloseBrowser.setVisibility(View.VISIBLE);
                mBinding.wvBrowser.setVisibility(View.VISIBLE);
                mBinding.wvBrowser.loadUrl(data.getUrl());
            }
        });
        mBinding.setRecyclerAdapter(mRecyclerAdapter);
        mBinding.recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if (!recyclerView.canScrollVertically(1)) {
                    LogUtil.i(TAG, "scroll to end");
                    mViewModel.loadNextPage();
                }
            }
        });
        mBinding.setEventListener(new UiEventListener<Integer>() {
            @Override
            public void onClick(Integer viewId) {
                mBinding.ivCloseBrowser.setVisibility(View.GONE);
                mBinding.wvBrowser.setVisibility(View.GONE);
            }
        });

        mViewModel.getPageData().observe(getViewLifecycleOwner(), new Observer<PageData<Article>>() {
            @Override
            public void onChanged(PageData<Article> pageData) {
                mRecyclerAdapter.appendArticles(pageData.data);
            }
        });
        mViewModel.getArticles(1);
        setUpWebView(mBinding.wvBrowser);
    }

    private void setUpWebView(WebView webView) {
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;// 返回false
            }
        });
        WebSettings webSettings = webView.getSettings();
        // 让WebView能够执行javaScript
        webSettings.setJavaScriptEnabled(true);
        // 让JavaScript可以自动打开windows
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        // 设置缓存
        webSettings.setAppCacheEnabled(true);
        // 设置缓存模式,一共有四种模式
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        // 设置缓存路径
//        webSettings.setAppCachePath("");
        // 支持缩放(适配到当前屏幕)
        webSettings.setSupportZoom(true);
        // 将图片调整到合适的大小
        webSettings.setUseWideViewPort(true);
        // 支持内容重新布局,一共有四种方式
        // 默认的是NARROW_COLUMNS
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        // 设置可以被显示的屏幕控制
        webSettings.setDisplayZoomControls(true);
        // 设置默认字体大小
        webSettings.setDefaultFontSize(12);

        // 设置WebView属性，能够执行Javascript脚本
        // mWebView.getSettings().setJavaScriptEnabled(true);
    }

    @Override
    protected int getLayout() {
        return R.layout.article_list_fragment;
    }
}
