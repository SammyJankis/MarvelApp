package com.arturoguillen.marvelapp.view.detail;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.arturoguillen.marvelapp.Constants;
import com.arturoguillen.marvelapp.R;
import com.arturoguillen.marvelapp.di.component.FeedComponent;
import com.arturoguillen.marvelapp.entity.Url;
import com.arturoguillen.marvelapp.entity.character.Character;
import com.arturoguillen.marvelapp.entity.comic.Comic;
import com.arturoguillen.marvelapp.entity.event.Event;
import com.arturoguillen.marvelapp.presenter.detail.DetailPresenter;
import com.arturoguillen.marvelapp.view.BaseActivity;
import com.arturoguillen.marvelapp.view.PicassoView;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by agl on 19/10/2017.
 */

public class DetailActivity extends BaseActivity implements DetailView {

    private static final String EXTRA_CHARACTER = "EXTRA_CHARACTER";

    private Character character;

    @Inject
    DetailPresenter presenter;

    @Inject
    Picasso picasso;

    @BindView(R.id.image)
    PicassoView image;

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.description)
    TextView description;

    @BindView(R.id.detail_button_fragment_events)
    Button buttonEvents;

    @BindView(R.id.detail_button_fragment_comics)
    Button buttonComics;

    ComicsFragment comicsFragment;
    EventsFragment eventsFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.attachView(this);

        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        character = getCharacterExtra(savedInstanceState);
        initUI(character);
    }

    private void initUI(Character character) {
        image.init(picasso, character.getThumbnail().getPath() + Constants.ASPECT_RATIO + character.getThumbnail().getExtension());
        name.setText(character.getName());
        description.setText(character.getDescription());

        comicsFragment = new ComicsFragment();
        eventsFragment = new EventsFragment();
        setComicsFragmentVisible();

        buttonComics.setText(getString(R.string.button_fragment_comics, 0));
        buttonEvents.setText(getString(R.string.button_fragment_events, 0));
    }

    private Character getCharacterExtra(Bundle savedInstanceState) {
        Character character;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                character = null;
            } else {
                character = (Character) extras.get(EXTRA_CHARACTER);
            }
        } else {
            character = (Character) savedInstanceState.get(EXTRA_CHARACTER);
        }
        return character;
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    public static Intent createIntent(Context context, Character character) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_CHARACTER, character);
        return intent;
    }

    @OnClick(R.id.detail_button_detail)
    public void detailClick() {
        for (Url url : character.getUrls()) {
            if (url.getType().equals("detail")) {
                goToBrowser(url.getUrl());
                break;
            }
        }
    }

    @OnClick(R.id.detail_button_wiki)
    public void wikiClick() {
        for (Url url : character.getUrls()) {
            if (url.getType().equals("wiki")) {
                goToBrowser(url.getUrl());
                break;
            }
        }
    }

    @OnClick(R.id.detail_button_comics)
    public void comicsClick() {
        for (Url url : character.getUrls()) {
            if (url.getType().equals("comiclink")) {
                goToBrowser(url.getUrl());
                break;
            }
        }
    }

    @Override
    protected void injectComponent(FeedComponent component) {
        component.inject(this);
    }

    private void goToBrowser(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

    @OnClick(R.id.detail_button_fragment_comics)
    public void comicsFragmentClick() {
        setComicsFragmentVisible();
    }

    @OnClick(R.id.detail_button_fragment_events)
    public void eventsFragmentClick() {
        setEventsFragmentVisible();
    }

    @Override
    public void showComicsData(List<Comic> comics) {
        buttonComics.setText(getString(R.string.button_fragment_comics, comics.size()));
        comicsFragment.setData(comics);
    }

    @Override
    public void showEventsData(List<Event> events) {
        buttonEvents.setText(getString(R.string.button_fragment_events, events.size()));
        eventsFragment.setData(events);
    }


    private void setComicsFragmentVisible() {
        getSupportFragmentManager().beginTransaction().replace(R.id.detail_fragment_container, comicsFragment).commit();
      //  getSupportFragmentManager().beginTransaction().remove(eventsFragment).commit();
    }

    private void setEventsFragmentVisible() {
       // getSupportFragmentManager().beginTransaction().add(R.id.detail_fragment_container, eventsFragment).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.detail_fragment_container, eventsFragment).commit();
       // getSupportFragmentManager().beginTransaction().remove(comicsFragment).commit();
    }

    public void onComicsLoaded() {
        presenter.getComics(character.getId());
    }

    public void onEventsLoaded() {
        presenter.getEvents(character.getId());
    }
}
