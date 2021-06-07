package com.noboauto.demoapp.domain;

import com.google.gson.annotations.SerializedName;

/**
 * 分类
 *
 * @author zhongjiaxing
 */
public class Category {

    @SerializedName("_id")
    private String id;
    @SerializedName("coverImageUrl")
    private String coverImageUrl;
    @SerializedName("desc")
    private String desc;
    @SerializedName("title")
    private String title;
    @SerializedName("type")
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
}
