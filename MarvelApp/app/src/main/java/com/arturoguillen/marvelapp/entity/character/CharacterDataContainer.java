package com.arturoguillen.marvelapp.entity.character;

import com.arturoguillen.marvelapp.entity.DataContainer;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by artu on 3/8/17.
 */

public class CharacterDataContainer extends DataContainer implements Serializable {

    private static final long serialVersionUID = 1L;

    @SerializedName("results")
    private List<Character> results;

    public List<Character> getResults() {
        return results;
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }

}
