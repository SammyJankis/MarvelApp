package com.arturoguillen.marvelapp.view.feed;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arturoguillen.marvelapp.Constants;
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


    @BindView(R.id.card_feed_character_content)
    LinearLayout content;

    @BindView(R.id.image)
    PicassoView image;

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.description)
    TextView description;

    private Picasso picasso;
    private FeedItemOnClickListener feedItemOnClickListener;

    public CharacterCard(View itemView, Picasso picasso, FeedItemOnClickListener feedItemOnClickListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.picasso = picasso;
        this.feedItemOnClickListener = feedItemOnClickListener;
    }

    void fillCharacterCard(final Character character) {
        image.init(picasso, character.getThumbnail().getPath() + Constants.ASPECT_RATIO + character.getThumbnail().getExtension());
        name.setText(character.getName());
        description.setText(character.getDescription());
        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedItemOnClickListener.onClickFeedItem(itemView, character);
            }
        });

    }
}
