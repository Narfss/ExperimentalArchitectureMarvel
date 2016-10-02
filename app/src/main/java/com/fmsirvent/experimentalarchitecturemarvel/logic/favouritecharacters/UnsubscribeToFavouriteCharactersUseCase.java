package com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters;

import com.fmsirvent.experimentalarchitecturemarvel.logic.ThreadExecutor;
import com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter.FavouriteCharactersLocalRepository;

import javax.inject.Inject;

public class UnsubscribeToFavouriteCharactersUseCase implements Runnable {
    private final FavouriteCharactersLocalRepository favouriteCharactersLocalRepository;
    private final ThreadExecutor threadExecutor;
    private int subscriptionId;

    @Inject
    public UnsubscribeToFavouriteCharactersUseCase(FavouriteCharactersLocalRepository favouriteCharactersLocalRepository,
                                                   ThreadExecutor threadExecutor) {
        this.favouriteCharactersLocalRepository = favouriteCharactersLocalRepository;
        this.threadExecutor = threadExecutor;
    }

    public void execute(int subscriptionId) {
        this.subscriptionId = subscriptionId;
        threadExecutor.execute(this);
    }

    @Override
    public void run() {
        favouriteCharactersLocalRepository.unsubscribe(subscriptionId);
    }
}
