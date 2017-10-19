package com.arturoguillen.marvelapp.presenter;


import com.arturoguillen.marvelapp.view.splash.SplashView;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by agl on 19/10/2017.
 */

public class SplashPresenter implements PresenterInterface<SplashView> {

    private SplashView view;

    private Disposable showLogoDisposable;

    @Inject
    public SplashPresenter() {
    }

    public void showLogo(int seconds) {
        showLogoDisposable = Observable.timer(seconds, TimeUnit.SECONDS, Schedulers.io())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Long>() {
                    @Override
                    public void onNext(Long value) {
                        view.goToFeedActivity();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void attachView(SplashView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
