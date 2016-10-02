package com.fmsirvent.experimentalarchitecturemarvel.logic.characters;

import com.fmsirvent.experimentalarchitecturemarvel.logic.dto.MarvelCharacter;

import java.util.List;

public interface GetCharactersUseCase {
    void execute(int offset, Callback callback);

    interface Callback {
        void onData(List<MarvelCharacter> characters);
    }
}
