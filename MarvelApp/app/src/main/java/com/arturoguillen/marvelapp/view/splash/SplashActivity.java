package com.arturoguillen.marvelapp.view.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.arturoguillen.marvelapp.R;
import com.arturoguillen.marvelapp.di.component.FeedComponent;
import com.arturoguillen.marvelapp.presenter.splash.SplashPresenter;
import com.arturoguillen.marvelapp.view.BaseActivity;
import com.arturoguillen.marvelapp.view.feed.FeedActivity;

import javax.inject.Inject;

/**
 * Created by agl on 19/10/2017.
 */

public class SplashActivity extends BaseActivity implements SplashView {

    @Inject
    SplashPresenter presenter;

    private static final int LOGO_DURATION = 2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.attachView(this);
        setContentView(R.layout.activity_splash);
        presenter.showLogo(LOGO_DURATION);
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    @Override
    protected void injectComponent(FeedComponent component) {
        component.inject(this);
    }

    @Override
    public void goToFeedActivity() {
        startActivity(FeedActivity.createIntent(SplashActivity.this));
    }
}
