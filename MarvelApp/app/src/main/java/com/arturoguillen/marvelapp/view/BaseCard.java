package com.arturoguillen.marvelapp.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.arturoguillen.marvelapp.Constants;
import com.arturoguillen.marvelapp.R;
import com.arturoguillen.marvelapp.entity.BaseResource;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by agl on 19/10/2017.
 */

public class BaseCard extends RecyclerView.ViewHolder {

    @BindView(R.id.image)
    PicassoView image;

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.description)
    TextView description;

    protected Picasso picasso;

    public BaseCard(View itemView, Picasso picasso) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.picasso = picasso;
    }

    public void fillBaseResourceCard(final BaseResource baseResource) {
        image.init(picasso, baseResource.getThumbnail().getPath() + Constants.ASPECT_RATIO + baseResource.getThumbnail().getExtension());
        name.setText(baseResource.getName());
        description.setText(baseResource.getDescription());
    }
}
