package com.arturoguillen.marvelapp.view.detail;

import android.os.Bundle;

/**
 * Created by agl on 21/10/2017.
 */

public class EventsFragment extends DetailListFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((DetailActivity) getActivity()).onEventsLoaded();
    }
}
