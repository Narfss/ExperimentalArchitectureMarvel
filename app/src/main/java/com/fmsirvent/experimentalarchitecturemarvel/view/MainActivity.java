package com.fmsirvent.experimentalarchitecturemarvel.view;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import com.fmsirvent.experimentalarchitecturemarvel.R;
import com.fmsirvent.experimentalarchitecturemarvel.view.base.BaseActivity;
import com.fmsirvent.experimentalarchitecturemarvel.view.characters.CharactersFragment;
import com.fmsirvent.experimentalarchitecturemarvel.view.characters.MarvelCharacterMVO;
import com.fmsirvent.experimentalarchitecturemarvel.view.comics.ComicsFragment;
import com.fmsirvent.experimentalarchitecturemarvel.view.favouritescharacters.FavouriteCharactersFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements FavouriteCharacterSelected {
    @BindView(R.id.characters_parent) View charactersParent;
    @BindView(R.id.introduction) View introduction;
    private FavouriteCharactersFragment favouriteCharactersFragment;
    private CharactersFragment charactersFragment;
    private ComicsFragment comicsFragment;
    boolean showCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupFavouriteFragment();
        setupCharactersFragment();
        setupComicsFragment();
        ButterKnife.bind(this);
    }

    @OnClick(R.id.add_character)
    void toggleCharactersList() {
        showCharacters = !showCharacters;
        evaluateView();
    }

    private void evaluateView() {
        introduction.setVisibility(View.GONE);
        charactersParent.setVisibility(showCharacters ? View.VISIBLE : View.GONE);
    }

    private void setupCharactersFragment() {
        if (charactersFragment == null) {
            charactersFragment = CharactersFragment.newInstance();
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.characters, charactersFragment);
        ft.commit();
    }

    private void setupComicsFragment() {
        if (comicsFragment == null) {
            comicsFragment = ComicsFragment.newInstance();
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content, comicsFragment);
        ft.commit();
    }

    private void setupFavouriteFragment() {
        favouriteCharactersFragment = FavouriteCharactersFragment.newInstance();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.favourite_characters, favouriteCharactersFragment);
        ft.commit();
    }

    @Override
    public void onSelected(MarvelCharacterMVO character) {
        showCharacters = false;
        evaluateView();
        comicsFragment.setCharacterSelected(character);
    }
}
