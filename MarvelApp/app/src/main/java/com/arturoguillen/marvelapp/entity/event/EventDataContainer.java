package com.arturoguillen.marvelapp.entity.event;

import com.arturoguillen.marvelapp.entity.DataContainer;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by agl on 19/10/2017.
 */

class EventDataContainer extends DataContainer implements Serializable {

    private static final long serialVersionUID = 1L;

    @SerializedName("results")
    private List<Event> results;

    public List<Event> getResults() {
        return results;
    }

    public void setResults(List<Event> results) {
        this.results = results;
    }
}
