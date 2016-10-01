package com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter;

import com.fmsirvent.experimentalarchitecturemarvel.logic.characters.MarvelCharacter;
import com.fmsirvent.experimentalarchitecturemarvel.repository.exceptions.RepositoryException;
import com.fmsirvent.experimentalarchitecturemarvel.repository.local.orm.FavouriteCharactersORMController;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;


public class FavouriteCharactersDatabase  implements FavouriteCharactersLocalRepository {
    private Integer obserbableId = 0;
    private Map<Integer, Observer> observers;

    @Inject
    public FavouriteCharactersDatabase() {
        observers = new HashMap<>();
    }

    @Override
    public List<MarvelCharacter> getFavouriteCharacters() throws RepositoryException {
        FavouriteCharactersORMController ormController = new FavouriteCharactersORMController();
        List<FavouriteCharacterEntity> favouriteCharacters = null;
        try {
            favouriteCharacters = ormController.getFavouriteCharacters();
        } catch (SQLException e) {
            throw new RepositoryException();
        }
        return CharacterEntityMapper.map(favouriteCharacters);
    }

    @Override
    public void addOrUpdateFavouriteCharacters(FavouriteCharacterEntity character) throws RepositoryException {
        FavouriteCharactersORMController ormController = new FavouriteCharactersORMController();
        try {
            ormController.addOrUpdateFavouriteCharacters(character);
            FavouriteCharacterEntity favouriteCharacter = ormController.getFavouriteCharacter(character.getId());
            MarvelCharacter marvelCharacter = CharacterEntityMapper.map(favouriteCharacter);
            for (Observer observer : observers.values()) {
                observer.onChange();
            }
        } catch (SQLException e) {
            throw new RepositoryException();
        }
    }

    @Override
    public int subscribe(Observer observer) {
        obserbableId++;
        this.observers.put(obserbableId, observer);
        observer.onSubscribe(obserbableId);
        return obserbableId;
    }

    @Override
    public void unsubscribe(int subscriptionId) {
        observers.remove(subscriptionId);
    }
}
