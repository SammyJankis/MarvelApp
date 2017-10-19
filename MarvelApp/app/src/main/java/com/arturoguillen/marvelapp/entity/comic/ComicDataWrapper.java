package com.arturoguillen.marvelapp.entity.comic;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by artu on 3/8/17.
 */

public class ComicDataWrapper implements Serializable {

    private static final long serialVersionUID = 1L;

    @SerializedName("data")
    private ComicDataContainer data;

    public ComicDataContainer getData() {
        return data;
    }

    public void setData(ComicDataContainer data) {
        this.data = data;
    }

}
