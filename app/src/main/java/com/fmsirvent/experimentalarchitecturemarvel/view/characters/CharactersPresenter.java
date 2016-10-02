package com.fmsirvent.experimentalarchitecturemarvel.view.characters;

import android.support.annotation.NonNull;

import com.fmsirvent.experimentalarchitecturemarvel.logic.characters.GetCharactersUseCase;
import com.fmsirvent.experimentalarchitecturemarvel.logic.dto.MarvelCharacter;
import com.fmsirvent.experimentalarchitecturemarvel.logic.favouritecharacters.AddFavouriteCharacterUseCase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CharactersPresenter {
    private RenderCharactersView view;
    private GetCharactersUseCase getCharactersUseCase;
    private AddFavouriteCharacterUseCase addFavouriteCharacterUseCase;
    List<MarvelCharacterMVO> charactersMVO;

    @Inject
    CharactersPresenter(RenderCharactersView view,
                        GetCharactersUseCase getCharactersUseCase, AddFavouriteCharacterUseCase addFavouriteCharacterUseCase) {
        this.view = view;
        this.getCharactersUseCase = getCharactersUseCase;
        this.addFavouriteCharacterUseCase = addFavouriteCharacterUseCase;
        charactersMVO = new ArrayList<>();
    }

    void getCharacters() {
        getCharactersUseCase.execute(charactersMVO.size(), getCallback());
    }

    @NonNull
    private GetCharactersUseCase.Callback getCallback() {
        return new GetCharactersUseCase.Callback() {
            @Override
            public void onData(List<MarvelCharacter> characters) {
                charactersMVO.addAll(CharactersViewMapper.map(characters));
                view.renderCharacters(charactersMVO);
            }
        };
    }

    void addCharacter(MarvelCharacterMVO character) {
        addFavouriteCharacterUseCase.execute(CharactersViewMapper.map(character));
    }
}
