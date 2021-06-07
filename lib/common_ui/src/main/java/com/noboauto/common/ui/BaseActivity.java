package com.noboauto.common.ui;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.ParameterizedType;

/**
 * Activity基类
 * 一个Activity包含一个ViewDataBinding和一个ViewModel
 *
 * @author zhongjiaxing
 * @date 2021/5/27
 */
public abstract class BaseActivity<B extends ViewDataBinding, VM extends ViewModel> extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    protected B mBinding;
    protected VM mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseInit();
    }

    private void baseInit() {
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mBinding.setLifecycleOwner(this);
        // 反射获取ViewModel的泛型类
        Class <VM> vmClass = (Class <VM>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        // 根据ViewModel类型选择相应的对象工厂
        ViewModelProvider.Factory factory = AndroidViewModel.class.isAssignableFrom(vmClass)
                ? ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())
                : new ViewModelProvider.NewInstanceFactory();
        // 获取ViewModel实例（如果实例化）
        mViewModel = (VM) new ViewModelProvider(this, factory).get(vmClass);
    }

    /**
     * 获取布局ID
     * @return
     */
    protected abstract @LayoutRes int getLayoutId();
}
