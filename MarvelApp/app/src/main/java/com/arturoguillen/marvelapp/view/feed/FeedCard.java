package com.arturoguillen.marvelapp.view.feed;

import android.view.View;
import android.widget.LinearLayout;

import com.arturoguillen.marvelapp.R;
import com.arturoguillen.marvelapp.entity.character.Character;
import com.arturoguillen.marvelapp.view.BaseCard;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

/**
 * Created by agl on 19/10/2017.
 */

class FeedCard extends BaseCard {

    @BindView(R.id.card_feed_character_content)
    LinearLayout content;

    private FeedItemOnClickListener feedItemOnClickListener;

    public FeedCard(View itemView, Picasso picasso, FeedItemOnClickListener feedItemOnClickListener) {
        super(itemView, picasso);
        this.feedItemOnClickListener = feedItemOnClickListener;
    }

    public void fillCharacterCard(final Character character) {
        super.fillBaseResourceCard(character);
        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedItemOnClickListener.onClickFeedItem(itemView, character);
            }
        });

    }
}
