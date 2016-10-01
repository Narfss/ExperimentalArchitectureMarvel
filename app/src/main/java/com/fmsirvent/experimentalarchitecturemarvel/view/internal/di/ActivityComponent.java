package com.fmsirvent.experimentalarchitecturemarvel.view.internal.di;

import com.fmsirvent.experimentalarchitecturemarvel.internal.di.ApplicationComponent;
import com.fmsirvent.experimentalarchitecturemarvel.view.characters.CharactersFragment;
import com.fmsirvent.experimentalarchitecturemarvel.view.favouritescharacters.FavouriteCharactersFragment;

import dagger.Component;

@Component(dependencies = ApplicationComponent.class,
           modules =  ActivityModule.class)
public interface ActivityComponent {
    void inject(FavouriteCharactersFragment view);
    void inject(CharactersFragment view);
}
