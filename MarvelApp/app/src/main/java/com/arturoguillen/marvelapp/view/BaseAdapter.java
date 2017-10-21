package com.arturoguillen.marvelapp.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.arturoguillen.marvelapp.R;
import com.arturoguillen.marvelapp.entity.BaseResource;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by artu on 3/9/17.
 */

public class BaseAdapter extends RecyclerView.Adapter {

    public List<BaseResource> content;
    public Picasso picasso;

    public BaseAdapter(Picasso picasso, List content) {
        this.content = content;
        this.picasso = picasso;
    }

    public void setFeedContent(List content) {
        this.content.clear();
        this.content.addAll(content);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseCard(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_feed_character, parent, false), picasso);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BaseCard) holder).fillBaseResourceCard(content.get(position));
    }

    @Override
    public int getItemCount() {
        return content.size();
    }
}
