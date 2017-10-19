package com.arturoguillen.marvelapp.view.feed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arturoguillen.marvelapp.R;
import com.arturoguillen.marvelapp.di.component.FeedComponent;
import com.arturoguillen.marvelapp.entity.character.Character;
import com.arturoguillen.marvelapp.presenter.feed.FeedPresenter;
import com.arturoguillen.marvelapp.view.BaseActivity;
import com.arturoguillen.marvelapp.view.detail.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by agl on 19/10/2017.
 */

public class FeedActivity extends BaseActivity implements FeedView {

    @Inject
    FeedPresenter presenter;

    @Inject
    Picasso picasso;

    @BindView(R.id.feed_progress)
    ProgressBar progress;

    @BindView(R.id.feed_recyclerview)
    RecyclerView recyclerView;

    @BindView(R.id.feed_text_message)
    TextView textMessage;

    @BindView(R.id.feed_search)
    EditText editText;

    @Override
    protected void injectComponent(FeedComponent component) {
        component.inject(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.attachView(this);
        setContentView(R.layout.activity_feed);

        ButterKnife.bind(this);

        setupRecyclerView();

        editText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable editable) {
                if (editable.length() > 3)
                    presenter.getCharacters(editable.toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }

    private void setupRecyclerView() {
        FeedAdapter feedAdapter = new FeedAdapter(picasso, presenter);
        recyclerView.setAdapter(feedAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    }


    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, FeedActivity.class);
    }

    @Override
    public void showProgressFooter() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressFooter() {
        progress.setVisibility(View.GONE);
    }


    @Override
    public void showMessage(@StringRes int stringId) {
        textMessage.setVisibility(View.VISIBLE);
        textMessage.setText(getText(stringId));
    }

    @Override
    public void hideMessage() {
        textMessage.setVisibility(View.GONE);
    }

    @Override
    public void showMoreData(List<Character> characters) {

    }

    @Override
    public void goToDetailActivity() {
        startActivity(DetailActivity.createIntent(FeedActivity.this));
    }
}
