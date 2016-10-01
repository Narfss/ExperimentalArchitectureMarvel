package com.fmsirvent.experimentalarchitecturemarvel.internal.di;

import com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter.FavouriteCharactersDatabase;
import com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter.FavouriteCharactersLocalRepository;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters.CharactersServerApi;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters.CharactersServerRepository;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.comics.ComicsServerApi;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.comics.ComicsServerRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {
    @Provides
    CharactersServerRepository provideCharactersServerRepository(CharactersServerApi repository) {
        return repository;
    }

    @Provides
    ComicsServerRepository provideComicsServerRepository(ComicsServerApi repository) {
        return repository;
    }

    @Provides @Singleton
    FavouriteCharactersLocalRepository provideFavouriteCharactersLocalRepository(FavouriteCharactersDatabase repository) {
        return repository;
    }
}
