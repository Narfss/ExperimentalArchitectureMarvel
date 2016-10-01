package com.fmsirvent.experimentalarchitecturemarvel.view.favouritescharacters;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.fmsirvent.experimentalarchitecturemarvel.Application;
import com.fmsirvent.experimentalarchitecturemarvel.R;
import com.fmsirvent.experimentalarchitecturemarvel.view.base.BaseFragment;
import com.fmsirvent.experimentalarchitecturemarvel.view.characters.MarvelCharacterMVO;
import com.fmsirvent.experimentalarchitecturemarvel.view.internal.di.ActivityModule;
import com.fmsirvent.experimentalarchitecturemarvel.view.internal.di.DaggerActivityComponent;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class FavouriteCharactersFragment extends BaseFragment implements RenderFavouriteCharactersView {
    @Inject FavouriteCharactersPresenter presenter;
    @BindView(R.id.favourite_characters) RecyclerView recyclerView;

    public static FavouriteCharactersFragment newInstance() {
        return new FavouriteCharactersFragment();
    }

    @Override
    @LayoutRes
    protected int getLayout() {
        return R.layout.favourite_characters;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        requestFavouriteCharacters();
    }

    @Override
    protected void onRequestInjection() {
        DaggerActivityComponent
                .builder()
                .applicationComponent(Application.getInstance().getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);
    }

    private void requestFavouriteCharacters() {
        presenter.getFavouriteCharacters();
    }

    @Override
    public void renderFavouriteCharacters(List<MarvelCharacterMVO> characters) {
        Toast.makeText(getContext(), "MOLA: " + characters.size(), Toast.LENGTH_SHORT).show();
    }
}
