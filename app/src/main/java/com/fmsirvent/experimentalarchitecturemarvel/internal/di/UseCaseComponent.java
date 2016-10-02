package com.fmsirvent.experimentalarchitecturemarvel.internal.di;

import com.fmsirvent.experimentalarchitecturemarvel.logic.characters.GetCharactersUseCase;
import com.fmsirvent.experimentalarchitecturemarvel.logic.comic.GetComicByIdUseCase;
import com.fmsirvent.experimentalarchitecturemarvel.logic.comics.GetCharacterComicsUseCase;
import com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters.AddFavouriteCharacterUseCase;
import com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters.GetFavouriteCharactersUseCase;
import com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters.SubscribeToFavouriteCharactersUseCase;
import com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters.UnsubscribeToFavouriteCharactersUseCase;

public interface UseCaseComponent {
    GetCharactersUseCase provideGetCharactersUseCase();
    GetComicByIdUseCase provideGetComicByIdUseCase();
    GetCharacterComicsUseCase provideGetCharacterComicsUseCase();
    AddFavouriteCharacterUseCase provideAddFavouriteCharacterUseCase();
    GetFavouriteCharactersUseCase provideGetFavouriteCharactersUseCase();
    SubscribeToFavouriteCharactersUseCase provideSubscribeToFavouriteCharactersUseCase();
    UnsubscribeToFavouriteCharactersUseCase provideUnsubscribeToFavouriteCharactersUseCase();
}
