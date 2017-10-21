package com.arturoguillen.marvelapp.presenter.detail;

import com.arturoguillen.marvelapp.presenter.PresenterInterface;
import com.arturoguillen.marvelapp.view.detail.DetailView;

import javax.inject.Inject;

/**
 * Created by agl on 21/10/2017.
 */

public class DetailPresenter implements PresenterInterface<DetailView> {

    private DetailView view;

    @Inject
    public DetailPresenter() {
    }

    @Override
    public void attachView(DetailView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
