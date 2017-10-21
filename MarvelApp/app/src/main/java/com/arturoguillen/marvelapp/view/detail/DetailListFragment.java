package com.arturoguillen.marvelapp.view.detail;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arturoguillen.marvelapp.R;
import com.arturoguillen.marvelapp.entity.BaseResourceWrapper;

import butterknife.ButterKnife;

/**
 * Created by agl on 21/10/2017.
 */

public class DetailListFragment extends Fragment {

    private static final String EXTRA_BASERESOURCEWRAPPER = "EXTRA_BASERESOURCEWRAPPER";

    private BaseResourceWrapper baseResourceWrapper;

    public static DetailListFragment newInstance(BaseResourceWrapper baseResourceWrapper) {
        DetailListFragment fragment = new DetailListFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_BASERESOURCEWRAPPER, baseResourceWrapper);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null) {
            throw new RuntimeException("You must to send a baseResourceWrapper ");
        }
        baseResourceWrapper = (BaseResourceWrapper) getArguments().getSerializable(EXTRA_BASERESOURCEWRAPPER);

    }

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_list, container, false);

        ButterKnife.bind(this, view);

        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new ItemRecyclerViewAdapter(dummyModels, interactionListener));
        return view;
    }*/


}
