package com.noboauto.demoapp.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 图片
 *
 * @author zhongjiaxing
 */
public class Article {
    public static final String CATEGORY_GIRL = "Girl";
    public static final String CATEGORY_ARTICLE = "Article";
    public static final String CATEGORY_GAN_HUO = "GanHuo";

    @SerializedName("_id")
    private String id;
    @SerializedName("author")
    private String author;
    @SerializedName("category")
    private String category;
    @SerializedName("createdAt")
    private String createdAt;
    @SerializedName("desc")
    private String desc;
    @SerializedName("images")
    private List<String> images;
    @SerializedName("likeCounts")
    private Integer likeCounts;
    @SerializedName("publishedAt")
    private String publishedAt;
    @SerializedName("stars")
    private Integer stars;
    @SerializedName("title")
    private String title;
    @SerializedName("type")
    private String type;
    @SerializedName("url")
    private String url;
    @SerializedName("views")
    private Integer views;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Integer getLikeCounts() {
        return likeCounts;
    }

    public void setLikeCounts(Integer likeCounts) {
        this.likeCounts = likeCounts;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }
}
