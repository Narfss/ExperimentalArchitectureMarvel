package com.fmsirvent.experimentalarchitecturemarvel.internal.di;

import com.fmsirvent.experimentalarchitecturemarvel.logic.characters.GetCharactersInteractor;
import com.fmsirvent.experimentalarchitecturemarvel.logic.characters.GetCharactersUseCase;
import com.fmsirvent.experimentalarchitecturemarvel.logic.comic.GetComicByIdInteractor;
import com.fmsirvent.experimentalarchitecturemarvel.logic.comic.GetComicByIdUseCase;
import com.fmsirvent.experimentalarchitecturemarvel.logic.comics.GetCharacterComicsInteractor;
import com.fmsirvent.experimentalarchitecturemarvel.logic.comics.GetCharacterComicsUseCase;
import com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters.AddFavouriteCharacterInteractor;
import com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters.AddFavouriteCharacterUseCase;
import com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters.GetFavouriteCharactersInteractor;
import com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters.GetFavouriteCharactersUseCase;
import com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters.SubscribeToFavouriteCharactersInteractor;
import com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters.SubscribeToFavouriteCharactersUseCase;
import com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters.UnsubscribeToFavouriteCharactersInteractor;
import com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters.UnsubscribeToFavouriteCharactersUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class UseCaseModule {
    @Provides
    GetCharactersUseCase provideGetCharactersUseCase(GetCharactersInteractor useCase) {
        return useCase;
    }

    @Provides
    GetComicByIdUseCase provideGetComicByIdUseCase(GetComicByIdInteractor useCase) {
        return useCase;
    }

    @Provides
    GetCharacterComicsUseCase provideGetCharacterComicsUseCase(GetCharacterComicsInteractor useCase) {
        return useCase;
    }

    @Provides
    AddFavouriteCharacterUseCase provideAddFavouriteCharacterUseCase(AddFavouriteCharacterInteractor useCase) {
        return useCase;
    }

    @Provides
    GetFavouriteCharactersUseCase provideGetFavouriteCharactersUseCase(GetFavouriteCharactersInteractor useCase) {
        return useCase;
    }

    @Provides
    SubscribeToFavouriteCharactersUseCase provideSubscribeToFavouriteCharactersUseCase(SubscribeToFavouriteCharactersInteractor useCase) {
        return useCase;
    }

    @Provides
    UnsubscribeToFavouriteCharactersUseCase provideUnsubscribeToFavouriteCharactersUseCase(UnsubscribeToFavouriteCharactersInteractor useCase) {
        return useCase;
    }
}
