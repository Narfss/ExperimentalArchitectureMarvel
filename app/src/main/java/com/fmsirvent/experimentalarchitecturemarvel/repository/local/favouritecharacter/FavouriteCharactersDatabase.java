package com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter;

import com.fmsirvent.experimentalarchitecturemarvel.logic.dto.MarvelCharacter;
import com.fmsirvent.experimentalarchitecturemarvel.repository.exceptions.RepositoryException;
import com.fmsirvent.experimentalarchitecturemarvel.repository.local.base.ObservableDatabase;
import com.fmsirvent.experimentalarchitecturemarvel.repository.local.orm.FavouriteCharactersORMController;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;


public class FavouriteCharactersDatabase extends ObservableDatabase implements FavouriteCharactersLocalRepository {
    @Inject
    public FavouriteCharactersDatabase() { }

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
            notifyChange();
        } catch (SQLException e) {
            throw new RepositoryException();
        }
    }
}
