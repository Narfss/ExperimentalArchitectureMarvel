package com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter;

import com.fmsirvent.experimentalarchitecturemarvel.logic.characters.MarvelCharacter;
import com.fmsirvent.experimentalarchitecturemarvel.repository.exceptions.RepositoryException;

import java.util.List;

import rx.Observer;

public interface FavouriteCharactersLocalRepository {
    List<MarvelCharacter> getFavouriteCharacters() throws RepositoryException;
    void addOrUpdateFavouriteCharacters(FavouriteCharacterEntity character) throws RepositoryException;
    int subscribe(Observer<MarvelCharacter> subscriber);
    void unsubscribe(int subscriptionId);
}
