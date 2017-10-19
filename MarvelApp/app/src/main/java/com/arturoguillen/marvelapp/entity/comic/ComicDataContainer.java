package com.arturoguillen.marvelapp.entity.comic;

import com.arturoguillen.marvelapp.entity.DataContainer;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by artu on 3/8/17.
 */

public class ComicDataContainer extends DataContainer implements Serializable {

    private static final long serialVersionUID = 1L;

    @SerializedName("results")
    private List<Comic> results;

    public List<Comic> getResults() {
        return results;
    }

    public void setResults(List<Comic> results) {
        this.results = results;
    }

}
