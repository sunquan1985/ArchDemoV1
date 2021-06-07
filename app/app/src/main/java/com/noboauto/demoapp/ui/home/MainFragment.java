package com.noboauto.demoapp.ui.home;

import androidx.navigation.Navigation;

import com.noboauto.common.event.UiEventListener;
import com.noboauto.common.ui.BaseFragment;
import com.noboauto.demoapp.R;
import com.noboauto.demoapp.databinding.MainFragmentBinding;

/**
 * 主界面
 * @author liujia
 */
public class MainFragment extends BaseFragment<MainFragmentBinding, MainViewModel> {

    @Override
    protected void init(MainFragmentBinding binding, MainViewModel viewModel) {
        mBinding.setEventListener((UiEventListener<Integer>) viewId -> {
            if (viewId == R.id.btn_photo) {
                Navigation.findNavController(getView()).navigate(R.id.action_main_to_photo);
            } else if (viewId == R.id.btn_article) {
                Navigation.findNavController(getView()).navigate(R.id.action_main_to_article);
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.main_fragment;
    }
}
