package com.fmsirvent.experimentalarchitecturemarvel.repository.local.orm;

import com.fmsirvent.experimentalarchitecturemarvel.repository.local.ORMHelper;
import com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter.FavouriteCharacterEntity;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class FavouriteCharactersORMController extends ORMController {
    public List<FavouriteCharacterEntity> getFavouriteCharacters() throws SQLException {
        List<FavouriteCharacterEntity> favouriteCharacterEntities = Collections.emptyList();
        ORMHelper ormHelper = getHelper();
        if (ormHelper != null) {
            Dao<FavouriteCharacterEntity, Integer> dao = ormHelper.getFavouriteCharacterEntityDao();
            favouriteCharacterEntities = dao.queryBuilder()
                    .orderBy(FavouriteCharacterEntity.TIMESTAMP, false)
                    .query();
        }
        return favouriteCharacterEntities;
    }

    public FavouriteCharacterEntity getFavouriteCharacter(long id) throws SQLException {
        FavouriteCharacterEntity favouriteCharacterEntities = null;
        ORMHelper ormHelper = getHelper();
        if (ormHelper != null) {
            Dao<FavouriteCharacterEntity, Integer> dao = ormHelper.getFavouriteCharacterEntityDao();
            favouriteCharacterEntities = dao.queryBuilder()
                    .where()
                    .eq(FavouriteCharacterEntity.ID, id)
                    .queryForFirst();
        }
        return favouriteCharacterEntities;
    }

    public void addOrUpdateFavouriteCharacters(FavouriteCharacterEntity character) throws SQLException {
        ORMHelper ormHelper = getHelper();
        if (ormHelper != null) {
            Dao<FavouriteCharacterEntity, Integer> dao = ormHelper.getFavouriteCharacterEntityDao();
            dao.createOrUpdate(character);
        }
    }
}
