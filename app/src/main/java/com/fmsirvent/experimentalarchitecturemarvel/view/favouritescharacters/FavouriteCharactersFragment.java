package com.fmsirvent.experimentalarchitecturemarvel.view.favouritescharacters;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fmsirvent.experimentalarchitecturemarvel.Application;
import com.fmsirvent.experimentalarchitecturemarvel.R;
import com.fmsirvent.experimentalarchitecturemarvel.utils.ClickableRVRendererAdapter;
import com.fmsirvent.experimentalarchitecturemarvel.view.base.BaseFragment;
import com.fmsirvent.experimentalarchitecturemarvel.view.characters.MarvelCharacterMVO;
import com.fmsirvent.experimentalarchitecturemarvel.view.internal.di.ActivityModule;
import com.fmsirvent.experimentalarchitecturemarvel.view.internal.di.DaggerActivityComponent;
import com.pedrogomez.renderers.AdapteeCollection;
import com.pedrogomez.renderers.ListAdapteeCollection;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class FavouriteCharactersFragment extends BaseFragment implements RenderFavouriteCharactersView {
    @Inject FavouriteCharactersPresenter presenter;
    @BindView(R.id.favourite_characters) RecyclerView recyclerView;
    private ClickableRVRendererAdapter<MarvelCharacterMVO> adapter;
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

    @Override
    public void onStart() {
        super.onStart();
        presenter.subscribeToFavouriteCharacters();
    }

    @Override
    public void onStop() {
        presenter.unsubscribeToFavouriteCharacters();
        super.onStop();
    }

    private void requestFavouriteCharacters() {
        loading = true;
        presenter.getFavouriteCharacters();
    }

    @Override
    public void renderFavouriteCharacters(List<MarvelCharacterMVO> characters) {
        if (adapter != null) {
            adapter.replace(characters);
            adapter.notifyDataSetChanged();
            loading = false;
        }
    }

    @Override
    public void renderNewFavouriteCharacter(MarvelCharacterMVO marvelCharacterMVO) {
        requestFavouriteCharacters();
    }

    private void configureRecycleView() {
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        AdapteeCollection<MarvelCharacterMVO> adapterCollection = new ListAdapteeCollection<>();
        RendererBuilder<MarvelCharacterMVO> rendererBuilder = new FavouriteCharacterRendererBuilder();
        adapter = new ClickableRVRendererAdapter<>(rendererBuilder, adapterCollection);
        adapter.setOnItemClick(new ClickableRVRendererAdapter.OnItemClick() {
            @Override
            public void onItemClick(int position) {

            }
        });
        recyclerView.setAdapter(adapter);
    }
}
