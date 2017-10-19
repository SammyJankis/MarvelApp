package com.arturoguillen.marvelapp.view.feed;

import android.support.annotation.StringRes;

import com.arturoguillen.marvelapp.entity.character.Character;

import java.util.List;

/**
 * Created by agl on 19/10/2017.
 */

public interface FeedView {
    void showProgressFooter();

    void hideProgressFooter();

    void showMessage(@StringRes int stringId);

    void hideMessage();

    void showMoreData(List<Character> characters);

    void goToDetailActivity();

}
