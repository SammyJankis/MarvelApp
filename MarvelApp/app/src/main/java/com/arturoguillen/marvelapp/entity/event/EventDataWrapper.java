package com.arturoguillen.marvelapp.entity.event;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by agl on 19/10/2017.
 */

public class EventDataWrapper implements Serializable {

    private static final long serialVersionUID = 1L;

    @SerializedName("data")
    private EventDataContainer data;

    public EventDataContainer getData() {
        return data;
    }

    public void setData(EventDataContainer data) {
        this.data = data;
    }
}