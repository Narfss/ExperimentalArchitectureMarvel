package com.fmsirvent.experimentalarchitecturemarvel.logic.characters;

import com.fmsirvent.experimentalarchitecturemarvel.logic.images.ImageMapper;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters.CharacterDataResponse;

import java.util.ArrayList;
import java.util.List;

public class CharactersMapper {
    public static List<MarvelCharacter> map(List<CharacterDataResponse> results) {
        List<MarvelCharacter> marvelCharacters = new ArrayList<>();
        for (CharacterDataResponse characterDataResponse : results) {
            marvelCharacters.add(map(characterDataResponse));
        }
        return marvelCharacters;
    }

    public static MarvelCharacter map(CharacterDataResponse characterDataResponse) {
        MarvelCharacter.Builder builder = new MarvelCharacter.Builder();
        return builder.setId(characterDataResponse.getId())
                      .setName(characterDataResponse.getName())
                      .setDescription(characterDataResponse.getDescription())
                      .setModified(characterDataResponse.getModified())
                      .setThumbnail(ImageMapper.map(characterDataResponse.getThumbnail()))
                      .build();
    }
}
