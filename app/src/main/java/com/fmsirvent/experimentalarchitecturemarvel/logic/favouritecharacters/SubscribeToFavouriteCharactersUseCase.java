package com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters;

import com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter.FavouriteCharactersLocalRepository;

import javax.inject.Inject;


public class SubscribeToFavouriteCharactersUseCase {
    private final FavouriteCharactersLocalRepository favouriteCharactersLocalRepository;
    private Callback callback;
    private FavouriteCharactersLocalRepository.Observer
            observer = new FavouriteCharactersLocalRepository.Observer() {
                            @Override
                            public void onChange() {
                                callback.onChange();
                            }

                            @Override
                            public void onSubscribe(int subscribeId) {
                                callback.onSubscribe(subscribeId);
                            }
                        };

    @Inject
    public SubscribeToFavouriteCharactersUseCase(FavouriteCharactersLocalRepository favouriteCharactersLocalRepository) {
        this.favouriteCharactersLocalRepository = favouriteCharactersLocalRepository;
    }

    public void execute(Callback callback) {
        this.callback = callback;
        callback.onSubscribe(favouriteCharactersLocalRepository.subscribe(observer));
    }

    public interface Callback {
        void onSubscribe(int subscriptionId);
        void onChange();
    }
}
