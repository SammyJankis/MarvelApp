package com.arturoguillen.marvelapp.view.feed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.arturoguillen.marvelapp.R;
import com.arturoguillen.marvelapp.entity.character.Character;
import com.arturoguillen.marvelapp.view.BaseAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by artu on 3/9/17.
 */

public class FeedAdapter extends BaseAdapter {


    private FeedItemOnClickListener feedItemOnClickListener;

    public FeedAdapter(Picasso picasso, List<Character> content, FeedItemOnClickListener feedItemOnClickListener) {
        super(picasso, content);
        this.feedItemOnClickListener = feedItemOnClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FeedCard(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_feed_character, parent, false), picasso, feedItemOnClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((FeedCard) holder).fillCharacterCard((Character) content.get(position));
    }
}
