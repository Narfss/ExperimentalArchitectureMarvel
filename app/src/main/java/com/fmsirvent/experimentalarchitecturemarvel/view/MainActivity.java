package com.fmsirvent.experimentalarchitecturemarvel.view;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import com.fmsirvent.experimentalarchitecturemarvel.R;
import com.fmsirvent.experimentalarchitecturemarvel.view.base.BaseActivity;
import com.fmsirvent.experimentalarchitecturemarvel.view.characters.CharactersFragment;
import com.fmsirvent.experimentalarchitecturemarvel.view.favouritescharacters.FavouriteCharactersFragment;

public class MainActivity extends BaseActivity {
    private FavouriteCharactersFragment favouriteCharactersFragment;
    private CharactersFragment charactersFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupCharactersFragment();
        setupFavouriteFragment();
    }

    private void setupCharactersFragment() {
        charactersFragment = CharactersFragment.newInstance();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.characters, charactersFragment);
        ft.commit();
    }

    private void setupFavouriteFragment() {
        favouriteCharactersFragment = FavouriteCharactersFragment.newInstance();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.favourite_characters, favouriteCharactersFragment);
        ft.commit();
    }
}
