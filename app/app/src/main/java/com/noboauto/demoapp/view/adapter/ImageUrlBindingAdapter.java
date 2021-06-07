package com.noboauto.demoapp.view.adapter;

import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.noboauto.common.util.ContextHolder;

/**
 * 列表Item图片适配器
 *
 * @author zhongjiaxing
 * @date 2021/5/31
 */
public class ImageUrlBindingAdapter {

    @BindingAdapter("imgUrl")
    public static void setImageUrl(ImageView image, String imageUrl) {
        if (!TextUtils.isEmpty(imageUrl)) {
            Glide.with(ContextHolder.getContext()).load(imageUrl).into(image);
        }
    }
}
