package com.fmsirvent.experimentalarchitecturemarvel.view.characters;

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
import com.fmsirvent.experimentalarchitecturemarvel.view.internal.di.ActivityModule;
import com.fmsirvent.experimentalarchitecturemarvel.view.internal.di.DaggerActivityComponent;
import com.pedrogomez.renderers.AdapteeCollection;
import com.pedrogomez.renderers.ListAdapteeCollection;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class CharactersFragment extends BaseFragment implements RenderCharactersView {
    @Inject CharactersPresenter presenter;
    @BindView(R.id.characters) RecyclerView recyclerView;
    private ClickableRVRendererAdapter<MarvelCharacterMVO> adapter;
    private LinearLayoutManager layoutManager;
    private boolean loading;

    public static CharactersFragment newInstance() {
        return new CharactersFragment();
    }

    @Override
    @LayoutRes
    protected int getLayout() {
        return R.layout.fragment_characters;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        configureRecycleView();
        requestCharacters();
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

    private void requestCharacters() {
        loading = true;
        presenter.getCharacters();
    }

    @Override
    public void renderCharacters(List<MarvelCharacterMVO> characters) {
        if (adapter != null) {
            adapter.replace(characters);
            adapter.notifyDataSetChanged();
            loading = false;
        }
    }

    private void configureRecycleView() {
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if(dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();
                    if (!loading
                        && (visibleItemCount + pastVisibleItems) >= totalItemCount) {
                        requestCharacters();
                    }
                }
            }
        });
        AdapteeCollection<MarvelCharacterMVO> adapteeCollection = new ListAdapteeCollection<>();
        RendererBuilder<MarvelCharacterMVO> rendererBuilder = new CharacterRendererBuilder();
        adapter = new ClickableRVRendererAdapter<>(rendererBuilder, adapteeCollection);
        adapter.setOnItemClick(new ClickableRVRendererAdapter.OnItemClick() {
            @Override
            public void onItemClick(int position) {
                presenter.addCharacter(adapter.getItem(position));
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
