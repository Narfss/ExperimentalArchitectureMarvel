package com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters;

import com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter.FavouriteCharactersLocalRepository;

import javax.inject.Inject;

public class UnsubscribeToFavouriteCharactersUseCase {
    private final FavouriteCharactersLocalRepository favouriteCharactersLocalRepository;

    @Inject
    public UnsubscribeToFavouriteCharactersUseCase(FavouriteCharactersLocalRepository favouriteCharactersLocalRepository) {
        this.favouriteCharactersLocalRepository = favouriteCharactersLocalRepository;
    }

    public void execute(int subscriptionId) {
        favouriteCharactersLocalRepository.unsubscribe(subscriptionId);
    }
}
