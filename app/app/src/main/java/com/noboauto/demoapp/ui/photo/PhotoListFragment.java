package com.noboauto.demoapp.ui.photo;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.noboauto.common.event.UiEventListener;
import com.noboauto.common.ui.BaseFragment;
import com.noboauto.common.ui.RecycleGridDivider;
import com.noboauto.common.util.log.LogUtil;
import com.noboauto.demoapp.R;
import com.noboauto.demoapp.data.PageData;
import com.noboauto.demoapp.databinding.PhotoListFragmentBinding;
import com.noboauto.demoapp.domain.Article;

/**
 * 图片列表界面
 *
 * @author liujia
 */
public class PhotoListFragment extends BaseFragment<PhotoListFragmentBinding, PhotoListViewModel> {
    private static final String TAG = "PhotoFragment";
    private PhotoListAdapter mPhotoListAdapter;

    @Override
    protected void init(PhotoListFragmentBinding binding, PhotoListViewModel viewModel) {
        mBinding.recyclerview.setLayoutManager(new GridLayoutManager(getContext(),3));
        mBinding.recyclerview.addItemDecoration(new RecycleGridDivider(10));
        mPhotoListAdapter = new PhotoListAdapter();
        mPhotoListAdapter.setEventListener(new UiEventListener<Article>() {
            @Override
            public void onClick(Article data) {
                Glide.with(getContext()).load(data.getUrl()).into(mBinding.ivPhotoPreview);
                mBinding.ivPhotoPreview.setVisibility(View.VISIBLE);
            }
        });
        mBinding.setRecyclerAdapter(mPhotoListAdapter);
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
                mBinding.ivPhotoPreview.setVisibility(View.GONE);
            }
        });
        mViewModel.getPageData().observe(getViewLifecycleOwner(), new Observer<PageData<Article>>() {
            @Override
            public void onChanged(PageData<Article> pageData) {
                mPhotoListAdapter.appendPhotos(pageData.data);
            }
        });
        mViewModel.getPhotos(1);
    }

    @Override
    protected int getLayout() {
        return R.layout.photo_list_fragment;
    }
}
