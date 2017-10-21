package com.arturoguillen.marvelapp.presenter.feed;

import android.view.View;

import com.arturoguillen.marvelapp.BuildConfig;
import com.arturoguillen.marvelapp.R;
import com.arturoguillen.marvelapp.entity.character.Character;
import com.arturoguillen.marvelapp.presenter.PresenterInterface;
import com.arturoguillen.marvelapp.view.feed.FeedItemOnClickListener;
import com.arturoguillen.marvelapp.view.feed.FeedView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * Created by agl on 19/10/2017.
 */

public class FeedPresenter implements PresenterInterface<FeedView>, FeedItemOnClickListener {

    private FeedView view;

    private Disposable getCharactersDisposable;

    @Inject
    public MarvelModel marvelModel;

    @Inject
    public FeedPresenter() {
    }

    public void getCharacters(String name) {
        view.showProgressFooter();
        getCharactersDisposable = marvelModel.getCharacters(name, new MarvelModel.ResponseObserver() {
            @Override
            public void onCompleted(List<Character> characters) {
                view.hideProgressFooter();
                view.hideMessage();
                view.showMoreData(characters);
            }

            @Override
            public void onError(Throwable e) {
                view.hideProgressFooter();
                view.showMessage(R.string.try_again);
                if (BuildConfig.DEBUG)
                    e.printStackTrace();
            }
        });
    }

    @Override
    public void attachView(FeedView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
        if (getCharactersDisposable != null)
            getCharactersDisposable.dispose();
    }

    @Override
    public void onClickFeedItem(View v, Character character) {
        view.goToDetailActivity(character);
    }
}
