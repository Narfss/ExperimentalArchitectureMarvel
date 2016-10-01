package com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter;

import com.fmsirvent.experimentalarchitecturemarvel.logic.characters.MarvelCharacter;
import com.fmsirvent.experimentalarchitecturemarvel.repository.exceptions.RepositoryException;
import com.fmsirvent.experimentalarchitecturemarvel.repository.local.orm.FavouriteCharactersORMController;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

public class FavouriteCharactersDatabase implements FavouriteCharactersLocalRepository {

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
        } catch (SQLException e) {
            throw new RepositoryException();
        }
    }
}
