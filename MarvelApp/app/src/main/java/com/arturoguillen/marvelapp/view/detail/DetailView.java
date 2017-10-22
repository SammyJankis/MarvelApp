package com.arturoguillen.marvelapp.view.detail;

import com.arturoguillen.marvelapp.entity.comic.Comic;
import com.arturoguillen.marvelapp.entity.event.Event;

import java.util.List;

/**
 * Created by agl on 21/10/2017.
 */

public interface DetailView {

    void showComicsData(List<Comic> comics);

    void showEventsData(List<Event> events);

}
