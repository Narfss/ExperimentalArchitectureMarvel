package com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters;

import com.fmsirvent.experimentalarchitecturemarvel.logic.characters.MarvelCharacter;
import com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter.FavouriteCharactersLocalRepository;
import com.fmsirvent.experimentalarchitecturemarvel.view.characters.CharactersMapper;
import com.fmsirvent.experimentalarchitecturemarvel.view.characters.MarvelCharacterMVO;

import javax.inject.Inject;

import rx.Observer;

public class SubscribeToFavouriteCharactersUseCase {
    private final FavouriteCharactersLocalRepository favouriteCharactersLocalRepository;
    private Callback callback;
    private Observer<MarvelCharacter>
            observer = new Observer<MarvelCharacter>() {
                @Override
                public void onCompleted() { }

                @Override
                public void onError(Throwable e) { }

                @Override
                public void onNext(MarvelCharacter marvelCharacter) {
                    callback.onFavouriteAdded(CharactersMapper.map(marvelCharacter));
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
        void onFavouriteAdded(MarvelCharacterMVO marvelCharacterMVO);
    }
}
