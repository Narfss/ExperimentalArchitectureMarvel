package com.fmsirvent.experimentalarchitecturemarvel.internal.di;

import com.fmsirvent.experimentalarchitecturemarvel.repository.local.favouritecharacter.FavouriteCharactersLocalRepository;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters.CharactersServerRepository;

public interface RepositoriesComponent {
    FavouriteCharactersLocalRepository provideFavouriteCharactersLocalRepository();
    CharactersServerRepository provideCharactersServerRepository();
}
