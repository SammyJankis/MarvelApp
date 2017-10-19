package com.arturoguillen.marvelapp.di.api;


import com.arturoguillen.marvelapp.entity.CharacterDataWrapper;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by artu on 3/8/17.
 */

public interface MarvelApi {

    @GET("characters")
    Observable<CharacterDataWrapper> getCharacters(
            @Query("nameStartsWith") String name,
            @Query("apikey") String apiKey,
            @Query("ts") String timestamp,
            @Query("hash") String hash);
}
