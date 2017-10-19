package com.arturoguillen.marvelapp.presenter;

/**
 * Created by aguillen on 3/8/17.
 */

public interface PresenterInterface<V> {

    void attachView(V view);

    void detachView();

}
