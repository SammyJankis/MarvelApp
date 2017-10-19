package com.arturoguillen.marvelapp.di.api;


import com.arturoguillen.marvelapp.entity.character.CharacterDataWrapper;
import com.arturoguillen.marvelapp.entity.comic.ComicDataWrapper;
import com.arturoguillen.marvelapp.entity.event.EventDataWrapper;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
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

    @GET("characters/{characterId}/comics")
    Observable<ComicDataWrapper> getComicsByCharacter(
            @Path("characterId") int characterId,
            @Query("apikey") String apiKey,
            @Query("ts") String timestamp,
            @Query("hash") String hash,
            @Query("offset") String offset);

    @GET("characters/{characterId}/events")
    Observable<EventDataWrapper> getEventsByCharacter(
            @Path("characterId") int characterId,
            @Query("apikey") String apiKey,
            @Query("ts") String timestamp,
            @Query("hash") String hash,
            @Query("offset") String offset);
}
