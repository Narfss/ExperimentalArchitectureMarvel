package com.fmsirvent.experimentalarchitecturemarvel.view.comic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.Toast;

import com.fmsirvent.experimentalarchitecturemarvel.Application;
import com.fmsirvent.experimentalarchitecturemarvel.R;
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
    @BindView(R.id.comic_thumbnail) AppCompatImageView thumbnail;
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
            Toast.makeText(getContext(), comic.getTitle(), Toast.LENGTH_SHORT).show();
        }
    }
}
