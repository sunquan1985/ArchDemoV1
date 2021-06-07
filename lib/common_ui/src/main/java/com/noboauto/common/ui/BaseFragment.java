package com.noboauto.common.ui;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.ParameterizedType;

/**
 * Fragment基类
 * 一个Fragment包含一个ViewDataBinding和一个ViewModel
 *
 * @author zhongjiaxing
 * @date 2021/6/1
 */
public abstract class BaseFragment<B extends ViewDataBinding, VM extends ViewModel> extends Fragment {
    protected B mBinding;
    protected VM mViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, getLayout(), container, false);
        mBinding.setLifecycleOwner(this);
        initViewModel();
        init(mBinding, mViewModel);
        return mBinding.getRoot();
    }

    /**
     * 子类实现各自初始化逻辑
     *
     * @param binding
     * @param viewModel
     */
    protected abstract void init(B binding, VM viewModel);

    private void initViewModel() {
        // 反射获取ViewModel的泛型类
        Class <VM> vmClass = (Class <VM>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        // 根据ViewModel类型选择相应的对象工厂
        ViewModelProvider.Factory factory = AndroidViewModel.class.isAssignableFrom(vmClass)
                ? ViewModelProvider.AndroidViewModelFactory.getInstance((Application) getContext().getApplicationContext())
                : new ViewModelProvider.NewInstanceFactory();
        // 获取ViewModel实例（如果实例化）
        mViewModel = (VM) new ViewModelProvider(this, factory).get(vmClass);
    }

    /**
     * 获取布局ID
     * @return
     */
    protected abstract @LayoutRes int getLayout();
}
