package com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter;

import com.fmsirvent.experimentalarchitecturemarvel.logic.dto.MarvelCharacter;
import com.fmsirvent.experimentalarchitecturemarvel.repository.exceptions.RepositoryException;
import com.fmsirvent.experimentalarchitecturemarvel.repository.local.base.ObservableInterface;

import java.util.List;

public interface FavouriteCharactersLocalRepository extends ObservableInterface {
    List<MarvelCharacter> getFavouriteCharacters() throws RepositoryException;
    void addOrUpdateFavouriteCharacters(FavouriteCharacterEntity character) throws RepositoryException;
}
