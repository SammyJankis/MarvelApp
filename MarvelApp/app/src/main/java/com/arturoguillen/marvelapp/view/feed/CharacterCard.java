package com.arturoguillen.marvelapp.view.feed;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.arturoguillen.marvelapp.R;
import com.arturoguillen.marvelapp.entity.character.Character;
import com.arturoguillen.marvelapp.view.PicassoView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by agl on 19/10/2017.
 */

class CharacterCard extends RecyclerView.ViewHolder {

    private static final String ASPECT_RATIO = "/portrait_incredible.";

    @BindView(R.id.layout_content)
    LinearLayout layoutContent;

    @BindView(R.id.feed_picasso)
    PicassoView feedPicasso;

    private Picasso picasso;
    private FeedItemOnClickListener feedItemOnClickListener;

    public CharacterCard(View itemView, Picasso picasso, FeedItemOnClickListener feedItemOnClickListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.picasso = picasso;
        this.feedItemOnClickListener = feedItemOnClickListener;
    }

    void fillCharacterCard(final Character character) {
        //feedPicasso.init(picasso, comic.getThumbnail().getPath() + ASPECT_RATIO + comic.getThumbnail().getExtension());
        layoutContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedItemOnClickListener.onClickFeedItem(itemView, character);
            }
        });

    }
}
