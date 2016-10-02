package com.fmsirvent.experimentalarchitecturemarvel.logic.comic;

import com.fmsirvent.experimentalarchitecturemarvel.logic.dto.MarvelComic;

public interface GetComicByIdUseCase {
    void execute(long id,
                 Callback callback);

    interface Callback {
        void onData(MarvelComic marvelComics);
    }
}
