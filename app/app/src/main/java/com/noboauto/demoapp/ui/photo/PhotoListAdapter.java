package com.noboauto.demoapp.ui.photo;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.noboauto.common.event.UiEventListener;
import com.noboauto.demoapp.R;
import com.noboauto.demoapp.databinding.PhotoListRecycleItemBinding;
import com.noboauto.demoapp.domain.Article;

import java.util.ArrayList;
import java.util.List;

/**
 * 图片列表适配器
 *
 * @author zhongjiaxing
 */
public class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.PhotoHolder> {
    private List<Article> mArticles = new ArrayList<>();
    private UiEventListener<Article> mEventListener;

    @NonNull
    @Override
    public PhotoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PhotoListRecycleItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.photo_list_recycle_item, parent, false);
        return new PhotoHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoHolder holder, int position) {
        holder.itemBinding.setPhoto(mArticles.get(position));
        holder.itemBinding.setEventListener(mEventListener);
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }

    public class PhotoHolder extends RecyclerView.ViewHolder {
        PhotoListRecycleItemBinding itemBinding;
        public PhotoHolder(PhotoListRecycleItemBinding binding) {
            super(binding.getRoot());
            itemBinding = binding;
        }
    }

    public void setPhotos(List<Article> articles) {
        mArticles = articles;
    }

    public void appendPhotos(List<Article> articles) {
        int oldSize = mArticles.size();
        mArticles.addAll(articles);
        notifyItemRangeChanged(oldSize, mArticles.size());
    }

    public void setEventListener(UiEventListener<Article> eventListener) {
        mEventListener = eventListener;
    }
}
