package com.fmsirvent.experimentalarchitecturemarvel.view.comics;

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
import com.fmsirvent.experimentalarchitecturemarvel.view.comic.ComicActivity;
import com.fmsirvent.experimentalarchitecturemarvel.view.internal.di.ActivityModule;
import com.fmsirvent.experimentalarchitecturemarvel.view.internal.di.DaggerActivityComponent;
import com.pedrogomez.renderers.AdapteeCollection;
import com.pedrogomez.renderers.ListAdapteeCollection;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class ComicsFragment extends BaseFragment implements RenderComicsView {
    @Inject ComicsPresenter presenter;
    @BindView(R.id.comics) RecyclerView recyclerView;
    private ClickableRVRendererAdapter<MarvelComicMVO> adapter;
    private LinearLayoutManager layoutManager;
    private boolean loading;

    public static ComicsFragment newInstance() {
        return new ComicsFragment();
    }

    @Override
    @LayoutRes
    protected int getLayout() {
        return R.layout.fragment_comics;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        configureRecycleView();
        requestComics();
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

    private void requestComics() {
        loading = true;
        presenter.getComics();
    }

    @Override
    public void renderComics(List<MarvelComicMVO> marvelComics) {
        if (adapter != null
            && isAdded()
            && !isRemoving()) {
            adapter.replace(marvelComics);
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
                        requestComics();
                    }
                }
            }
        });
        AdapteeCollection<MarvelComicMVO> adapterCollection = new ListAdapteeCollection<>();
        RendererBuilder<MarvelComicMVO> rendererBuilder = new ComicsRendererBuilder();
        adapter = new ClickableRVRendererAdapter<>(rendererBuilder, adapterCollection);
        adapter.setOnItemClick(new ClickableRVRendererAdapter.OnItemClick() {
            @Override
            public void onItemClick(int position) {
                MarvelComicMVO comic = adapter.getItem(position);
                startActivity(ComicActivity.newIntent(getContext(), comic));
            }
        });
        recyclerView.setAdapter(adapter);
    }

    public void setCharacterSelected(MarvelCharacterMVO character) {
        presenter.setCharacter(character);
        if (isAdded() && !isRemoving()) {
            requestComics();
        }
    }
}
