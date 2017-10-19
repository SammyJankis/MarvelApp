package com.arturoguillen.marvelapp.di.module;


import com.arturoguillen.marvelapp.di.api.MarvelApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by artu on 3/8/17.
 */

@Module
public class MarvelModule extends NetModule {

    @Provides
    @Singleton
    MarvelApi provideMarvelApi(Retrofit retrofit) {
        return retrofit.create(MarvelApi.class);
    }
}
