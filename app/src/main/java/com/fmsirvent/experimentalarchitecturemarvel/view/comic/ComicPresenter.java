package com.fmsirvent.experimentalarchitecturemarvel.view.comic;

import android.support.annotation.NonNull;

import com.fmsirvent.experimentalarchitecturemarvel.logic.comic.GetComicByIdUseCase;
import com.fmsirvent.experimentalarchitecturemarvel.logic.dto.MarvelComic;
import com.fmsirvent.experimentalarchitecturemarvel.view.comics.ComicsViewMapper;

import javax.inject.Inject;

public class ComicPresenter {
    private GetComicByIdUseCase getComicUseCase;
    private RenderComicView view;

    @Inject
    ComicPresenter(GetComicByIdUseCase getComicUseCase,
                   RenderComicView view) {
        this.getComicUseCase = getComicUseCase;
        this.view = view;
    }

    void getComic(long comicId) {
        getComicUseCase.execute(comicId, getCallback());
    }

    @NonNull
    private GetComicByIdUseCase.Callback getCallback() {
        return new GetComicByIdUseCase.Callback(){
            @Override
            public void onData(MarvelComic marvelComics) {
                view.renderComic(ComicsViewMapper.map(marvelComics));
            }
        };
    }
}
