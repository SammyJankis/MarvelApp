package com.arturoguillen.marvelapp.view.feed;

import android.view.View;

import com.arturoguillen.marvelapp.entity.Character;

/**
 * Created by agl on 19/10/2017.
 */

public interface FeedItemOnClickListener {
    void onClickFeedItem(View v, Character character);
}
