package com.fmsirvent.experimentalarchitecturemarvel.view.internal.di;

import com.fmsirvent.experimentalarchitecturemarvel.view.characters.CharactersFragment;
import com.fmsirvent.experimentalarchitecturemarvel.view.characters.RenderCharactersView;
import com.fmsirvent.experimentalarchitecturemarvel.view.comics.ComicsFragment;
import com.fmsirvent.experimentalarchitecturemarvel.view.comics.RenderComicsView;
import com.fmsirvent.experimentalarchitecturemarvel.view.favouritescharacters.FavouriteCharactersFragment;
import com.fmsirvent.experimentalarchitecturemarvel.view.favouritescharacters.RenderFavouriteCharactersView;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private FavouriteCharactersFragment favouriteCharactersFragment;
    private CharactersFragment charactersFragment;
    private ComicsFragment comicsFragment;

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

    public ActivityModule(ComicsFragment comicsFragment) {
        this.comicsFragment = comicsFragment;
    }

    @Provides
    public RenderComicsView providesComicsView() {
        return comicsFragment;
    }

}