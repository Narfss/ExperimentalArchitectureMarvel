package com.fmsirvent.experimentalarchitecturemarvel.internal.di;

import com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter.FavouriteCharactersDatabase;
import com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter.FavouriteCharactersLocalRepository;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters.CharactersServerApi;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters.CharactersServerRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {
    @Provides
    CharactersServerRepository provideCharactersServerRepository(CharactersServerApi repository) {
        return repository;
    }

    @Provides @Singleton
    FavouriteCharactersLocalRepository provideFavouriteCharactersLocalRepository(FavouriteCharactersDatabase repository) {
        return repository;
    }
}
