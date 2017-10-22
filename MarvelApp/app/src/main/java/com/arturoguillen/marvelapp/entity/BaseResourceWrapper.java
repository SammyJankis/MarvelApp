package com.arturoguillen.marvelapp.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by agl on 21/10/2017.
 */

public class BaseResourceWrapper implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<BaseResource> resources;

    public List<BaseResource> getResources() {
        return resources;
    }

    public void setResources(List resources) {
        this.resources = resources;
    }
}
