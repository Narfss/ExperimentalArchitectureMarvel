package com.fmsirvent.experimentalarchitecturemarvel.view.comics;

import android.support.annotation.NonNull;

import com.fmsirvent.experimentalarchitecturemarvel.logic.comics.GetCharacterComicsUseCase;
import com.fmsirvent.experimentalarchitecturemarvel.logic.comics.MarvelComic;
import com.fmsirvent.experimentalarchitecturemarvel.view.characters.MarvelCharacterMVO;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ComicsPresenter {
    private GetCharacterComicsUseCase getCharacterComicsUseCase;
    private RenderComicsView view;
    List<MarvelComicMVO> comicsMVO;
    private long id;
    boolean idset;

    @Inject
    ComicsPresenter(GetCharacterComicsUseCase getCharacterComicsUseCase,
                    RenderComicsView view) {
        this.getCharacterComicsUseCase = getCharacterComicsUseCase;
        this.view = view;
        comicsMVO = new ArrayList<>();
    }

    public void setCharacter(MarvelCharacterMVO character) {
        id = character.getId();
        comicsMVO = new ArrayList<>();
        idset = true;
    }

    void getComics() {
        if (idset) {
            getCharacterComicsUseCase.execute(id,
                                              comicsMVO.size(),
                                              getCallback());
        }
    }

    @NonNull
    private GetCharacterComicsUseCase.Callback getCallback() {
        return new GetCharacterComicsUseCase.Callback(){
            @Override
            public void onData(List<MarvelComic> marvelComics) {
                List<MarvelComicMVO> marvelComicMVOs = ComicsViewMapper.map(marvelComics);
                comicsMVO.addAll(marvelComicMVOs);
                view.renderComics(comicsMVO);
            }
        };
    }
}
