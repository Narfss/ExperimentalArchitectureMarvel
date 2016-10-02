package com.fmsirvent.experimentalarchitecturemarvel.view.comic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.MenuItem;
import android.view.View;

import com.fmsirvent.experimentalarchitecturemarvel.Application;
import com.fmsirvent.experimentalarchitecturemarvel.R;
import com.fmsirvent.experimentalarchitecturemarvel.utils.ComicBackgroundImageView;
import com.fmsirvent.experimentalarchitecturemarvel.utils.ImageLoader;
import com.fmsirvent.experimentalarchitecturemarvel.view.base.BaseFragment;
import com.fmsirvent.experimentalarchitecturemarvel.view.comics.MarvelComicMVO;
import com.fmsirvent.experimentalarchitecturemarvel.view.images.MarvelImageMVO;
import com.fmsirvent.experimentalarchitecturemarvel.view.internal.di.ActivityModule;
import com.fmsirvent.experimentalarchitecturemarvel.view.internal.di.DaggerActivityComponent;

import javax.inject.Inject;

import butterknife.BindView;

public class ComicFragment extends BaseFragment implements RenderComicView {
    @Inject ComicPresenter presenter;
    @BindView(R.id.comic_background) ComicBackgroundImageView comicBackground;
    @BindView(R.id.comic_thumbnail) AppCompatImageView thumbnail;
    @BindView(R.id.title) AppCompatTextView title;
    @BindView(R.id.description) AppCompatTextView description;
    private static final String ARG_COMIC_ID = "comicId";
    private long comicId;

    public static Fragment newInstance(long comicId) {
        ComicFragment comicsFragment = new ComicFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(ARG_COMIC_ID, comicId);
        comicsFragment.setArguments(bundle);
        return comicsFragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_comic;
    }

    @Override
    protected void onRequestInjection() {
        DaggerActivityComponent
                .builder()
                .applicationComponent(Application.getInstance().getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);
        loadArguments();
        setupActionBar();
    }

    private void setupActionBar() {
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("");
        }
        setHasOptionsMenu(true);
    }

    private void setActionBarTitle(String title) {
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                    getActivity().finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void loadArguments() {
        Bundle arguments = getArguments();
        if (!arguments.containsKey(ARG_COMIC_ID)) {
            getActivity().finish();
        }
        comicId = arguments.getLong(ARG_COMIC_ID);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        requestComic();
    }

    private void requestComic() {
        presenter.getComic(comicId);
    }

    @Override
    public void renderComic(MarvelComicMVO comic) {
        if (isAdded() && !isRemoving()) {
            ImageLoader.loadImage(thumbnail, comic.getThumbnail().getURL(MarvelImageMVO.Original.DETAIL));
            title.setText(comic.getTitle());
            setActionBarTitle(comic.getTitle());
            description.setText(comic.getDescription());
            comicBackground.renderImages(comic.getImages());
        }
    }
}
