package com.arturoguillen.marvelapp.view.feed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.arturoguillen.marvelapp.R;
import com.arturoguillen.marvelapp.di.component.FeedComponent;
import com.arturoguillen.marvelapp.view.BaseActivity;

/**
 * Created by agl on 19/10/2017.
 */

public class FeedActivity extends BaseActivity {

    @Override
    protected void injectComponent(FeedComponent component) {
        component.inject(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

    }

    public static Intent createIntent(Context context) {
        return new Intent(context, FeedActivity.class);
    }
}
