package com.arturoguillen.marvelapp.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.arturoguillen.marvelapp.App;
import com.arturoguillen.marvelapp.di.component.FeedComponent;

/**
 * Created by agl on 21/10/2017.
 */

public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectComponent(((App) getActivity().getApplication())
                .getComponent());
    }

    protected abstract void injectComponent(FeedComponent component);
}
