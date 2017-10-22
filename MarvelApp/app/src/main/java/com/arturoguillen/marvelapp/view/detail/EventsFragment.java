package com.arturoguillen.marvelapp.view.detail;

/**
 * Created by agl on 21/10/2017.
 */

public class EventsFragment extends DetailListFragment {

    @Override
    public void onResume() {
        super.onResume();
        ((DetailActivity) getActivity()).onEventsLoaded();

    }
}
