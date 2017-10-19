package com.arturoguillen.marvelapp.di.component;


import com.arturoguillen.marvelapp.di.module.ImageRequestModule;
import com.arturoguillen.marvelapp.di.module.MarvelModule;
import com.arturoguillen.marvelapp.view.detail.DetailActivity;
import com.arturoguillen.marvelapp.view.feed.FeedActivity;
import com.arturoguillen.marvelapp.view.splash.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by artu on 3/8/17.
 */

@Singleton
@Component(modules = {MarvelModule.class, ImageRequestModule.class})
public interface FeedComponent {
    void inject(SplashActivity splashActivity);

    void inject(FeedActivity feedActivity);

    void inject(DetailActivity detailActivity);
}
