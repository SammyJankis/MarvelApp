package com.arturoguillen.marvelapp.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by artu on 3/8/17.
 */

public class Url implements Serializable {

    private static final long serialVersionUID = 1L;

    @SerializedName("type")
    private String type;

    @SerializedName("url")
    private String url;

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
}
