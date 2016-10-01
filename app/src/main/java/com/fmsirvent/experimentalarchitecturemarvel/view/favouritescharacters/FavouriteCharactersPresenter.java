package com.fmsirvent.experimentalarchitecturemarvel.view.favouritescharacters;

import com.fmsirvent.experimentalarchitecturemarvel.logic.characters.GetCharactersUseCase;
import com.fmsirvent.experimentalarchitecturemarvel.logic.characters.MarvelCharacter;
import com.fmsirvent.experimentalarchitecturemarvel.view.characters.CharactersMapper;

import java.util.List;

import javax.inject.Inject;

public class FavouriteCharactersPresenter {
    private RenderFavouriteCharactersView view;
    private GetCharactersUseCase getCharactersUseCase;

    @Inject
    FavouriteCharactersPresenter(RenderFavouriteCharactersView view,
                                 GetCharactersUseCase getCharactersUseCase) {
        this.view = view;
        this.getCharactersUseCase = getCharactersUseCase;
    }

    void getFavouriteCharacters() {
        getCharactersUseCase.execute(0, new GetCharactersUseCase.Callback() {
            @Override
            public void onData(List<MarvelCharacter> characters) {
                view.renderFavouriteCharacters(CharactersMapper.map(characters));
            }
        });
    }
}
