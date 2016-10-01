package com.fmsirvent.experimentalarchitecturemarvel.repository.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter.FavouriteCharacterEntity;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class ORMHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "marvel_ormlite.db";
    private static final int DATABASE_VERSION = 1;

    private Dao<FavouriteCharacterEntity, Integer> favouriteCharacterEntityDao;

    public ORMHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, FavouriteCharacterEntity.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        onCreate(sqLiteDatabase, connectionSource);
    }

    public Dao<FavouriteCharacterEntity, Integer> getFavouriteCharacterEntityDao() throws SQLException {
        if (favouriteCharacterEntityDao == null) {
            favouriteCharacterEntityDao = getDao(FavouriteCharacterEntity.class);
        }
        return favouriteCharacterEntityDao;
    }

    @Override
    public void close() {
        super.close();
        favouriteCharacterEntityDao = null;
    }
}
