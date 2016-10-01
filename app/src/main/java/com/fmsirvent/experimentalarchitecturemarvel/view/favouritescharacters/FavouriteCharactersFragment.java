package com.fmsirvent.experimentalarchitecturemarvel.view.favouritescharacters;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.fmsirvent.experimentalarchitecturemarvel.Application;
import com.fmsirvent.experimentalarchitecturemarvel.R;
import com.fmsirvent.experimentalarchitecturemarvel.view.base.BaseFragment;
import com.fmsirvent.experimentalarchitecturemarvel.view.characters.CharacterRenderer;
import com.fmsirvent.experimentalarchitecturemarvel.view.characters.MarvelCharacterMVO;
import com.fmsirvent.experimentalarchitecturemarvel.view.internal.di.ActivityModule;
import com.fmsirvent.experimentalarchitecturemarvel.view.internal.di.DaggerActivityComponent;
import com.pedrogomez.renderers.AdapteeCollection;
import com.pedrogomez.renderers.ListAdapteeCollection;
import com.pedrogomez.renderers.RVRendererAdapter;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class FavouriteCharactersFragment extends BaseFragment implements RenderFavouriteCharactersView {
    @Inject FavouriteCharactersPresenter presenter;
    @BindView(R.id.favourite_characters) RecyclerView recyclerView;
    private RVRendererAdapter<MarvelCharacterMVO> adapter;
    private LinearLayoutManager layoutManager;
    private boolean loading;

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
        configureRecycleView();
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
        loading = true;
        presenter.getFavouriteCharacters();
    }

    @Override
    public void renderFavouriteCharacters(List<MarvelCharacterMVO> characters) {
        if (adapter != null) {
            adapter.addAll(characters);
            adapter.notifyDataSetChanged();
            loading = false;
        }
    }


    private void configureRecycleView() {
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        AdapteeCollection<MarvelCharacterMVO> adapterCollection = new ListAdapteeCollection<>();
        RendererBuilder<MarvelCharacterMVO> rendererBuilder = new FavouriteCharacterRendererBuilder();
        adapter = new RVRendererAdapter<>(rendererBuilder, adapterCollection);
        recyclerView.setAdapter(adapter);
    }
}
