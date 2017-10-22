package com.arturoguillen.marvelapp.presenter.detail;

import com.arturoguillen.marvelapp.BuildConfig;
import com.arturoguillen.marvelapp.model.MarvelModel;
import com.arturoguillen.marvelapp.presenter.PresenterInterface;
import com.arturoguillen.marvelapp.view.detail.DetailView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * Created by agl on 21/10/2017.
 */

public class DetailPresenter implements PresenterInterface<DetailView> {

    private DetailView view;
    private Disposable getComicsDisposable;
    private Disposable getEventsDisposable;

    @Inject
    public MarvelModel marvelModel;

    @Inject
    public DetailPresenter() {
    }

    @Override
    public void attachView(DetailView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if (getComicsDisposable != null)
            getComicsDisposable.dispose();
        if (getEventsDisposable != null)
            getEventsDisposable.dispose();
        this.view = null;
    }

    public void getComics(int characterId) {
        getComicsDisposable = marvelModel.getComics(characterId, new MarvelModel.ResponseObserver() {
            @Override
            public void onCompleted(List comics) {
                view.showComicsData(comics);
            }

            @Override
            public void onError(Throwable e) {
                if (BuildConfig.DEBUG)
                    e.printStackTrace();
            }
        });
    }

    public void getEvents(int characterId) {
        getEventsDisposable = marvelModel.getEvents(characterId, new MarvelModel.ResponseObserver() {
            @Override
            public void onCompleted(List events) {
                view.showEventsData(events);
            }

            @Override
            public void onError(Throwable e) {
                if (BuildConfig.DEBUG)
                    e.printStackTrace();
            }
        });
    }
}
