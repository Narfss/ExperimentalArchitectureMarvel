package com.fmsirvent.experimentalarchitecturemarvel.view.favouritescharacters;

import com.fmsirvent.experimentalarchitecturemarvel.view.characters.MarvelCharacterMVO;

import java.util.List;

public interface RenderFavouriteCharactersView {
    void renderFavouriteCharacters(List<MarvelCharacterMVO> characters);
    void renderNewFavouriteCharacter(MarvelCharacterMVO marvelCharacterMVO);
}
