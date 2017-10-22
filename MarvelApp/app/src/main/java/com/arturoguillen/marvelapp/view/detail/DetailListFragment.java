package com.arturoguillen.marvelapp.view.detail;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arturoguillen.marvelapp.R;
import com.arturoguillen.marvelapp.di.component.FeedComponent;
import com.arturoguillen.marvelapp.entity.BaseResource;
import com.arturoguillen.marvelapp.view.BaseAdapter;
import com.arturoguillen.marvelapp.view.BaseFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by agl on 21/10/2017.
 */

public class DetailListFragment extends BaseFragment {

    @BindView(R.id.fragment_recyclerview)
    RecyclerView recyclerView;

    @Inject
    Picasso picasso;

    @Override
    protected void injectComponent(FeedComponent component) {
        component.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_list, container, false);
        ButterKnife.bind(this, view);
        setupRecyclerView(view.getContext());

        return view;
    }

    private void setupRecyclerView(Context context) {
        BaseAdapter baseAdapter = new BaseAdapter(picasso, new ArrayList<BaseResource>());
        recyclerView.setAdapter(baseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    }


    public void setData(List resources) {
        ((BaseAdapter) recyclerView.getAdapter()).setFeedContent(resources);
    }
}
