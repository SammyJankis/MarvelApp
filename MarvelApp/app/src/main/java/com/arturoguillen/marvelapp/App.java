package com.arturoguillen.marvelapp;

import android.app.Application;

import com.arturoguillen.marvelapp.di.component.DaggerFeedComponent;
import com.arturoguillen.marvelapp.di.component.FeedComponent;
import com.arturoguillen.marvelapp.di.module.ImageRequestModule;
import com.arturoguillen.marvelapp.di.module.MarvelModule;


/**
 * Created by artu on 3/8/17.
 */

public class App extends Application {

    private FeedComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = createComponent();
    }

    protected FeedComponent createComponent() {
        return DaggerFeedComponent.builder()
                .marvelModule(new MarvelModule())
                .imageRequestModule(new ImageRequestModule(this))
                .build();
    }

    public FeedComponent getComponent() {
        return component;
    }

}
