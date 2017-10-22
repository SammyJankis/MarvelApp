package com.arturoguillen.marvelapp.model;


import com.arturoguillen.marvelapp.Constants;
import com.arturoguillen.marvelapp.di.api.MarvelApi;
import com.arturoguillen.marvelapp.entity.character.CharacterDataWrapper;
import com.arturoguillen.marvelapp.entity.comic.ComicDataWrapper;
import com.arturoguillen.marvelapp.entity.event.EventDataWrapper;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by artu on 3/8/17.
 */

public class MarvelModel extends BaseModel {

    @Inject
    public MarvelApi marvelApi;

    @Inject
    public MarvelModel() {
    }

    public interface ResponseObserver {

        void onCompleted(List resources);

        void onError(Throwable e);
    }

    public Disposable getCharacters(String name, final ResponseObserver observer) {

        String timestamp = String.valueOf(System.currentTimeMillis());
        try {
            String hash = md5(timestamp + Constants.PRIVATE_KEY + Constants.PUBLIC_KEY);

            Observable<CharacterDataWrapper> observable = marvelApi.getCharacters(name, Constants.PUBLIC_KEY, timestamp, hash);

            return observable.
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).
                    cache().
                    subscribeWith(new DisposableObserver<CharacterDataWrapper>() {
                        @Override
                        public void onNext(CharacterDataWrapper characterDataWrapper) {
                            observer.onCompleted(characterDataWrapper.getData().getResults());
                        }

                        @Override
                        public void onError(Throwable e) {
                            observer.onError(e);
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } catch (NoSuchAlgorithmException e) {
            observer.onError(e);
            e.printStackTrace();
            return null;
        }
    }

    public Disposable getComics(int characterId, final ResponseObserver observer) {

        String timestamp = String.valueOf(System.currentTimeMillis());
        try {
            String hash = md5(timestamp + Constants.PRIVATE_KEY + Constants.PUBLIC_KEY);

            Observable<ComicDataWrapper> observable = marvelApi.getComicsByCharacter(characterId, Constants.PUBLIC_KEY, timestamp, hash);

            return observable.
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).
                    cache().
                    subscribeWith(new DisposableObserver<ComicDataWrapper>() {
                        @Override
                        public void onNext(ComicDataWrapper comicDataWrapper) {
                            observer.onCompleted(comicDataWrapper.getData().getResults());
                        }

                        @Override
                        public void onError(Throwable e) {
                            observer.onError(e);
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } catch (NoSuchAlgorithmException e) {
            observer.onError(e);
            e.printStackTrace();
            return null;
        }
    }

    public Disposable getEvents(int characterId, final ResponseObserver observer) {

        String timestamp = String.valueOf(System.currentTimeMillis());
        try {
            String hash = md5(timestamp + Constants.PRIVATE_KEY + Constants.PUBLIC_KEY);

            Observable<EventDataWrapper> observable = marvelApi.getEventsByCharacter(characterId, Constants.PUBLIC_KEY, timestamp, hash);

            return observable.
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).
                    cache().
                    subscribeWith(new DisposableObserver<EventDataWrapper>() {
                        @Override
                        public void onNext(EventDataWrapper eventDataWrapper) {
                            observer.onCompleted(eventDataWrapper.getData().getResults());
                        }

                        @Override
                        public void onError(Throwable e) {
                            observer.onError(e);
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } catch (NoSuchAlgorithmException e) {
            observer.onError(e);
            e.printStackTrace();
            return null;
        }
    }
}
