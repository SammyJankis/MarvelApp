package com.arturoguillen.marvelapp.entity.comic;

import com.arturoguillen.marvelapp.entity.Image;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by artu on 3/8/17.
 */

public class Comic implements Serializable {

    private static final long serialVersionUID = 1L;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("thumbnail")
    private Image thumbnail;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }

}
