package com.fmsirvent.experimentalarchitecturemarvel.logic.comics;

import com.fmsirvent.experimentalarchitecturemarvel.logic.dto.MarvelComic;

import java.util.List;

public interface GetCharacterComicsUseCase {
    void execute(long id,
                 int offset,
                 Callback callback);

    interface Callback {
        void onData(List<MarvelComic> marvelComics);
    }
}
