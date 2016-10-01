package com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter;

import com.fmsirvent.experimentalarchitecturemarvel.logic.characters.MarvelCharacter;
import com.fmsirvent.experimentalarchitecturemarvel.repository.exceptions.RepositoryException;
import com.fmsirvent.experimentalarchitecturemarvel.repository.local.orm.FavouriteCharactersORMController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;

public class FavouriteCharactersDatabase implements FavouriteCharactersLocalRepository {
    private Integer obserbableId = 0;
    private Map<Integer, Observer<MarvelCharacter>> observers;

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
            Observable<MarvelCharacter> obserbable = Observable.just(marvelCharacter);
            for (Observer<MarvelCharacter> observer : observers.values()) {
                obserbable.subscribe(observer);
            }
        } catch (SQLException e) {
            throw new RepositoryException();
        }
    }

    @Override
    public int subscribe(Observer<MarvelCharacter> observer) {
        obserbableId++;
        this.observers.put(obserbableId, observer);
        return obserbableId;
    }

    @Override
    public void unsubscribe(int subscriptionId) {
        observers.remove(subscriptionId);
    }
}
