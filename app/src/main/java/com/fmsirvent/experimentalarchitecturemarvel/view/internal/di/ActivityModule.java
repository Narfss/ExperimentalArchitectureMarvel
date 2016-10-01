package com.fmsirvent.experimentalarchitecturemarvel.view.internal.di;

import com.fmsirvent.experimentalarchitecturemarvel.view.characters.CharactersFragment;
import com.fmsirvent.experimentalarchitecturemarvel.view.characters.RenderCharactersView;
import com.fmsirvent.experimentalarchitecturemarvel.view.favouritescharacters.FavouriteCharactersFragment;
import com.fmsirvent.experimentalarchitecturemarvel.view.favouritescharacters.RenderFavouriteCharactersView;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private FavouriteCharactersFragment favouriteCharactersFragment;
    private CharactersFragment charactersFragment;

    public ActivityModule() { }

    public ActivityModule(FavouriteCharactersFragment favouriteCharactersFragment) {
        this.favouriteCharactersFragment = favouriteCharactersFragment;
    }

    @Provides
    public RenderFavouriteCharactersView providesFavouriteCharactersView() {
        return favouriteCharactersFragment;
    }

    public ActivityModule(CharactersFragment charactersFragment) {
        this.charactersFragment = charactersFragment;
    }

    @Provides
    public RenderCharactersView providesCharactersView() {
        return charactersFragment;
    }
}