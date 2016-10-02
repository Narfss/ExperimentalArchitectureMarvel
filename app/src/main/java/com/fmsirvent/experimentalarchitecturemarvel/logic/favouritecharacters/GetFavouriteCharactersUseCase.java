package com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters;

import com.fmsirvent.experimentalarchitecturemarvel.logic.dto.MarvelCharacter;

import java.util.List;

public interface GetFavouriteCharactersUseCase {
    void execute(Callback callback);

    interface Callback {
        void onData(List<MarvelCharacter> characters);
    }
}
