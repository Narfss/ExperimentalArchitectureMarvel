package com.fmsirvent.experimentalarchitecturemarvel.view.favouritescharacters;

import com.fmsirvent.experimentalarchitecturemarvel.logic.characters.MarvelCharacter;
import com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters.GetFavouriteCharactersUseCase;
import com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters.SubscribeToFavouriteCharactersUseCase;
import com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters.UnsubscribeToFavouriteCharactersUseCase;
import com.fmsirvent.experimentalarchitecturemarvel.view.characters.CharactersViewMapper;
import com.fmsirvent.experimentalarchitecturemarvel.view.characters.MarvelCharacterMVO;

import java.util.List;

import javax.inject.Inject;

public class FavouriteCharactersPresenter {
    private RenderFavouriteCharactersView view;
    private GetFavouriteCharactersUseCase getFavouritesCharactersUseCase;
    private SubscribeToFavouriteCharactersUseCase subscribeToFavouriteCharactersUseCase;
    private UnsubscribeToFavouriteCharactersUseCase unsubscribeToFavouriteCharactersUseCase;
    private int subscriptionId;

    @Inject
    FavouriteCharactersPresenter(RenderFavouriteCharactersView view,
                                 GetFavouriteCharactersUseCase getFavouritesCharactersUseCase,
                                 SubscribeToFavouriteCharactersUseCase subscribeToFavouriteCharactersUseCase,
                                 UnsubscribeToFavouriteCharactersUseCase unsubscribeToFavouriteCharactersUseCase) {
        this.view = view;
        this.getFavouritesCharactersUseCase = getFavouritesCharactersUseCase;
        this.subscribeToFavouriteCharactersUseCase = subscribeToFavouriteCharactersUseCase;
        this.unsubscribeToFavouriteCharactersUseCase = unsubscribeToFavouriteCharactersUseCase;
    }

    void getFavouriteCharacters() {
        getFavouritesCharactersUseCase.execute(new GetFavouriteCharactersUseCase.Callback() {
            @Override
            public void onData(List<MarvelCharacter> characters) {
                view.renderFavouriteCharacters(CharactersViewMapper.map(characters));
            }
        });
    }

    void subscribeToFavouriteCharacters() {
        subscribeToFavouriteCharactersUseCase.execute(new SubscribeToFavouriteCharactersUseCase.Callback() {

            @Override
            public void onSubscribe(int subscriptionId) {
                FavouriteCharactersPresenter.this.subscriptionId = subscriptionId;
            }

            @Override
            public void onFavouriteAdded(MarvelCharacterMVO marvelCharacterMVO) {
                view.renderNewFavouriteCharacter(marvelCharacterMVO);
            }
        });
    }

    void unsubscribeToFavouriteCharacters() {
        unsubscribeToFavouriteCharactersUseCase.execute(subscriptionId);
    }
}
