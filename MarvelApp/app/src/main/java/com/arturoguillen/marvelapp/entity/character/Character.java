package com.arturoguillen.marvelapp.entity.character;

import com.arturoguillen.marvelapp.entity.BaseResource;
import com.arturoguillen.marvelapp.entity.Url;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by agl on 19/10/2017.
 */

public class Character extends BaseResource {

    @SerializedName("urls")
    private List<Url> urls;

    public List<Url> getUrls() {
        return urls;
    }

    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }
}
