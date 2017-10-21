package com.arturoguillen.marvelapp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.arturoguillen.marvelapp.App;
import com.arturoguillen.marvelapp.di.component.FeedComponent;


/**
 * Created by artu on 3/8/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectComponent(((App) getApplication())
                .getComponent());
    }

    protected abstract void injectComponent(FeedComponent component);


}
