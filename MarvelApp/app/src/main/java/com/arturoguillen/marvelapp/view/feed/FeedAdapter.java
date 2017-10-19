package com.arturoguillen.marvelapp.view.feed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.arturoguillen.marvelapp.R;
import com.arturoguillen.marvelapp.entity.Character;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by artu on 3/9/17.
 */

public class FeedAdapter extends RecyclerView.Adapter {

    private List<Character> feedContent;

    private Picasso picasso;
    private FeedItemOnClickListener feedItemOnClickListener;

    public FeedAdapter(Picasso picasso, FeedItemOnClickListener feedItemOnClickListener) {
        this.feedContent = new ArrayList<>();
        this.picasso = picasso;
        this.feedItemOnClickListener = feedItemOnClickListener;
    }

    public void setFeedContent(List<Character> feedContent) {
        this.feedContent.clear();
        this.feedContent.addAll(feedContent);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CharacterCard(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_feed_character, parent, false), picasso, feedItemOnClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CharacterCard) holder).fillCharacterCard(feedContent.get(position));
    }

    @Override
    public int getItemCount() {
        return feedContent.size();
    }
}
