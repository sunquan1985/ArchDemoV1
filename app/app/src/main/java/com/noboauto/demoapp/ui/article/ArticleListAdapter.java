package com.noboauto.demoapp.ui.article;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.noboauto.common.event.UiEventListener;
import com.noboauto.demoapp.R;
import com.noboauto.demoapp.databinding.ArticleListRecycleItemBinding;
import com.noboauto.demoapp.domain.Article;

import java.util.ArrayList;
import java.util.List;

/**
 * 图片列表适配器
 *
 * @author zhongjiaxing
 */
public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ArticleHolder> {
    private static final String TAG = "ArticleListAdapter";
    private List<Article> mArticles = new ArrayList<>();
    private UiEventListener<Article> mEventListener;

    @Override
    public ArticleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ArticleListRecycleItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.article_list_recycle_item, parent, false);
        return new ArticleHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleHolder holder, int position) {
        holder.itemBinding.setArticle(mArticles.get(position));
        holder.itemBinding.setEventListener(mEventListener);
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }

    public class ArticleHolder extends RecyclerView.ViewHolder {
        ArticleListRecycleItemBinding itemBinding;

        public ArticleHolder(ArticleListRecycleItemBinding binding) {
            super(binding.getRoot());
            itemBinding = binding;
        }
    }

    public void appendArticles(List<Article> articles) {
        int oldSize = mArticles.size();
        mArticles.addAll(articles);
        notifyItemRangeChanged(oldSize, mArticles.size());
    }

    public void setEventListener(UiEventListener<Article> eventListener) {
        mEventListener = eventListener;
    }
}
