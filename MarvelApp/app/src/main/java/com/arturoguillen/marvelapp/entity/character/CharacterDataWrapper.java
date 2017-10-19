package com.arturoguillen.marvelapp.entity.character;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by artu on 3/8/17.
 */

public class CharacterDataWrapper implements Serializable {

    private static final long serialVersionUID = 1L;

    @SerializedName("data")
    private CharacterDataContainer data;

    public CharacterDataContainer getData() {
        return data;
    }

    public void setData(CharacterDataContainer data) {
        this.data = data;
    }
}
