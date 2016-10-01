package com.fmsirvent.experimentalarchitecturemarvel.view.favouritescharacters;

import com.fmsirvent.experimentalarchitecturemarvel.logic.characters.MarvelCharacter;
import com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters.GetFavouriteCharactersUseCase;
import com.fmsirvent.experimentalarchitecturemarvel.view.characters.CharactersMapper;

import java.util.List;

import javax.inject.Inject;

public class FavouriteCharactersPresenter {
    private RenderFavouriteCharactersView view;
    private GetFavouriteCharactersUseCase getFavouritesCharactersUseCase;

    @Inject
    FavouriteCharactersPresenter(RenderFavouriteCharactersView view,
                                 GetFavouriteCharactersUseCase getFavouritesCharactersUseCase) {
        this.view = view;
        this.getFavouritesCharactersUseCase = getFavouritesCharactersUseCase;
    }

    void getFavouriteCharacters() {
        getFavouritesCharactersUseCase.execute(new GetFavouriteCharactersUseCase.Callback() {
            @Override
            public void onData(List<MarvelCharacter> characters) {
                view.renderFavouriteCharacters(CharactersMapper.map(characters));
            }
        });
    }
}
